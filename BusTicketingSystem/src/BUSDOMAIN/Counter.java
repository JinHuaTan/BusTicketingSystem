/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Counter {

    private String counterid;
    private String counteradd;
    private String contactnum;
    private Staff supervisorid;
    private Dslocation destid;

    public Counter() {
    }

    public Counter(String counterid) {
        this.counterid = counterid;
    }

    public Counter(String counterid, Staff supervisorid, Dslocation destid, String counteradd, String contactnum) {
        this.counterid = counterid;
        this.counteradd = counteradd;
        this.contactnum = contactnum;
        this.supervisorid = supervisorid;
        this.destid = destid;
    }

    public String getCounterid() {
        return counterid;
    }

    public void setCounterid(String counterid) {
        this.counterid = counterid;
    }

    public String getCounteradd() {
        return counteradd;
    }

    public void setCounteradd(String counteradd) {
        this.counteradd = counteradd;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }

    public Staff getSupervisorid() {
        return supervisorid;
    }

    public void setSupervisorid(Staff supervisorid) {
        this.supervisorid = supervisorid;
    }

    public Dslocation getDestid() {
        return destid;
    }

    public void setDestid(Dslocation destid) {
        this.destid = destid;
    }

    public String toString() {
        return "BUSDOMAIN.Counter[ counterid=" + counterid + " ]";
    }

}
