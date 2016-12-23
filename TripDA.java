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