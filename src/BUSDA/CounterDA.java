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
import BUSCONTROL.MaintainCounterControl;
import BUSCONTROL.MaintainDslocationControl;
import BUSCONTROL.MaintainStaffControl;
import BUSDOMAIN.Counter;
import BUSDOMAIN.Dslocation;
import BUSDOMAIN.Staff;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class CounterDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Counter";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private MaintainDslocationControl mdc;
    private MaintainStaffControl msc;

    public CounterDA() {
        createConnection();
        mdc = new MaintainDslocationControl();
        msc = new MaintainStaffControl();
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
            JOptionPane.showMessageDialog(null, "getAllColumnName, SQLException in CounterDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }

    public ArrayList<Counter> searchRecordByColumn(String counterName, String searchData) {
        ArrayList<Counter> counterList = new ArrayList<Counter>();
        String queryStr = "SELECT * FROM " + tableName + " where " + counterName + " LIKE '%" + searchData + "%'";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Counter counter = getRecord(rs.getString(1));
                counterList.add(counter);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "searchRecordByColumn, SQLException in CounterDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return counterList;
    }

    public ArrayList<Counter> getAllRecord() {
        ArrayList<Counter> counterList = new ArrayList<Counter>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Counter counter = getRecord(rs.getString(1));
                counterList.add(counter);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in CounterDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return counterList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE counterid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in CounterDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Counter getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE counterid = ?";
        Counter counter = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Staff staff = msc.selectRecord(rs.getString(2));
                Dslocation dest = mdc.selectRecord(rs.getString(3));
                counter = new Counter(rs.getString(1), staff, dest, rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in CounterDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return counter;
    }

    public void addRecord(Counter s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?, ?)";

        try {
            ResultSet rs = selectRecord(s.getCounterid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getCounterid());
                stmt.setString(2, s.getSupervisorid().getStaffid());
                stmt.setString(3, s.getDestid().getDestid());
                stmt.setString(4, s.getCounteradd());
                stmt.setString(5, s.getContactnum());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in CounterDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Counter s) {
        String queryStr = "Update " + tableName + " set SUPERVISORID = ? , DESTID = ? , COUNTERADD = ? , CONTACTNUM = ?WHERE COUNTERID = ?";

        try {
            ResultSet rs = selectRecord(s.getCounterid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getSupervisorid().getStaffid());
                stmt.setString(2, s.getDestid().getDestid());
                stmt.setString(3, s.getCounteradd());
                stmt.setString(4, s.getContactnum());
                stmt.setString(5, s.getCounterid());
                stmt.executeUpdate();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in CounterDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Counter s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE counterid = ?";

        try {
            ResultSet rs = selectRecord(s.getCounterid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getCounterid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in CounterDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

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
            JOptionPane.showMessageDialog(null, "No record to diplay!, counterDA: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ID;
    }

    private void createConnection() {
        String sqlStr;
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY COUNTERID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(" ***TRACE: Counter Connection established.");
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
        System.out.println("CounterDA successfully launched");
    }
}
