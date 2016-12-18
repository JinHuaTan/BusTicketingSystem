/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;
public class Trip {

    private String tripid;
    private String departdate;
    private String arrivaldate;
    private double fareperticket;
    private Bus busid;
    private Route routeid;
    private Driverlist driid;

    public Trip() {
    }

    public Trip(String tripid) {
        this.tripid = tripid;
    }

    public Trip(String tripid, String departdate, String arrivaldate, double fareperticket, 
            Bus busid, Route routeid, Driverlist driid) {
        this.tripid = tripid;
        this.departdate = departdate;
        this.arrivaldate = arrivaldate;
        this.fareperticket = fareperticket;
        this.busid = busid;
        this.routeid = routeid;
        this.driid = driid;
    }

    public String getTripid() {
        return tripid;
    }

    public void setTripid(String tripid) {
        this.tripid = tripid;
    }

    public String getDepartdate() {
        return departdate;
    }

    public void setDepartdate(String departdate) {
        this.departdate = departdate;
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public double getFareperticket() {
        return fareperticket;
    }

    public void setFareperticket(double fareperticket) {
        this.fareperticket = fareperticket;
    }

    public Bus getBusid() {
        return busid;
    }

    public void setBusid(Bus busid) {
        this.busid = busid;
    }

    public Route getRouteid() {
        return routeid;
    }

    public void setRouteid(Route routeid) {
        this.routeid = routeid;
    }

    public Driverlist getDriverlistid() {
        return driid;
    }

    public void setDriverlistid(Driverlist driid) {
        this.driid = driid;
    }

    public String toString() {
        return "<html><head>"
                + "<style>"
                + "table {color:#3d5c5c;width:370px;background:#FCFCFC;height:auto;font: 10px Arial,sans-serif;}"
                + "th, td {padding:7px;border:0;}"
                + "th{background-color:#3498db;color:white;font:bold 12px Arial,sans-serif;text-align: left;}"
                + "td { border-bottom:1px dotted #3CBA54; }"
                + "caption {"
                + "  text-decoration:underline;"
                + "  font-weight: bold;"
                + "  font-size: 1.15em;"
                + "}"
                + "</style>"
                + "</head><body>"
                + "<table>"
                + "<caption>Trip Details</caption>"
                + "<tr>"
                + "<th>#</th>"
                + "<th>Trip Information</th>"
                + "</tr>"
                + "<tr>"
                + "<td>Trip ID</td>"
                + "<td>" + tripid + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Depart Date</td>"
                + "<td>" + departdate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Arrival Date</td>"
                + "<td>" + arrivaldate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Fare Per Ticket</td>"
                + "<td>" + String.format("RM %.2f", fareperticket) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Busid</td>"
                + "<td>" + busid.getBusid() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Routeid</td>"
                + "<td>" + routeid.getRouteid() + "</td>"
                + "</tr>"
                 + "<tr>"
                + "<td>Driver id</td>"
                + "<td>" + driid.getDriverid().getStaffid()+ "</td>"
                + "</tr>"
                + "</table>"
                + "</body></html>";
    }

}
