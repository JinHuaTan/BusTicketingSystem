/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Paymenttype  {
   
    private String pymtid;
    private String paymenttype;

    public Paymenttype() {
    }

    public Paymenttype(String pymtid) {
        this.pymtid = pymtid;
    }

    public Paymenttype(String pymtid, String paymenttype) {
        this.pymtid = pymtid;
        this.paymenttype = paymenttype;
    }

    public String getPymtid() {
        return pymtid;
    }

    public void setPymtid(String pymtid) {
        this.pymtid = pymtid;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String toString() {
        return "BUSDOMAIN.Paymenttype[ pymtid=" + pymtid + " ]";
    }
    
}
