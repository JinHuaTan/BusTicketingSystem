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
import BUSDOMAIN.Boarding;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class BoardingDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Boarding";
    private Connection conn;
    private PreparedStatement stmt;

    public BoardingDA() {
        createConnection();
    }

    public ArrayList<Boarding> getAllRecord() {
        ArrayList<Boarding> boardingList = new ArrayList<Boarding>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Boarding boarding = new Boarding(rs.getString(1), rs.getString(2));
                boardingList.add(boarding);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in BoardingDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return boardingList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE bdpid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in BoardingDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Boarding getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE bdpid = ?";
        Boarding boarding = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                boarding = new Boarding(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in BoardingDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return boarding;
    }

    public void addRecord(Boarding s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?, ?)";

        try {
            ResultSet rs = selectRecord(s.getBdpid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBdpid());
                stmt.setString(2, s.getBoardpoint());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in BoardingDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Boarding s){
        String queryStr = "Update " + tableName + " set BOARDPOINT = ? WHERE BDPID = ?";

        try {
            ResultSet rs = selectRecord(s.getBdpid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBoardpoint());
                stmt.setString(2, s.getBdpid());
                stmt.executeUpdate();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in BoardingDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(Boarding s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE bdpid = ?";
        try {
            ResultSet rs = selectRecord(s.getBdpid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBdpid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in BoardingDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

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
        System.out.println("BoardingDA successfully launched");
    }
}
