/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Route {

    private String routeid;
    private double distance;
    private Boarding bdpid;
    private Dslocation destid;
    private Boarding dppid;
    private Dslocation sourceid;

    public Route() {
    }

    public Route(String routeid) {
        this.routeid = routeid;
    }

    public Route(String routeid, Dslocation sourceid, Dslocation destid, double distance, Boarding bdpid,
            Boarding dppid) {
        this.routeid = routeid;
        this.distance = distance;
        this.bdpid = bdpid;
        this.destid = destid;
        this.dppid = dppid;
        this.sourceid = sourceid;
    }

    public String getRouteid() {
        return routeid;
    }

    public void setRouteid(String routeid) {
        this.routeid = routeid;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Boarding getBdpid() {
        return bdpid;
    }

    public void setBdpid(Boarding bdpid) {
        this.bdpid = bdpid;
    }

    public Dslocation getDestid() {
        return destid;
    }

    public void setDestid(Dslocation destid) {
        this.destid = destid;
    }

    public Boarding getDppid() {
        return dppid;
    }

    public void setDppid(Boarding dppid) {
        this.dppid = dppid;
    }

    public Dslocation getSourceid() {
        return sourceid;
    }

    public void setSourceid(Dslocation sourceid) {
        this.sourceid = sourceid;
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
                + "<caption>Route Details</caption>"
                + "<tr>"
                + "<th>#</th>"
                + "<th>Route Information</th>"
                + "</tr>"
                + "<tr>"
                + "<td>Route ID</td>"
                + "<td>" + routeid + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Source</td>"
                + "<td>" + sourceid.getDestl() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Destination</td>"
                + "<td>" + destid.getDestl() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Distance</td>"
                + "<td>" + String.format("%.2f KM", distance) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Boarding Point</td>"
                + "<td>" + bdpid.getBoardpoint() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Dropping Point</td>"
                + "<td>" + dppid.getBoardpoint() + "</td>"
                + "</tr>"
                + "</table>"
                + "</body></html>";
    }

}
