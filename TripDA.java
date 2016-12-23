package BUSDA;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class TripDA {

    private final String tableName = "Trip";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private MaintainBusControl mbc;
    private MaintainRouteControl mrc;
    private MaintainDriverlistControl msc;

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
            JOptionPane.showMessageDialog(null, "getAllColumnName, SQLException in TripDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }

    public ArrayList<Trip> searchRecordByColumn(String tripName, String searchData) {
        ArrayList<Trip> tripList = new ArrayList<Trip>();
        String queryStr = "SELECT * FROM " + tableName + " where " + tripName + " LIKE '%" + searchData + "%'";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Trip trip = getRecord(rs.getString(1));
                tripList.add(trip);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "searchRecordByColumn, SQLException in TripDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return tripList;
    }

    public ArrayList<Trip> getAllRecord() {
        ArrayList<Trip> tripList = new ArrayList<Trip>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Trip trip = getRecord(rs.getString(1));
                tripList.add(trip);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in TripDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return tripList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE tripid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in TripDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Trip getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE tripid = ?";
        Trip trip = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Bus b = mbc.selectRecord(rs.getString(5));
                Route r = mrc.selectRecord(rs.getString(6));
                if (rs.getString(7) == null) {
                    trip = new Trip(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), b, r, null);
                } else {
                    Driverlist s = msc.selectRecord(rs.getString(7));
                    trip = new Trip(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), b, r, s);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in TripDA " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return trip;
    }

    public void addRecord(Trip s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?, ?,?, ?)";

        try {
            ResultSet rs = selectRecord(s.getTripid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getTripid());
                stmt.setString(2, s.getDepartdate());
                stmt.setString(3, s.getArrivaldate());
                stmt.setDouble(4, s.getFareperticket());
                stmt.setString(5, s.getBusid().getBusid());
                stmt.setString(6, s.getRouteid().getRouteid());
                if (s.getDriverlistid() != null) {
                    stmt.setString(7, s.getDriverlistid().getDriid());
                } else {
                    stmt.setString(7, null);
                }
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in TripDA " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Trip s) {
        String queryStr = "Update " + tableName + " set DEPARTDATE = ? , ARRIVALDATE = ? , FAREPERTICKET = ? ,"
                + " BUSID = ?, ROUTEID = ?, DRIID=? WHERE tripid = ?";
        try {
            ResultSet rs = selectRecord(s.getTripid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getDepartdate());
                stmt.setString(2, s.getArrivaldate());
                stmt.setDouble(3, s.getFareperticket());
                stmt.setString(4, s.getBusid().getBusid());
                stmt.setString(5, s.getRouteid().getRouteid());
                if (s.getDriverlistid() != null) {
                    stmt.setString(6, s.getDriverlistid().getDriid());
                } else {
                    stmt.setString(6, null);
                }
                stmt.setString(7, s.getTripid());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, s.getTripid() + " is updated Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "updateRecord, Error in TripDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Trip s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE tripid = ?";

        try {
            ResultSet rs = selectRecord(s.getTripid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getTripid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in TripDA " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

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
