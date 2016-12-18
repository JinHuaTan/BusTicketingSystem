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

public class DriverlistDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Driverlist";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlStr;
    private ResultSet rs;

    public DriverlistDA() {
        createConnection();
    }

    public ArrayList<Driverlist> getAllRecord() {
        ArrayList<Driverlist> driverlistList = new ArrayList<Driverlist>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Staff stf = new Staff(rs.getString(2));
                Driverlist driverlist = new Driverlist(rs.getString(1), stf, rs.getString(3), rs.getString(4));
                driverlistList.add(driverlist);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in DriverlistDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return driverlistList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE driid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in DriverlistDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Driverlist getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE driid = ?";
        Driverlist driverlist = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Staff stf = new Staff(rs.getString(2));
                driverlist = new Driverlist(rs.getString(1), stf, rs.getString(3), rs.getString(4));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return driverlist;
    }

    public void addRecord(Driverlist s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?)";

        try {

            ResultSet rs = selectRecord(s.getDriid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getDriid());
                stmt.setString(2, s.getDriverid().getStaffid());
                stmt.setString(3, s.getDescofchange());
                stmt.setString(4, s.getDristatus());;

                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + s.getDriid() + " is inserted Successful in database.\n");
            }

        } catch (SQLException ex) {
            ex.getMessage();

        }
    }

    public void updateRecord(Driverlist s){
        String queryStr = "Update " + tableName + " set DRIVERID = ? , DESCOFCHANGE = ? , DRISTATUS = ? WHERE driid = ?";

        try {
            ResultSet rs = selectRecord(s.getDriid());

            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                
                stmt.setString(1, s.getDriverid().getStaffid());
                stmt.setString(2, s.getDescofchange());
                stmt.setString(3, s.getDristatus());
                stmt.setString(4, s.getDriid());
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + s.getDriid() + " is inserted Successful in database.\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in DriverlistDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Driverlist s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE driid = ?";

        try {
            ResultSet rs = selectRecord(s.getDriid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getDriid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY DRIID";
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
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY DRIID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        String driID = "";
        int id;
        try {
            if (conn != null) {
                rs.last();
                driID = rs.getString("DRIID");
                id = Integer.parseInt(driID.substring(1));
                id += 1;
                driID = String.format("D%05d", id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in getting last code: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return driID;
    }

    public static void main(String[] args) {
        System.out.println("StaffDA successfully launched");
    }
}
