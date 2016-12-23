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

