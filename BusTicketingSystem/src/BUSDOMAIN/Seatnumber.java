/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Seatnumber {

    private String seatid;
    private String seatnumber;

    public Seatnumber() {
    }

    public Seatnumber(String seatid, String seatnumber) {
        this.seatid = seatid;
        this.seatnumber = seatnumber;
    }

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }

    public String getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(String seatnumber) {
        this.seatnumber = seatnumber;
    }

    public String toString() {
        return "BUSDOMAIN.Seatnumber[ seatid=" + seatid + " ]";
    }

}
