package BUSCONTROL;

import BUSDA.DslocationDA;
import BUSDOMAIN.Dslocation;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainDslocationControl {

    private DslocationDA dslocationDA;

    public MaintainDslocationControl() {
        dslocationDA = new DslocationDA();
    }

    public Dslocation selectRecord(String id) {
        return dslocationDA.getRecord(id);
    }

    public void addRecord(Dslocation s) {
        dslocationDA.addRecord(s);
    }

    public void deleteRecord(Dslocation s) {
        dslocationDA.deleteRecord(s);
    }

    public void updateRecord(Dslocation s)  {
        dslocationDA.updateRecord(s);
    }
    
     public ArrayList<Dslocation> getAllRecord() {
         return dslocationDA.getAllRecord();
     }
}
