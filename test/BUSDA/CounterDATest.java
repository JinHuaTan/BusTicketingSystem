/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Counter;
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
public class CounterDATest {
    
    public CounterDATest() {
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
     * Test of getAllColumnName method, of class CounterDA.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        CounterDA instance = new CounterDA();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class CounterDA.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String counterName = "";
        String searchData = "";
        CounterDA instance = new CounterDA();
        ArrayList<Counter> expResult = null;
        ArrayList<Counter> result = instance.searchRecordByColumn(counterName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class CounterDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        CounterDA instance = new CounterDA();
        ArrayList<Counter> expResult = null;
        ArrayList<Counter> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class CounterDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        CounterDA instance = new CounterDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class CounterDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        CounterDA instance = new CounterDA();
        Counter expResult = null;
        Counter result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class CounterDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Counter s = null;
        CounterDA instance = new CounterDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class CounterDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Counter s = null;
        CounterDA instance = new CounterDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class CounterDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Counter s = null;
        CounterDA instance = new CounterDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class CounterDA.
     */
    @Test
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char command = ' ';
        CounterDA instance = new CounterDA();
        String expResult = "";
        String result = instance.displayRecord(command);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CounterDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CounterDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
