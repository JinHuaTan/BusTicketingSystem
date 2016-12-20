/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Staff;
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
public class StaffDATest {
    
    public StaffDATest() {
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
     * Test of getAllColumnName method, of class StaffDA.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        StaffDA instance = new StaffDA();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class StaffDA.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String staffName = "";
        String searchData = "";
        StaffDA instance = new StaffDA();
        ArrayList<Staff> expResult = null;
        ArrayList<Staff> result = instance.searchRecordByColumn(staffName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class StaffDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        StaffDA instance = new StaffDA();
        ArrayList<Staff> expResult = null;
        ArrayList<Staff> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class StaffDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        StaffDA instance = new StaffDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class StaffDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        StaffDA instance = new StaffDA();
        Staff expResult = null;
        Staff result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecordByUsername method, of class StaffDA.
     */
    @Test
    public void testGetRecordByUsername() {
        System.out.println("getRecordByUsername");
        String USERNAME = "";
        StaffDA instance = new StaffDA();
        Staff expResult = null;
        Staff result = instance.getRecordByUsername(USERNAME);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class StaffDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Staff s = null;
        StaffDA instance = new StaffDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class StaffDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Staff s = null;
        StaffDA instance = new StaffDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class StaffDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Staff s = null;
        StaffDA instance = new StaffDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfterLastCode method, of class StaffDA.
     */
    @Test
    public void testGetAfterLastCode() {
        System.out.println("getAfterLastCode");
        StaffDA instance = new StaffDA();
        String expResult = "";
        String result = instance.getAfterLastCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class StaffDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StaffDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
