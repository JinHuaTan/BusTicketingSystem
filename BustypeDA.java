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
import BUSDOMAIN.Bustype;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class BustypeDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Bustype";
    private Connection conn;
    private PreparedStatement stmt;

    public BustypeDA() {
        createConnection();
    }

    public ArrayList<Bustype> getAllRecord() {
        ArrayList<Bustype> bustypeList = new ArrayList<Bustype>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bustype bustype = new Bustype(rs.getString(1), rs.getString(2), rs.getInt(3));
                bustypeList.add(bustype);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in BustypeDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bustypeList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE bustypeid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in BustypeDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Bustype getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE bustypeid = ?";
        Bustype bustype = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bustype = new Bustype(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in BustypeDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bustype;
    }

    public void addRecord(Bustype s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";

        try {
            ResultSet rs = selectRecord(s.getBustypeid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBustypeid());
                stmt.setString(2, s.getBustype());
                stmt.setInt(3, s.getNoofseat());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in BustypeDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Bustype s) {
        String queryStr = "Update " + tableName + " set BOARDPOINT = ?, SEATNUMBER = ? WHERE BDPID = ?";

        try {
            ResultSet rs = selectRecord(s.getBustypeid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBustype());
                stmt.setInt(2, s.getNoofseat());
                stmt.setString(3, s.getBustypeid());
                stmt.executeUpdate();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in BustypeDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(Bustype s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE bustypeid = ?";
        try {
            ResultSet rs = selectRecord(s.getBustypeid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBustypeid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in BustypeDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
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

    public static void main(String[] args) {
        System.out.println("BustypeDA successfully launched");
    }
}
