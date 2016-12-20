/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Route;
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
public class MaintainRouteControlTest {
    
    public MaintainRouteControlTest() {
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
     * Test of getAllColumnName method, of class MaintainRouteControl.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        MaintainRouteControl instance = new MaintainRouteControl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class MaintainRouteControl.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String counterName = "";
        String searchData = "";
        MaintainRouteControl instance = new MaintainRouteControl();
        ArrayList<Route> expResult = null;
        ArrayList<Route> result = instance.searchRecordByColumn(counterName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MaintainRouteControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainRouteControl instance = new MaintainRouteControl();
        Route expResult = null;
        Route result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainRouteControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Route s = null;
        MaintainRouteControl instance = new MaintainRouteControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainRouteControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Route s = null;
        MaintainRouteControl instance = new MaintainRouteControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainRouteControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Route s = null;
        MaintainRouteControl instance = new MaintainRouteControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainRouteControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainRouteControl instance = new MaintainRouteControl();
        ArrayList<Route> expResult = null;
        ArrayList<Route> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class MaintainRouteControl.
     */
    @Test
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char c = ' ';
        MaintainRouteControl instance = new MaintainRouteControl();
        Route expResult = null;
        Route result = instance.displayRecord(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
