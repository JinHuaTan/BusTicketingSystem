
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
public class RouteDA {
     private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Route";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public void addRecord(Route s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?, ?,?)";

        try {
            ResultSet rs = selectRecord(s.getRouteid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getRouteid());
                stmt.setString(2, s.getSourceid().getDestid());
                stmt.setString(3, s.getDestid().getDestid());
                stmt.setDouble(4, s.getDistance());
                stmt.setString(5, s.getBdpid().getBdpid());
                stmt.setString(6, s.getDppid().getBdpid());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in RouteDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Route s) {
        String queryStr = "Update " + tableName + " set SOURCEID = ? , DESTID = ? ,"
                + " DISTANCE = ?, BDPID = ?, DPPID=? WHERE ROUTEID = ?";

        try {
            ResultSet rs = selectRecord(s.getRouteid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getSourceid().getDestid());
                stmt.setString(2, s.getDestid().getDestid());
                stmt.setDouble(3, s.getDistance());
                stmt.setString(4, s.getBdpid().getBdpid());
                stmt.setString(5, s.getDppid().getBdpid());
                stmt.setString(6, s.getRouteid());
                stmt.executeUpdate();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in RouteDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Route s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE routeid = ?";

        try {
            ResultSet rs = selectRecord(s.getRouteid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getRouteid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in RouteDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

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
