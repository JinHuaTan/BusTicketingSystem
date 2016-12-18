package BUSCONTROL;

import BUSDA.BusDA;
import BUSDOMAIN.Bus;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainBusControl {

    private BusDA busDA;

    public MaintainBusControl() {
        busDA = new BusDA();
    }
    
    public ArrayList<String> getAllColumnName() {
        return busDA.getAllColumnName();
    }

    public ArrayList<Bus> searchRecordByColumn(String counterName, String searchData) {
        return busDA.searchRecordByColumn(counterName, searchData);
    }
    

    public Bus selectRecord(String id) {
        return busDA.getRecord(id);
    }

    public void addRecord(Bus s) {
        busDA.addRecord(s);
    }

    public void deleteRecord(Bus s) {
        busDA.deleteRecord(s);
    }

    public void updateRecord(Bus s){
        busDA.updateRecord(s);
    }

    public ArrayList<Bus> getAllRecord() {
        return busDA.getAllRecord();
    }

    public Bus displayRecord(char c) {
        return selectRecord(busDA.displayRecord(c));
    }

}
