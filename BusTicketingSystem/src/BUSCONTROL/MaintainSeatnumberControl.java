package BUSCONTROL;

import BUSDA.SeatnumberDA;
import BUSDOMAIN.Seatnumber;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainSeatnumberControl {

    private SeatnumberDA seatnumberDA;

    public MaintainSeatnumberControl() {
        seatnumberDA = new SeatnumberDA();
    }

    public Seatnumber selectRecord(String id) {
        return seatnumberDA.getRecord(id);
    }

    public void addRecord(Seatnumber s) {
        seatnumberDA.addRecord(s);
    }

    public void deleteRecord(Seatnumber s) {
        seatnumberDA.deleteRecord(s);
    }

    public void updateRecord(Seatnumber s){
        seatnumberDA.updateRecord(s);
    }
    
     public ArrayList<Seatnumber> getAllRecord() {
        return seatnumberDA.getAllRecord();
    }
     

}
