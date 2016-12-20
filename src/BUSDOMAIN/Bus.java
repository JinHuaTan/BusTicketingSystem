/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Bus {

    private String busid;
    private String carplate;
    private Bustype bustypeid;
    private String firstdridate;

    public Bus() {
    }

    public Bus(String busid) {
        this.busid = busid;
    }

    public Bus(String busid, String carplate, Bustype bustypeid, String firstdridate) {
        this.busid = busid;
        this.carplate = carplate;
        this.bustypeid = bustypeid;
        this.firstdridate = firstdridate;
    }

    public Bustype getBustypeid() {
        return bustypeid;
    }

    public void setBustypeid(Bustype bustypeid) {
        this.bustypeid = bustypeid;
    }

    public String getBusid() {
        return busid;
    }

    public void setBusid(String busid) {
        this.busid = busid;
    }

    public String getCarplate() {
        return carplate;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate;
    }

    public String getFirstdridate() {
        return firstdridate;
    }

    public void setFirstdridate(String firstdridate) {
        this.firstdridate = firstdridate;
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
                + "<td>Bus ID</td>"
                + "<td>" + busid + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Carplate</td>"
                + "<td>" + carplate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Bus Type</td>"
                + "<td>" + getBustypeid().getBustype() + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>First Driving Date</td>"
                + "<td>" + firstdridate + "</td>"
                + "</tr>"
                + "</table>"
                + "</body></html>";
    }

}
