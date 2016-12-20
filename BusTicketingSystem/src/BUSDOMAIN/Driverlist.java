/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;
import BUSCONTROL.*;
public class Driverlist {

    private String driid;
    private Staff driverid;
    private String descofchange;
    private String dristatus;
    

    public Driverlist() {
    }

    public Driverlist(String driid) {
        this.driid = driid;
    }

    public Driverlist(String driid, Staff driverid, String descofchange, String dristatus) {
        this.driid = driid;
        this.driverid = driverid;
        this.descofchange = descofchange;
        this.dristatus = dristatus;
    }

    

    public String getDriid() {
        return driid;
    }

    public void setDriid(String driid) {
        this.driid = driid;
    }

    public String getDescofchange() {
        return descofchange;
    }

    public void setDescofchange(String descofchange) {
        this.descofchange = descofchange;
    }

    public String getDristatus() {
        return dristatus;
    }

    public void setDristatus(String dristatus) {
        this.dristatus = dristatus;
    }

    public Staff getDriverid() {
        MaintainStaffControl mstf = new MaintainStaffControl();
        Staff stf = mstf.selectRecord(driverid.getStaffid());
        return stf;
    }

    public void setDriverid(Staff driverid) {
        this.driverid = driverid;
    }

    public String toString() {
        return "BUSDOMAIN.Driverlist[ driid=" + driid + " ]";
    }

}
