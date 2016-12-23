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