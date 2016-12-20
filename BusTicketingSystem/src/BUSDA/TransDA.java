/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

/**
 *
 * @author Student
 */
import BUSDOMAIN.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.*;

public class TransDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Trans";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlStr;
    private ResultSet rs;

    public TransDA() {
        createConnection();
    }

    public ArrayList<Trans> getAllRecord() {
        ArrayList<Trans> transList = new ArrayList<Trans>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cancelchange cc = new Cancelchange(rs.getString(2));
                Staff stf = new Staff(rs.getString(3));
                Counter counter = new Counter(rs.getString(4));
                Paymenttype pt = new Paymenttype(rs.getString(6));
                Trans trans = new Trans(rs.getString(1), cc, stf, counter,
                        rs.getString(5), pt, rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDouble(11),
                        rs.getDouble(12), rs.getTimestamp(13));
                transList.add(trans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in StaffDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return transList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE transid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in TransDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Trans getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE transid = ?";
        Trans trans = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cancelchange cc = new Cancelchange(rs.getString(2));
                Staff stf = new Staff(rs.getString(3));
                Counter counter = new Counter(rs.getString(4));
                Paymenttype pt = new Paymenttype(rs.getString(6));
                trans = new Trans(rs.getString(1), cc, stf, counter,
                        rs.getString(5), pt, rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDouble(11),
                        rs.getDouble(12), rs.getTimestamp(13));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return trans;
    }

    public void addRecord(Trans s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {

            ResultSet rs = selectRecord(s.getTransid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getTransid());
                stmt.setString(2, null);
                stmt.setString(3, s.getStaffid().getStaffid());
                stmt.setString(4, s.getCounterid().getCounterid());
                stmt.setString(5, s.getPaidstatus());
                stmt.setString(6, s.getPymtid().getPymtid());
                stmt.setString(7, s.getCustname());
                stmt.setString(8, s.getContactnum());
                stmt.setString(9, s.getCreditcardnumber());
                stmt.setString(10, s.getDiscounttype());
                stmt.setString(11, s.getDiscountamount() + "");
                stmt.setString(12, s.getTtlamount() + "");
                stmt.setTimestamp(13, s.getTransdate());
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + s.getTransid() + " is inserted Successful in database.\n");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voidRecord(String transID) {

        try {
            ResultSet rs = selectRecord(transID);
            if (rs.next()) {
                stmt = conn.prepareStatement("UPDATE " + tableName + " SET PAIDSTATUS =  'VOID' WHERE TRANSID = ?");
                stmt.setString(1, transID);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + transID + " is Void Successful in database.\n");
                JOptionPane.showMessageDialog(null, LocalDateTime.now() + transID + " is successfuly VOID in database.\n", "DATABASE UPDATE successfully", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println(LocalDateTime.now() + " No such Transaction ID in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY TRANSID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getAfterLastCode() {
        try {
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY TRANSID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        String transID = "";
        int id;
        try {
            if (conn != null) {
                rs.last();
                transID = rs.getString("TRANSID");
                id = Integer.parseInt(transID.substring(1));
                id += 1;
                transID = String.format("T%05d", id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in getting last code: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return transID;
    }

    public static void main(String[] args) {
        TransDA transDA = new TransDA();
    }
}
