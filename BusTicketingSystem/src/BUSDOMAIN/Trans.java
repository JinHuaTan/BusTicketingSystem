/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

import java.sql.Timestamp;

public class Trans {

    private String transid;
    private Cancelchange recid;
    private Staff staffid;
    private Counter counterid;
    private String paidstatus;
    private Paymenttype pymtid;
    private String custname;
    private String contactnum;
    private String creditcardnumber;
    private String discounttype;
    private Double discountamount;
    private Double ttlamount;
    private Timestamp transdate;

    public Trans() {
    }

    public Trans(String transid) {
        this.transid = transid;
    }

    public Trans(String transid, Cancelchange recid, Staff staffid, Counter counterid, String paidstatus, Paymenttype pymtid, String custname, String contactnum, String creditcardnumber, String discounttype, Double discountamount, Double ttlamount, Timestamp transdate) {
        this.transid = transid;
        this.recid = recid;
        this.staffid = staffid;
        this.counterid = counterid;
        this.paidstatus = paidstatus;
        this.pymtid = pymtid;
        this.custname = custname;
        this.contactnum = contactnum;
        this.creditcardnumber = creditcardnumber;
        this.discounttype = discounttype;
        this.discountamount = discountamount;
        this.ttlamount = ttlamount;
        this.transdate = transdate;
    }



    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getPaidstatus() {
        return paidstatus;
    }

    public void setPaidstatus(String paidstatus) {
        this.paidstatus = paidstatus;
    }

    public Double getTtlamount() {
        return ttlamount;
    }

    public void setTtlamount(Double ttlamount) {
        this.ttlamount = ttlamount;
    }

    public Cancelchange getRecid() {
        return recid;
    }

    public void setRecid(Cancelchange recid) {
        this.recid = recid;
    }

    public Counter getCounterid() {
        return counterid;
    }

    public void setCounterid(Counter counterid) {
        this.counterid = counterid;
    }

    public Paymenttype getPymtid() {
        return pymtid;
    }

    public void setPymtid(Paymenttype pymtid) {
        this.pymtid = pymtid;
    }

    public Staff getStaffid() {
        return staffid;
    }

    public void setStaffid(Staff staffid) {
        this.staffid = staffid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public String getDiscounttype() {
        return discounttype;
    }

    public void setDiscounttype(String discounttype) {
        this.discounttype = discounttype;
    }

    public Double getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(Double discountamount) {
        this.discountamount = discountamount;
    }

    public Timestamp getTransdate() {
        return transdate;
    }

    public void setTransdate(Timestamp transdate) {
        this.transdate = transdate;
    }

    @Override
    public String toString() {
        return "BUSDOMAIN.Trans[ transid=" + transid + " ]";
    }

}
