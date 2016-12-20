package BUSCONTROL;

import BUSDA.TripDA;
import BUSDOMAIN.Trip;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainTripControl {

    private TripDA tripDA;

    public MaintainTripControl() {
        tripDA = new TripDA();
    }

    public ArrayList<String> getAllColumnName() {
        return tripDA.getAllColumnName();
    }

    public ArrayList<Trip> searchRecordByColumn(String counterName, String searchData) {
        return tripDA.searchRecordByColumn(counterName, searchData);
    }

    public Trip selectRecord(String id) {
        return tripDA.getRecord(id);
    }

    public void addRecord(Trip s) {
        tripDA.addRecord(s);
    }

    public void deleteRecord(Trip s) {
        tripDA.deleteRecord(s);
    }

    public void updateRecord(Trip s) {
        tripDA.updateRecord(s);
    }

    public ArrayList<Trip> getAllRecord() {
        return tripDA.getAllRecord();
    }

    public Trip displayRecord(char c) {
        return selectRecord(tripDA.displayRecord(c));
    }

}
