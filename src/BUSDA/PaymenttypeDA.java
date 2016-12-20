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
import BUSDOMAIN.Paymenttype;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;

public class PaymenttypeDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "PAYMENTTYPE";
    private Connection conn;
    private PreparedStatement stmt;

    public PaymenttypeDA() {
        createConnection();
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE pymtid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in PaymenttypeDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Paymenttype getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PYMTID = ?";
        Paymenttype paymenttype = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                paymenttype = new Paymenttype(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return paymenttype;
    }

    public Paymenttype getRecordbyPayment(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAYMENTTYPE = ?";
        Paymenttype paymenttype = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                paymenttype = new Paymenttype(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return paymenttype;
    }

    public void addRecord(Paymenttype s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?)";

        try {

            ResultSet rs = selectRecord(s.getPymtid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getPymtid());
                stmt.setString(2, s.getPaymenttype());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void updateRecord(Paymenttype s) throws SQLException, IOException {
        String queryStr = "Update " + tableName + " set PAYMENTTYPE = ? WHERE pymtid = ?";
        try {

            ResultSet rs = selectRecord(s.getPymtid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getPymtid());
                stmt.setString(2, s.getPaymenttype());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

    public void deleteRecord(Paymenttype s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE pymtid = ?";

        try {
            ResultSet rs = selectRecord(s.getPymtid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getPymtid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
        PaymenttypeDA paymenttypeDA = new PaymenttypeDA();
        Paymenttype paymenttype = paymenttypeDA.getRecord("S001");
        System.out.println(paymenttype);
    }
}
