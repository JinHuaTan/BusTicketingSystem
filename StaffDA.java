
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shaun Lee
 */
public class StaffDA {
     private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Staff";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlStr;
    private ResultSet rs;

    public StaffDA() {
        createConnection();
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

    public ArrayList<Staff> searchRecordByColumn(String staffName, String searchData) {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        String queryStr = "SELECT * FROM " + tableName + " where " + staffName + " LIKE '%" + searchData + "%'";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Staff stf = getRecord(rs.getString(1));
                staffList.add(stf);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "searchRecordByColumn, SQLException in CounterDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffList;
    }

    public ArrayList<Staff> getAllRecord() {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Jobposition job = new Jobposition(rs.getString(6));
                Paymenttype pt = new Paymenttype(rs.getString(13));
                Staff staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), job, rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), pt, rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
                staffList.add(staff);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in StaffDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE staffid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in StaffDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Staff getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE staffid = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Jobposition job = new Jobposition(rs.getString(6));
                Paymenttype pt = new Paymenttype(rs.getString(13));
                staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), job, rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), pt, rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in StaffDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }

    public Staff getRecordByUsername(String USERNAME) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE username = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, USERNAME);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Jobposition job = new Jobposition(rs.getString(6));
                Paymenttype pt = new Paymenttype(rs.getString(13));
                staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), job, rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), pt, rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in StaffDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }

    public void addRecord(Staff s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?,?,?,?,?)";

        try {

            ResultSet rs = selectRecord(s.getStaffid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getStaffid());
                stmt.setString(2, s.getUsername());
                stmt.setString(3, s.getPassword());
                stmt.setString(4, s.getStaffname());
                stmt.setString(5, s.getNric());
                stmt.setString(6, s.getJobposition().getPositionid());
                stmt.setDouble(7, s.getSalary());
                stmt.setString(8, s.getContactno());
                stmt.setString(9, s.getEmail());
                stmt.setString(10, s.getAddress());
                stmt.setString(11, s.getFirstworkdate());
                stmt.setString(12, s.getLastworkdate());
                stmt.setString(13, s.getPymtid().getPymtid());
                stmt.setString(14, s.getAccnumber());
                stmt.setString(15, s.getSecurityquestion());
                stmt.setString(16, s.getSecuritypass());
                stmt.setString(17, s.getUrl());
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + s.getStaffid() + " is inserted Successful in database.\n");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void updateRecord(Staff s) {
        String queryStr = "Update " + tableName + " set USERNAME = ? , PASSWORD = ? , STAFFNAME = ? , NRIC = ? , POSITIONID = ? , SALARY= ? , CONTACTNO= ? , EMAIL= ? , ADDRESS= ? , FIRSTWORKDATE= ? , LASTWORKDATE= ? , PYMTID= ? , ACCNUMBER= ? , SECURITYQUESTION = ? , SECURITYPASS = ? , URL = ? WHERE STAFFID = ?";

        try {
            ResultSet rs = selectRecord(s.getStaffid());

            if (rs.next()) {

                stmt = conn.prepareStatement(queryStr);

                stmt.setString(1, s.getUsername());
                stmt.setString(2, s.getPassword());
                stmt.setString(3, s.getStaffname());
                stmt.setString(4, s.getNric());
                stmt.setString(5, s.getJobposition().getPositionid());
                stmt.setDouble(6, s.getSalary());
                stmt.setString(7, s.getContactno());
                stmt.setString(8, s.getEmail());
                stmt.setString(9, s.getAddress());
                stmt.setString(10, s.getFirstworkdate());
                stmt.setString(11, s.getLastworkdate());
                stmt.setString(12, s.getPymtid().getPymtid());
                stmt.setString(13, s.getAccnumber());
                stmt.setString(14, s.getSecurityquestion());
                stmt.setString(15, s.getSecuritypass());
                stmt.setString(16, s.getUrl());
                stmt.setString(17, s.getStaffid());
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + s.getStaffid() + " is inserted Successful in database.\n");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Staff s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE staffid = ?";

        try {
            ResultSet rs = selectRecord(s.getStaffid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getStaffid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in StaffDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY STAFFID";
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
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY STAFFID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        String staffID = "";
        int id;
        try {
            if (conn != null) {
                rs.last();
                staffID = rs.getString("STAFFID");
                id = Integer.parseInt(staffID.substring(1));
                id += 1;
                staffID = String.format("S%05d", id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in getting last code: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffID;
    }

    public static void main(String[] args) {
        System.out.println("StaffDA successfully launched");
    }
    
}
