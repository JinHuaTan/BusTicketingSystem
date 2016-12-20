/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Staff;
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
public class MaintainStaffControlTest {
    
    public MaintainStaffControlTest() {
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
     * Test of getAllColumnName method, of class MaintainStaffControl.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        MaintainStaffControl instance = new MaintainStaffControl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class MaintainStaffControl.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String staffName = "";
        String searchData = "";
        MaintainStaffControl instance = new MaintainStaffControl();
        ArrayList<Staff> expResult = null;
        ArrayList<Staff> result = instance.searchRecordByColumn(staffName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MaintainStaffControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainStaffControl instance = new MaintainStaffControl();
        Staff expResult = null;
        Staff result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecordbyUsername method, of class MaintainStaffControl.
     */
    @Test
    public void testSelectRecordbyUsername() {
        System.out.println("selectRecordbyUsername");
        String username = "";
        MaintainStaffControl instance = new MaintainStaffControl();
        Staff expResult = null;
        Staff result = instance.selectRecordbyUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainStaffControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Staff s = null;
        MaintainStaffControl instance = new MaintainStaffControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainStaffControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Staff s = null;
        MaintainStaffControl instance = new MaintainStaffControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainStaffControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Staff s = null;
        MaintainStaffControl instance = new MaintainStaffControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainStaffControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainStaffControl instance = new MaintainStaffControl();
        ArrayList<Staff> expResult = null;
        ArrayList<Staff> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfterLastCode method, of class MaintainStaffControl.
     */
    @Test
    public void testGetAfterLastCode() {
        System.out.println("getAfterLastCode");
        MaintainStaffControl instance = new MaintainStaffControl();
        String expResult = "";
        String result = instance.getAfterLastCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
