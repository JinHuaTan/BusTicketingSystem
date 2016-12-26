/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Trip;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class TripDAIT {
    
    public TripDAIT() {
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
     * Test of getAllColumnName method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        TripDA instance = new TripDA();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String tripName = "";
        String searchData = "";
        TripDA instance = new TripDA();
        ArrayList<Trip> expResult = null;
        ArrayList<Trip> result = instance.searchRecordByColumn(tripName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        TripDA instance = new TripDA();
        ArrayList<Trip> expResult = null;
        ArrayList<Trip> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        TripDA instance = new TripDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        TripDA instance = new TripDA();
        Trip expResult = null;
        Trip result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class TripDA.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testAddRecord() {
        System.out.println("addRecord");
        Trip s = null;
        TripDA instance = new TripDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Trip s = null;
        TripDA instance = new TripDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class TripDA.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Trip s = null;
        TripDA instance = new TripDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char command = ' ';
        TripDA instance = new TripDA();
        String expResult = "";
        String result = instance.displayRecord(command);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TripDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TripDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
