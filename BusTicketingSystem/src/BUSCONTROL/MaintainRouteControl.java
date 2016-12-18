package BUSCONTROL;

import BUSDA.RouteDA;
import BUSDOMAIN.Route;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainRouteControl {

    private RouteDA routeDA;

    public MaintainRouteControl() {
        routeDA = new RouteDA();
    }

    public ArrayList<String> getAllColumnName() {
        return routeDA.getAllColumnName();
    }

    public ArrayList<Route> searchRecordByColumn(String counterName, String searchData) {
        return routeDA.searchRecordByColumn(counterName, searchData);
    }
    
    public Route selectRecord(String id) {
        return routeDA.getRecord(id);
    }

    public void addRecord(Route s) {
        routeDA.addRecord(s);
    }

    public void deleteRecord(Route s) {
        routeDA.deleteRecord(s);
    }

    public void updateRecord(Route s){
        routeDA.updateRecord(s);
    }
    
    public ArrayList<Route> getAllRecord() {
        return routeDA.getAllRecord();
    }
    public Route displayRecord(char c) {
        return selectRecord(routeDA.displayRecord(c));
    }
}
