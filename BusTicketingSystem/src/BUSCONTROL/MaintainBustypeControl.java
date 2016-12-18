package BUSCONTROL;

import BUSDA.BustypeDA;
import BUSDOMAIN.Bustype;
import BUSDOMAIN.Counter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainBustypeControl {

    private BustypeDA bustypeDA;

    public MaintainBustypeControl() {
        bustypeDA = new BustypeDA();
    }

    public Bustype selectRecord(String id) {
        return bustypeDA.getRecord(id);
    }

    public ArrayList<Bustype> getAllRecord() {
        return bustypeDA.getAllRecord();
    }

    public void addRecord(Bustype s) {
        bustypeDA.addRecord(s);
    }

    public void deleteRecord(Bustype s) {
        bustypeDA.deleteRecord(s);
    }

    public void updateRecord(Bustype s) {
        bustypeDA.updateRecord(s);
    }
}
