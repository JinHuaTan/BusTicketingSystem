
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shaun Lee
 */
public class AnnualSalesReportTableModel extends AbstractTableModel{
     private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/busticket";
    static final String USERNAME = "root";
    static final String PASSWORD = "123456";
    String queryTrans = "SELECT MONTH(T.TRANSDATE) AS \"Month\",COUNT(A.TRANSID) AS \"Total Transaction Made\",SUM(A.TTLAMOUNT) AS \"Total Sales (RM)\" FROM TRANS T,(SELECT * FROM TRANS) A WHERE A.TRANSDATE=T.TRANSDATE GROUP BY MONTH(T.TRANSDATE)";
    
    public AnnualSalesReportTableModel() throws SQLException {
        conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        retrieveAll(queryTrans);
    }

    public Class getColumnClass(int column) throws IllegalStateException {
        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Object.class;
    }

    @Override
    public int getColumnCount() {

        try {
            return metaData.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public String getColumnName(int column) throws IllegalStateException {

        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public int getRowCount() {

        return numberOfRows;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
            throws IllegalStateException {

        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void retrieveAll(String query) throws SQLException {
        rs = stmt.executeQuery(query);
        metaData = rs.getMetaData();

        // determine number of rows in ResultSet
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number

        // notify JTable that model has changed
        fireTableStructureChanged();
    }


    public void retrieveByDate(String year) throws SQLException {
        rs = stmt.executeQuery("SELECT MONTH(T.TRANSDATE) AS \"Month\",COUNT(A.TRANSID) AS \"Total Transaction Made\",SUM(A.TTLAMOUNT) AS \"Total Sales (RM)\" FROM TRANS T,(SELECT * FROM TRANS WHERE TRANSDATE >= '"+year+"-01-01 00:00:00'  and TRANSDATE <= '"+year+"-12-31 23:59:59') A WHERE A.TRANSDATE=T.TRANSDATE GROUP BY MONTH(T.TRANSDATE)");

        metaData = rs.getMetaData();
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number

        // notify JTable that model has changed
        fireTableStructureChanged();
    }

    public static void main(String args[]) throws SQLException {
        JFrame frame = new JFrame();
        frame.add(new JTable(new AnnualSalesReportTableModel()));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

    }
}
