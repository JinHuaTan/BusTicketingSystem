package BUSCONTROL;

import BUSDA.TransDA;
import BUSDOMAIN.Trans;
import java.io.IOException;
import java.sql.SQLException;

public class MaintainTransControl {

    private TransDA transDA;

    public MaintainTransControl() {
        transDA = new TransDA();
    }

    public Trans selectRecord(String id) {
        return transDA.getRecord(id);
    }

    public void addRecord(Trans s) {
        transDA.addRecord(s);
    }
    public void voidRecord(String id){
        transDA.voidRecord(id);
    }
    
    public String getLastTransID(){
        return transDA.getAfterLastCode();
    }
        
}
