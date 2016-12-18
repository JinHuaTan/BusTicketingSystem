/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

import BUSCONTROL.*;
import java.util.Date;
import java.io.Serializable;
import java.util.Objects;

public class Staff implements Serializable {

    private String staffid;
    private String username;
    private String password;
    private String staffname;
    private String nric;
    private Jobposition jobposition;
    private double salary;
    private String contactno;
    private String email;
    private String address;
    private String firstworkdate;
    private String lastworkdate;
    private Paymenttype pymtid;
    private String accnumber;
    private String securityquestion;
    private String securitypass;
    private String url;

    public Staff() {
    }

    public Staff(String staffid) {
        this.staffid = staffid;
    }

    public Staff(String staffid, String username, String password, String staffname, String nric, Jobposition jobposition, double salary, String contactno, String email, String address, String firstworkdate, String lastworkdate, Paymenttype pymtid, String accnumber, String securityquestion, String securitypass,String url) {
        this.staffid = staffid;
        this.username = username;
        this.password = password;
        this.staffname = staffname;
        this.nric = nric;
        this.jobposition = jobposition;
        this.salary = salary;
        this.contactno = contactno;
        this.email = email;
        this.address = address;
        this.firstworkdate = firstworkdate;
        this.lastworkdate = lastworkdate;
        this.pymtid = pymtid;
        this.accnumber = accnumber;
        this.securityquestion = securityquestion;
        this.securitypass = securitypass;
        this.url = url;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public Jobposition getJobposition() {
        MaintainJobpositionControl mjc = new MaintainJobpositionControl();
        Jobposition jp = mjc.selectRecord(jobposition.getPositionid());
        return jp;
    }

    public void setJobposition(Jobposition jobposition) {
        this.jobposition = jobposition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstworkdate() {
        return firstworkdate;
    }

    public void setFirstworkdate(String firstworkdate) {
        this.firstworkdate = firstworkdate;
    }

    public String getLastworkdate() {
        return lastworkdate;
    }

    public void setLastworkdate(String lastworkdate) {
        this.lastworkdate = lastworkdate;
    }

    public String getAccnumber() {
        return accnumber;
    }

    public void setAccnumber(String accnumber) {
        this.accnumber = accnumber;
    }

    public Paymenttype getPymtid() {
        MaintainPaymenttypeControl mpc = new MaintainPaymenttypeControl();
        Paymenttype pt = mpc.selectRecord(pymtid.getPymtid());
        return pt;
    }

    public void setPymtid(Paymenttype pymtid) {
        this.pymtid = pymtid;
    }

    public String getSecurityquestion() {
        return securityquestion;
    }

    public void setSecurityquestion(String securityquestion) {
        this.securityquestion = securityquestion;
    }

    public String getSecuritypass() {
        return securitypass;
    }

    public void setSecuritypass(String securitypass) {
        this.securitypass = securitypass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "<html><head>"
                + "<style>"
                + "table {color:#3d5c5c;width:370px;background:#FCFCFC;height:auto;font: 10px Arial,sans-serif;}"
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
                + "<caption>Staff Details</caption>"
                + "<tr>"
                + "<th>#</th>"
                + "<th>Staff Information</th>"
                + "</tr>"
                + "<tr>"
                + "<td>Staff ID</td>"
                + "<td>" + staffid + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Staff Name</td>"
                + "<td>" + staffname + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Contact No</td>"
                + "<td>" + contactno + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Email</td>"
                + "<td>" + email + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Job Position</td>"
                + "<td>" + getJobposition().getJobposition() + "</td>"
                + "</tr>"
                + "</table>"
                + "</body></html>";
    }

}
