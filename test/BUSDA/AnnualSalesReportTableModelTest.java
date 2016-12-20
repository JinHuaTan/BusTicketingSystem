/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tan-LT
 */
public class AnnualSalesReportTableModelTest {
    
    public AnnualSalesReportTableModelTest() {
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
    @Test
    public void testGetColumnClass() {
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
    @Test
    public void testGetColumnCount() {
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
    @Test
    public void testGetColumnName() {
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
    @Test
    public void testGetRowCount() {
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
    @Test
    public void testGetValueAt() {
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
    @Test
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
    @Test
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
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        AnnualSalesReportTableModel.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
