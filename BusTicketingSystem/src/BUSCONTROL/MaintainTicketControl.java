package BUSCONTROL;

import BUSDA.TicketDA;
import BUSDOMAIN.Ticket;
import BUSDOMAIN.Trip;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainTicketControl {

    private TicketDA ticketDA;

    public MaintainTicketControl() {
        ticketDA = new TicketDA();
    }

    public Ticket selectRecord(String id) {
        return ticketDA.getRecord(id);
    }

    public void addRecord(Ticket s) {
        ticketDA.addRecord(s);
    }

    public void deleteRecord(Ticket s) {
        ticketDA.deleteRecord(s);
    }

    public void updateRecord(Ticket s) {
        ticketDA.updateRecord(s);
    }

    public ArrayList<Ticket> getAllRecord() {
        return ticketDA.getAllRecord();
    }

    public void createBunchTickets(Trip t) {
        ticketDA.createBunchTickets(t);
    }

    public ArrayList<Ticket> retrieveBunchTickets(Trip t) {
        return ticketDA.retrieveBunchTickets(t);

    }

    public void deleteBunchTickets(Trip t) {
        ticketDA.deleteBunchTickets(t);
    }

    public String getAfterLastCode() {
        return ticketDA.getAfterLastCode();
    }

    public void deleteRecordbyTrip(Trip t, Ticket s) {
        ticketDA.deleteRecordbyTrip(t, s);

    }
}
