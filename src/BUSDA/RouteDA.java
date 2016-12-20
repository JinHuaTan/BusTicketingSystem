/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

/**
 *
 * @author Student
 */
import BUSCONTROL.MaintainBoardingControl;
import BUSCONTROL.MaintainDslocationControl;
import BUSCONTROL.MaintainRouteControl;
import BUSDOMAIN.Boarding;
import BUSDOMAIN.Route;
import BUSDOMAIN.Dslocation;
import BUSDOMAIN.Route;
import BUSDOMAIN.Staff;
import BUSDOMAIN.Route;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class RouteDA {

    private final String host = "jdbc:derby://localhost:1527/busticket";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "Route";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private MaintainDslocationControl mdc;
    private MaintainBoardingControl mbdc;
    private MaintainBoardingControl mdcc;

    public RouteDA() {
        createConnection();
        mdc = new MaintainDslocationControl();
        mbdc = new MaintainBoardingControl();
        mdcc = new MaintainBoardingControl();

    }
    
    public ArrayList<String> getAllColumnName() {
        ArrayList<String> s = new ArrayList<String>();
        ResultSet rs = null;
        try {
            String queryStr = "SELECT * FROM " + tableName;
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                s.add(rsmd.getColumnName(i));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllColumnName, SQLException in RouteDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }

    public ArrayList<Route> searchRecordByColumn(String routeName, String searchData) {
        ArrayList<Route> routeList = new ArrayList<Route>();
        String queryStr = "SELECT * FROM " + tableName + " where " + routeName + " LIKE '%" + searchData + "%'";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Route route = getRecord(rs.getString(1));
                routeList.add(route);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "searchRecordByColumn, SQLException in RouteDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return routeList;
    }

    public ArrayList<Route> getAllRecord() {
        ArrayList<Route> routeList = new ArrayList<Route>();
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Route route = getRecord(rs.getString(1));
                routeList.add(route);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllRecord, SQLException in RouteDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return routeList;
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE routeid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "selectRecord, SQLException in RouteDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Route getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE routeid = ?";
        Route route = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Dslocation srcl = mdc.selectRecord(rs.getString(2));
                Dslocation destl = mdc.selectRecord(rs.getString(3));
                Boarding bd = mbdc.selectRecord(rs.getString(5));
                Boarding dd = mdcc.selectRecord(rs.getString(6));
                route = new Route(rs.getString(1), srcl, destl, rs.getDouble(4), bd, dd);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getRecord, SQLException in RouteDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return route;
    }

    public void addRecord(Route s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?, ?,?)";

        try {
            ResultSet rs = selectRecord(s.getRouteid());
            if (!rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getRouteid());
                stmt.setString(2, s.getSourceid().getDestid());
                stmt.setString(3, s.getDestid().getDestid());
                stmt.setDouble(4, s.getDistance());
                stmt.setString(5, s.getBdpid().getBdpid());
                stmt.setString(6, s.getDppid().getBdpid());
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "addRecord, SQLException in RouteDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecord(Route s) {
        String queryStr = "Update " + tableName + " set SOURCEID = ? , DESTID = ? ,"
                + " DISTANCE = ?, BDPID = ?, DPPID=? WHERE ROUTEID = ?";

        try {
            ResultSet rs = selectRecord(s.getRouteid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getSourceid().getDestid());
                stmt.setString(2, s.getDestid().getDestid());
                stmt.setDouble(3, s.getDistance());
                stmt.setString(4, s.getBdpid().getBdpid());
                stmt.setString(5, s.getDppid().getBdpid());
                stmt.setString(6, s.getRouteid());
                stmt.executeUpdate();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in RouteDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Route s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE routeid = ?";

        try {
            ResultSet rs = selectRecord(s.getRouteid());
            if (rs.next()) {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, s.getRouteid());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteRecord, SQLException in RouteDA" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public String displayRecord(char command) {
        String ID = "";
        try {
            if (command == 'L') {
                if (rs.isFirst() || rs.isBeforeFirst()) {
                    rs.last();
                } else {
                    rs.previous();
                }
            } else if (command == 'R') {
                if (rs.isLast()) {
                    rs.first();
                } else {
                    rs.next();
                }
            }
            ID = rs.getString(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No record to diplay!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ID;
    }

    private void createConnection() {
        String sqlStr;
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY routeid";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(" ***TRACE: Route Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in RouteDA " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("RouteDA successfully launched");
    }
}
