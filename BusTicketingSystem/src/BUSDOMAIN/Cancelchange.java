/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Cancelchange {

    private String recid;
    private String refundtype;
    private double amount;

    public Cancelchange() {
    }

    public Cancelchange(String recid) {
        this.recid = recid;
    }

    public Cancelchange(String recid, String refundtype, double amount) {
        this.recid = recid;
        this.refundtype = refundtype;
        this.amount = amount;
    }

    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid = recid;
    }

    public String getRefundtype() {
        return refundtype;
    }

    public void setRefundtype(String refundtype) {
        this.refundtype = refundtype;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return "BUSDOMAIN.Cancelchange[ recid=" + recid + " ]";
    }

}
