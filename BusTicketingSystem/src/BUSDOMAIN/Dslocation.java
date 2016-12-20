/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

import BUSUI.ViewLocation;

public class Dslocation {

    private String destid;
    private String destl;
    private String nation;
    private String imageurl;

    public Dslocation() {
    }

    public Dslocation(String destid) {
        this.destid = destid;
    }

    public Dslocation(String destid, String destl, String nation, String imageurl) {
        this.destid = destid;
        this.destl = destl;
        this.nation = nation;
        this.imageurl = imageurl;
    }

    public String getDestid() {
        return destid;
    }

    public void setDestid(String destid) {
        this.destid = destid;
    }

    public String getDestl() {
        return destl;
    }

    public void setDestl(String destl) {
        this.destl = destl;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {

        return "<html><head>"
                + "<style>"
                + "caption {"
                + "  color:#ff9900;"
                + "  font:bold 25px verdana;"
                + "  font-weight: 2500;"
                + "}"
                + "table{"
                + "padding:0;}"
                + "</style>"
                + "</head><body>"
                + "<table>"
                + "<caption>Location Details</caption>"
                + "<tr>"
                + "<td>"
                + "<img src=\"" + ViewLocation.class.getResource("../images/location/" + imageurl + "") + "\" width=320 height=180>"
                + "</td>"
                + "</tr><tr>"
                + "<td>"
                + "<h2 style=\"font:bold 25px calibri;margin:0;margin-left:14px;font-weight: bold;\">" + destl + "</h2>"
                + "<ul style=\"font: 14px Corbel;color:#626262;margin-left:25px;\">"
                + "<li><b>DestID:</b> " + destid + "</li>"
                + "<li><b>Location:</b> " + nation + "</li></ul>"
                + "</td>"
                + "</tr>"
                + "</table>"
                + "</html>";
    }

}
