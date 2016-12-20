package BUSCONTROL;

import BUSDA.DriverlistDA;
import BUSDOMAIN.Driverlist;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainDriverlistControl {

    private DriverlistDA driverlistDA;

    public MaintainDriverlistControl() {
        driverlistDA = new DriverlistDA();
    }

    public Driverlist selectRecord(String id) {
        return driverlistDA.getRecord(id);
    }

    public void addRecord(Driverlist s) {
        driverlistDA.addRecord(s);
    }

    public void deleteRecord(Driverlist s) {
        driverlistDA.deleteRecord(s);
    }

    public void updateRecord(Driverlist s) {
        driverlistDA.updateRecord(s);
    }
    public ArrayList<Driverlist> getAllRecord() {
        return driverlistDA.getAllRecord();
    }
    public String getAfterLastCode() {
        return driverlistDA.getAfterLastCode();
    }
}
