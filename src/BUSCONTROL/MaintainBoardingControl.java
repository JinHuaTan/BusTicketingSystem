package BUSCONTROL;

import BUSDA.BoardingDA;
import BUSDOMAIN.Boarding;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainBoardingControl {

    private BoardingDA boardingDA;

    public MaintainBoardingControl() {
        boardingDA = new BoardingDA();
    }

    public Boarding selectRecord(String id) {
        return boardingDA.getRecord(id);
    }

    public void addRecord(Boarding s) {
        boardingDA.addRecord(s);
    }

    public void deleteRecord(Boarding s) {
        boardingDA.deleteRecord(s);
    }

    public void updateRecord(Boarding s){
        boardingDA.updateRecord(s);
    }
    
     public ArrayList<Boarding> getAllRecord() {
        return boardingDA.getAllRecord();
    }
}
