package BUSCONTROL;

import BUSDA.StaffDA;
import BUSDOMAIN.Staff;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainStaffControl {

    private StaffDA staffDA;

    public MaintainStaffControl() {
        staffDA = new StaffDA();
    }
    public ArrayList<String> getAllColumnName() {
        return staffDA.getAllColumnName();
    }

    public ArrayList<Staff> searchRecordByColumn(String staffName, String searchData) {
        return staffDA.searchRecordByColumn(staffName, searchData);
    }
    public Staff selectRecord(String id) {
        return staffDA.getRecord(id);
    }
    public Staff selectRecordbyUsername(String username) {
        return staffDA.getRecordByUsername(username);
    }
    public void addRecord(Staff s) {
        staffDA.addRecord(s);
    }

    public void deleteRecord(Staff s) {
        staffDA.deleteRecord(s);
    }

    public void updateRecord(Staff s){
        staffDA.updateRecord(s);
    }

    public ArrayList<Staff> getAllRecord() {
        return staffDA.getAllRecord();
    }
    public String getAfterLastCode() {
        return staffDA.getAfterLastCode();
    }

}
