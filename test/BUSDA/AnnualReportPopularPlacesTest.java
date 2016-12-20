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
public class AnnualReportPopularPlacesTest {
    
    public AnnualReportPopularPlacesTest() {
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
     * Test of getColumnClass method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testGetColumnClass() {
        System.out.println("getColumnClass");
        int column = 0;
        AnnualReportPopularPlaces instance = new AnnualReportPopularPlaces();
        Class expResult = null;
        Class result = instance.getColumnClass(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        AnnualReportPopularPlaces instance = new AnnualReportPopularPlaces();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        AnnualReportPopularPlaces instance = new AnnualReportPopularPlaces();
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        AnnualReportPopularPlaces instance = new AnnualReportPopularPlaces();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int rowIndex = 0;
        int columnIndex = 0;
        AnnualReportPopularPlaces instance = new AnnualReportPopularPlaces();
        Object expResult = null;
        Object result = instance.getValueAt(rowIndex, columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveAll method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testRetrieveAll() throws Exception {
        System.out.println("retrieveAll");
        String query = "";
        AnnualReportPopularPlaces instance = new AnnualReportPopularPlaces();
        instance.retrieveAll(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByDate method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testRetrieveByDate() throws Exception {
        System.out.println("retrieveByDate");
        String year = "";
        AnnualReportPopularPlaces instance = new AnnualReportPopularPlaces();
        instance.retrieveByDate(year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AnnualReportPopularPlaces.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        AnnualReportPopularPlaces.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
