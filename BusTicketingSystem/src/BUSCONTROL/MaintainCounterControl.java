package BUSCONTROL;

import BUSDA.CounterDA;
import BUSDOMAIN.Counter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MaintainCounterControl {

    private CounterDA counterDA;

    public MaintainCounterControl() {
        counterDA = new CounterDA();
    }

    public ArrayList<String> getAllColumnName() {
        return counterDA.getAllColumnName();
    }

    public ArrayList<Counter> searchRecordByColumn(String counterName, String searchData) {
        return counterDA.searchRecordByColumn(counterName, searchData);
    }

    public Counter selectRecord(String id) {
        return counterDA.getRecord(id);
    }

    public ArrayList<Counter> getAllRecord() {
        return counterDA.getAllRecord();
    }

    public void addRecord(Counter s) {
        counterDA.addRecord(s);
    }

    public void deleteRecord(Counter s) {
        counterDA.deleteRecord(s);
    }

    public Counter displayRecord(char c) {
        return selectRecord(counterDA.displayRecord(c));
    }

    public void updateRecord(Counter s) {
        counterDA.updateRecord(s);
    }
}
