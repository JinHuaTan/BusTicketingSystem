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
import BUSDOMAIN.Dslocation;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class DslocationDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Dslocation";
    private Connection conn;
    private PreparedStatement stmt;

    public DslocationDA() {
        createConnection();
    }

    public ArrayList<Dslocation> getAllRecord() {
        ArrayList<Dslocation> dslocationList = new ArrayList<Dslocation>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Dslocation dslocation = new Dslocation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                dslocationList.add(dslocation);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in DslocationDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return dslocationList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE destid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in DslocationDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Dslocation getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE destid = ?";
        Dslocation dslocation = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dslocation = new Dslocation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in DslocationDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return dslocation;
    }

    public void addRecord(Dslocation s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?)";

        try {
            ResultSet rs = selectRecord(s.getDestid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getDestid());
                stmt.setString(2, s.getDestl());
                stmt.setString(3, s.getNation());
                stmt.setString(4, s.getImageurl());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in DslocationDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Dslocation s){
        String queryStr = "Update " + tableName + " set SUPERVISORID = ? , DESTID = ? , COUNTERADD = ? , CONTACTNUM = ?WHERE COUNTERID = ?";

        try {
            ResultSet rs = selectRecord(s.getDestid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getDestl());
                stmt.setString(2, s.getNation());
                stmt.setString(3, s.getImageurl());
                stmt.setString(4, s.getDestid());
                stmt.executeUpdate();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in DslocationDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Dslocation s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE destid = ?";

        try {
            ResultSet rs = selectRecord(s.getDestid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getDestid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in DslocationDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

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
        System.out.println("DslocationDA successfully launched");
    }
}
