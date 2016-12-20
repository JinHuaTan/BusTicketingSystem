/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Driverlist;
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
public class MaintainDriverlistControlTest {
    
    public MaintainDriverlistControlTest() {
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
     * Test of selectRecord method, of class MaintainDriverlistControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainDriverlistControl instance = new MaintainDriverlistControl();
        Driverlist expResult = null;
        Driverlist result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainDriverlistControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Driverlist s = null;
        MaintainDriverlistControl instance = new MaintainDriverlistControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainDriverlistControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Driverlist s = null;
        MaintainDriverlistControl instance = new MaintainDriverlistControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainDriverlistControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Driverlist s = null;
        MaintainDriverlistControl instance = new MaintainDriverlistControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainDriverlistControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainDriverlistControl instance = new MaintainDriverlistControl();
        ArrayList<Driverlist> expResult = null;
        ArrayList<Driverlist> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfterLastCode method, of class MaintainDriverlistControl.
     */
    @Test
    public void testGetAfterLastCode() {
        System.out.println("getAfterLastCode");
        MaintainDriverlistControl instance = new MaintainDriverlistControl();
        String expResult = "";
        String result = instance.getAfterLastCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
