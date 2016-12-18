/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Jobposition {
    
    private String positionid;
    private String jobposition;

    public Jobposition() {
    }

    public Jobposition(String positionid) {
        this.positionid = positionid;
    }

    public Jobposition(String positionid, String jobposition) {
        this.positionid = positionid;
        this.jobposition = jobposition;
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }

    public String getJobposition() {
        return jobposition;
    }

    public void setJobposition(String jobposition) {
        this.jobposition = jobposition;
    }

    public String toString() {
        return "BUSDOMAIN.Jobposition[ positionid=" + positionid + " ]";
    }
    
}
