/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

public class Boarding {
    private String bdpid;
    private String boardpoint;

    public Boarding() {
    }

    public Boarding(String bdpid) {
        this.bdpid = bdpid;
    }

    public Boarding(String bdpid, String boardpoint) {
        this.bdpid = bdpid;
        this.boardpoint = boardpoint;
    }

    public String getBdpid() {
        return bdpid;
    }

    public void setBdpid(String bdpid) {
        this.bdpid = bdpid;
    }

    public String getBoardpoint() {
        return boardpoint;
    }

    public void setBoardpoint(String boardpoint) {
        this.boardpoint = boardpoint;
    }

    @Override
    public String toString() {
        return "BUSDOMAIN.Boarding[ bdpid=" + bdpid + " ]";
    }
    
}
