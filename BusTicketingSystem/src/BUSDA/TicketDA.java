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
import BUSCONTROL.MaintainSeatnumberControl;
import BUSCONTROL.MaintainTicketControl;
import BUSCONTROL.MaintainTransControl;
import BUSCONTROL.MaintainTripControl;
import BUSDOMAIN.Seatnumber;
import BUSDOMAIN.Ticket;
import BUSDOMAIN.Trans;
import BUSDOMAIN.Trip;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class TicketDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Ticket";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private MaintainTripControl mtc;
    private MaintainSeatnumberControl msnc;
    private MaintainTransControl mtsc;

    public TicketDA() {
        createConnection();
        mtc = new MaintainTripControl();
        msnc = new MaintainSeatnumberControl();
        mtsc = new MaintainTransControl();
    }

    public ArrayList<Ticket> getAllRecord() {
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket ticket = getRecord(rs.getString(1));
                ticketList.add(ticket);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in TicketDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ticketList;
    }

    public ArrayList<Ticket> retrieveBunchTickets(Trip t) {
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        String queryStr = "SELECT * FROM " + tableName + " WHERE tripid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, t.getTripid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket ticket = getRecord(rs.getString(1));
                ticketList.add(ticket);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "retrieveBunchTickets, SQLException in TicketDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ticketList;
    }

    public void createBunchTickets(Trip t) {

        ArrayList<Seatnumber> seatList = msnc.getAllRecord();
        try {
        for (int i = 0; i < t.getBusid().getBustypeid().getNoofseat(); i++) {
            Ticket tc = new Ticket("TC", t, 0, seatList.get(i), null);
            addRecord(tc);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "createBunchTickets, Exception in TicketDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteBunchTickets(Trip t) {
        ArrayList<Ticket> ticketList = retrieveBunchTickets(t);
        try {
            for (int i = 0; i < t.getBusid().getBustypeid().getNoofseat(); i++) {
                Ticket tc = ticketList.get(i);
                deleteRecordbyTrip(t, tc);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "createBunchTickets, Exception in TicketDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ticketid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in TicketDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Ticket getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ticketid = ?";
        Ticket ticket = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Trip t = mtc.selectRecord(rs.getString(2));
                Seatnumber s = msnc.selectRecord(rs.getString(4));
                Trans ts = mtsc.selectRecord(rs.getString(5));
                ticket = new Ticket(rs.getString(1), t, rs.getInt(3), s, ts);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in TicketDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ticket;
    }

    public String getAfterLastCode() {
        String ticketID = "";
        int id;
        try {
            createConnection();
            if (conn != null) {
                rs.last();
                try {
                    ticketID = rs.getString(1);
                    id = Integer.parseInt(ticketID.substring(2));
                    id += 1;
                    ticketID = String.format("TC%04d", id);
                } catch (Exception ex) {
                    ticketID = String.format("TC0001");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in TicketDA, getting last code: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ticketID;
    }

    public void addRecord(Ticket s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?)";
        String ticketid = getAfterLastCode();

        try {
            ResultSet rs = selectRecord(s.getTicketid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, ticketid);
                stmt.setString(2, s.getTripid().getTripid());
                stmt.setInt(3, 0);
                stmt.setString(4, s.getSeatid().getSeatid());
                stmt.setString(5, null);
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in TicketDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Ticket s) {
        String queryStr = "Update " + tableName + " set TRIPID = ?, AVAILABILITY = ?, SEATID = ?, TRANSID = ? WHERE TICKETID = ?";

        try {
            ResultSet rs = selectRecord(s.getTicketid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getTripid().getTripid());
                stmt.setInt(2, s.getAvailability());
                stmt.setString(3, s.getSeatid().getSeatid());
                stmt.setString(4, s.getTransid().getTransid());
                stmt.setString(5, s.getTicketid());
                stmt.executeUpdate();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in TicketDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(Ticket s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE ticketid = ?";
        try {
            ResultSet rs = selectRecord(s.getTicketid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getTicketid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in TicketDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void deleteRecordbyTrip(Trip t, Ticket s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE ticketid = ? AND tripid = ?";
        try {
            ResultSet rs = selectRecord(s.getTicketid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getTicketid());
                stmt.setString(2, t.getTripid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in TicketDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            String sqlStr = "SELECT * FROM " + tableName + " ORDER BY ticketid";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(" ***TRACE: Item Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
    }
}
