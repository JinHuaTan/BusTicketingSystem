/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Trip;
import java.util.ArrayList;
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
public class MaintainTripControlTest {
    
    public MaintainTripControlTest() {
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
     * Test of getAllColumnName method, of class MaintainTripControl.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        MaintainTripControl instance = new MaintainTripControl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class MaintainTripControl.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String counterName = "";
        String searchData = "";
        MaintainTripControl instance = new MaintainTripControl();
        ArrayList<Trip> expResult = null;
        ArrayList<Trip> result = instance.searchRecordByColumn(counterName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MaintainTripControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainTripControl instance = new MaintainTripControl();
        Trip expResult = null;
        Trip result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainTripControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Trip s = null;
        MaintainTripControl instance = new MaintainTripControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainTripControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Trip s = null;
        MaintainTripControl instance = new MaintainTripControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainTripControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Trip s = null;
        MaintainTripControl instance = new MaintainTripControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainTripControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainTripControl instance = new MaintainTripControl();
        ArrayList<Trip> expResult = null;
        ArrayList<Trip> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class MaintainTripControl.
     */
    @Test
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char c = ' ';
        MaintainTripControl instance = new MaintainTripControl();
        Trip expResult = null;
        Trip result = instance.displayRecord(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
