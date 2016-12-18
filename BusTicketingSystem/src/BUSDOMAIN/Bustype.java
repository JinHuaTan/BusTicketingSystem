
package BUSDOMAIN;

public class Bustype{
    private String bustypeid;
    private String bustype;
       private int noofseat;

    public Bustype() {
    }

    public Bustype(String bustypeid) {
        this.bustypeid = bustypeid;
    }

    public Bustype(String bustypeid, String bustype, int noofseat) {
        this.bustypeid = bustypeid;
        this.bustype = bustype;
        this.noofseat = noofseat;
    }

    public int getNoofseat() {
        return noofseat;
    }

    public void setNoofseat(int noofseat) {
        this.noofseat = noofseat;
    }

  
    public String getBustypeid() {
        return bustypeid;
    }

    public void setBustypeid(String bustypeid) {
        this.bustypeid = bustypeid;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

    
    @Override
    public String toString() {
       return "<html><head>"
                + "<style>"
                + "table {color:#3d5c5c;width:250px;background:#FCFCFC;height:auto;font: 10px Arial,sans-serif;}"
                + "th, td {padding:7px;border:0;}"
                + "th{background-color:#3CBA54;color:white;font:bold 12px Arial,sans-serif;text-align: left;}"
                + "td { border-bottom:1px dotted #3CBA54; }"
                + "caption {"
                + "  text-decoration:underline;"
                + "  font-weight: bold;"
                + "  font-size: 1.15em;"
                + "}"
                + "</style>"
                + "</head><body>"
                + "<table>"
                + "<caption>Bus Type Details</caption>"
                + "<tr>"
                + "<th>#</th>"
                + "<th>Bus Type Information</th>"
                + "</tr>"
                + "<tr>"
                + "<td>Bus Type ID</td>"
                + "<td>" + bustypeid + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Bus Type</td>"
                + "<td>" + bustype + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>No Of Seat</td>"
                + "<td>" + noofseat + "</td>"
                + "</tr>"
                + "</table>"
                + "</body></html>";
    }
    
}
