/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Bus;
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
 * @author Tan-LT
 */
public class BusDATest {
    
    public BusDATest() {
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
     * Test of getAllColumnName method, of class BusDA.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        BusDA instance = new BusDA();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class BusDA.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String busName = "";
        String searchData = "";
        BusDA instance = new BusDA();
        ArrayList<Bus> expResult = null;
        ArrayList<Bus> result = instance.searchRecordByColumn(busName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class BusDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        BusDA instance = new BusDA();
        ArrayList<Bus> expResult = null;
        ArrayList<Bus> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class BusDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        BusDA instance = new BusDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class BusDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        BusDA instance = new BusDA();
        Bus expResult = null;
        Bus result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class BusDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Bus s = null;
        BusDA instance = new BusDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class BusDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Bus s = null;
        BusDA instance = new BusDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class BusDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Bus s = null;
        BusDA instance = new BusDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class BusDA.
     */
    @Test
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char command = ' ';
        BusDA instance = new BusDA();
        String expResult = "";
        String result = instance.displayRecord(command);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class BusDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BusDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
