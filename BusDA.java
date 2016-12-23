
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
public class BusDA {
     private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Bus";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

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
}
