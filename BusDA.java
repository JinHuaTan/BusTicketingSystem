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
import BUSCONTROL.MaintainBusControl;
import BUSCONTROL.MaintainBustypeControl;
import BUSDOMAIN.Bus;
import BUSDOMAIN.Bustype;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class BusDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Bus";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private MaintainBustypeControl mbtc;

    public BusDA() {
        createConnection();
        mbtc = new MaintainBustypeControl();
    }
    
    public ArrayList<String> getAllColumnName() {
        ArrayList<String> s = new ArrayList<String>();
        ResultSet rs = null;
        try {
            String queryStr = "SELECT * FROM " + tableName;
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                s.add(rsmd.getColumnName(i));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllColumnName, SQLException in BusDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }

    public ArrayList<Bus> searchRecordByColumn(String busName, String searchData) {
        ArrayList<Bus> busList = new ArrayList<Bus>();
        String queryStr = "SELECT * FROM " + tableName + " where " + busName + " LIKE '%" + searchData + "%'";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bus bus = getRecord(rs.getString(1));
                busList.add(bus);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "searchRecordByColumn, SQLException in BusDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busList;
    }

    public ArrayList<Bus> getAllRecord() {
        ArrayList<Bus> busList = new ArrayList<Bus>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bus bus = getRecord(rs.getString(1));
                busList.add(bus);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in BusDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE busid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in BusDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Bus getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE busid = ?";
        Bus bus = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Bustype bt = mbtc.selectRecord(rs.getString(3));
                bus = new Bus(rs.getString(1), rs.getString(2), bt, rs.getString(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in BusDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bus;
    }

    public void addRecord(Bus s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?)";

        try {
            ResultSet rs = selectRecord(s.getBusid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBusid());
                stmt.setString(2, s.getCarplate());
                stmt.setString(3, s.getBustypeid().getBustypeid());
                stmt.setString(4, s.getFirstdridate());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in BusDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Bus s) {
        String queryStr = "Update " + tableName + " set CARPLATE = ? , BUSTYPEID = ? , FIRSTDRIDATE = ? WHERE BUSID = ?";

        try {
            ResultSet rs = selectRecord(s.getBusid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getCarplate());
                stmt.setString(2, s.getBustypeid().getBustypeid());
                stmt.setString(3, s.getFirstdridate());
                stmt.setString(4, s.getBusid());
                stmt.executeUpdate();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "updateRecord, SQLException in BusDA" + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Bus s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE busid = ?";

        try {
            ResultSet rs = selectRecord(s.getBusid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getBusid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in BusDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public String displayRecord(char command) {
        String ID = "";
        try {
            if (command == 'L') {
                if (rs.isFirst() || rs.isBeforeFirst()) {
                    rs.last();
                } else {
                    rs.previous();
                }
            } else if (command == 'R') {
                if (rs.isLast()) {
                    rs.first();
                } else {
                    rs.next();
                }
            }
            ID = rs.getString(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No record to diplay!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ID;
    }

    private void createConnection() {
        String sqlStr;
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY BUSID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(" ***TRACE: Bus Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in BusDA " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
        System.out.println("BusDA successfully launched");
    }
}
