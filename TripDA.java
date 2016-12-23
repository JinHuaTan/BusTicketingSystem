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