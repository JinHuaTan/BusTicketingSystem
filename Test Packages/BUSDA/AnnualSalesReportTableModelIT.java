/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shaun Lee
 */
public class AnnualSalesReportTableModelIT {
    
    public AnnualSalesReportTableModelIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getColumnClass method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetColumnClass() throws SQLException {
        System.out.println("getColumnClass");
        int column = 0;
        AnnualSalesReportTableModel instance = new AnnualSalesReportTableModel();
        Class expResult = null;
        Class result = instance.getColumnClass(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetColumnCount() throws SQLException {
        System.out.println("getColumnCount");
        AnnualSalesReportTableModel instance = new AnnualSalesReportTableModel();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetColumnName() throws SQLException {
        System.out.println("getColumnName");
        int column = 0;
        AnnualSalesReportTableModel instance = new AnnualSalesReportTableModel();
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetRowCount() throws SQLException {
        System.out.println("getRowCount");
        AnnualSalesReportTableModel instance = new AnnualSalesReportTableModel();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetValueAt() throws SQLException {
        System.out.println("getValueAt");
        int rowIndex = 0;
        int columnIndex = 0;
        AnnualSalesReportTableModel instance = new AnnualSalesReportTableModel();
        Object expResult = null;
        Object result = instance.getValueAt(rowIndex, columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveAll method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.sql.SQLSyntaxErrorException.class)
    public void testRetrieveAll() throws Exception {
        System.out.println("retrieveAll");
        String query = "";
        AnnualSalesReportTableModel instance = new AnnualSalesReportTableModel();
        instance.retrieveAll(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByDate method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.sql.SQLDataException.class)
    public void testRetrieveByDate() throws Exception {
        System.out.println("retrieveByDate");
        String year = "";
        AnnualSalesReportTableModel instance = new AnnualSalesReportTableModel();
        instance.retrieveByDate(year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AnnualSalesReportTableModel.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        AnnualSalesReportTableModel.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
