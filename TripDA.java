
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class TripDA {
     private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Trip";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

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
    
}
