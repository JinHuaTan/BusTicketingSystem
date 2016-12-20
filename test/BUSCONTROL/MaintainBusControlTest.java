/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Bus;
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
public class MaintainBusControlTest {
    
    public MaintainBusControlTest() {
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
     * Test of getAllColumnName method, of class MaintainBusControl.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        MaintainBusControl instance = new MaintainBusControl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class MaintainBusControl.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String counterName = "";
        String searchData = "";
        MaintainBusControl instance = new MaintainBusControl();
        ArrayList<Bus> expResult = null;
        ArrayList<Bus> result = instance.searchRecordByColumn(counterName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MaintainBusControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainBusControl instance = new MaintainBusControl();
        Bus expResult = null;
        Bus result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainBusControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Bus s = null;
        MaintainBusControl instance = new MaintainBusControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainBusControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Bus s = null;
        MaintainBusControl instance = new MaintainBusControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainBusControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Bus s = null;
        MaintainBusControl instance = new MaintainBusControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainBusControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainBusControl instance = new MaintainBusControl();
        ArrayList<Bus> expResult = null;
        ArrayList<Bus> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class MaintainBusControl.
     */
    @Test
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char c = ' ';
        MaintainBusControl instance = new MaintainBusControl();
        Bus expResult = null;
        Bus result = instance.displayRecord(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
