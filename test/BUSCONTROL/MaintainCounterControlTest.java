/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Counter;
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
public class MaintainCounterControlTest {
    
    public MaintainCounterControlTest() {
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
     * Test of getAllColumnName method, of class MaintainCounterControl.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        MaintainCounterControl instance = new MaintainCounterControl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class MaintainCounterControl.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String counterName = "";
        String searchData = "";
        MaintainCounterControl instance = new MaintainCounterControl();
        ArrayList<Counter> expResult = null;
        ArrayList<Counter> result = instance.searchRecordByColumn(counterName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MaintainCounterControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainCounterControl instance = new MaintainCounterControl();
        Counter expResult = null;
        Counter result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainCounterControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainCounterControl instance = new MaintainCounterControl();
        ArrayList<Counter> expResult = null;
        ArrayList<Counter> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainCounterControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Counter s = null;
        MaintainCounterControl instance = new MaintainCounterControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainCounterControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Counter s = null;
        MaintainCounterControl instance = new MaintainCounterControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class MaintainCounterControl.
     */
    @Test
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char c = ' ';
        MaintainCounterControl instance = new MaintainCounterControl();
        Counter expResult = null;
        Counter result = instance.displayRecord(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainCounterControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Counter s = null;
        MaintainCounterControl instance = new MaintainCounterControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
