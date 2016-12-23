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
import BUSDOMAIN.Jobposition;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.JOptionPane;


public class JobpositionDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Jobposition";
    private Connection conn;
    private PreparedStatement stmt;

    public JobpositionDA() {
        createConnection();
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE positionid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in JobpositionDa, selectRecord: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Jobposition getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE POSITIONID = ?";
        Jobposition jobposition = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                jobposition = new Jobposition(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in StaffDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return jobposition;
    }
    
    public Jobposition getRecordbyJob(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE JOBPOSITION = ?";
        Jobposition jobposition = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                jobposition = new Jobposition(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in StaffDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return jobposition;
    }

    public void addRecord(Jobposition s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?)";

        try {

            ResultSet rs = selectRecord(s.getPositionid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getPositionid());
                stmt.setString(2, s.getJobposition());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in JobpositionDa, addRecord: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Jobposition s) throws SQLException, IOException {
        String queryStr = "Update " + tableName + " set JOBPOSITION = ? WHERE POSITIONID = ?";
        try {
            ResultSet rs = selectRecord(s.getPositionid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getJobposition());
                stmt.setString(2, s.getPositionid());
                stmt.executeUpdate();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in JobpositionDa, updateRecord: " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(Jobposition s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE positionid = ?";

        try {
            ResultSet rs = selectRecord(s.getPositionid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getPositionid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,  "Error in JobpositionDa, deleteRecord: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in JobpositionDa, createConnection: " +ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
        JobpositionDA jobpositionDA = new JobpositionDA();
        Jobposition jobposition = jobpositionDA.getRecord("S001");
        System.out.println(jobposition);
    }
}
