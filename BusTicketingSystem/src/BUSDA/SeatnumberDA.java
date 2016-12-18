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
import BUSDOMAIN.Seatnumber;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class SeatnumberDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Seatnumber";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public SeatnumberDA() {
        createConnection();
    }

    public ArrayList<Seatnumber> getAllRecord() {
        ArrayList<Seatnumber> seatnumberList = new ArrayList<Seatnumber>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Seatnumber seatnumber = new Seatnumber(rs.getString(1), rs.getString(2));
                seatnumberList.add(seatnumber);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in SeatnumberDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seatnumberList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE seatid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in SeatnumberDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Seatnumber getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE seatid = ?";
        Seatnumber seatnumber = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                seatnumber = new Seatnumber(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in SeatnumberDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seatnumber;
    }

    public void addRecord(Seatnumber s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?, ?)";

        try {
            ResultSet rs = selectRecord(s.getSeatid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getSeatid());
                stmt.setString(2, s.getSeatnumber());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in SeatnumberDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Seatnumber s) {
        String queryStr = "Update " + tableName + " set BOARDPOINT = ? WHERE seatid = ?";

        try {
            ResultSet rs = selectRecord(s.getSeatid());

            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getSeatnumber());
                stmt.setString(2, s.getSeatid());

                stmt.executeUpdate();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in SeatnumberDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(Seatnumber s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE seatid = ?";
        try {
            ResultSet rs = selectRecord(s.getSeatid());

            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getSeatid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in SeatnumberDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void createConnection() {
        String sqlStr;
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY seatid";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(" ***TRACE: Counter Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in CounterDA " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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

    public static void main(String[] args) {
        System.out.println("SeatnumberDA successfully launched");
    }
}
