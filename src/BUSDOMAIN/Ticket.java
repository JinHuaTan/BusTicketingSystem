/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Ticket{
 
    private String ticketid;
    private Trip tripid;
    private int availability;
    private Seatnumber seatid;
    private Trans transid;

    public Ticket() {
    }

    public Ticket(String ticketid, Trip tripid, int availability, Seatnumber seatid, Trans transid) {
        this.ticketid = ticketid;
        this.tripid = tripid;
        this.availability = availability;
        this.seatid = seatid;
        this.transid = transid;
    }

    public Trip getTripid() {
        return tripid;
    }

    public void setTripid(Trip tripid) {
        this.tripid = tripid;
    }

    public Trans getTransid() {
        return transid;
    }

    public void setTransid(Trans transid) {
        this.transid = transid;
    }

    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Seatnumber getSeatid() {
        return seatid;
    }

    public void setSeatid(Seatnumber seatid) {
        this.seatid = seatid;
    }

   
    public String toString() {
        return "BUSDOMAIN.Ticket[ ticketid=" + ticketid + " ]";
    }
    
}
