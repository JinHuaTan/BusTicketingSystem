/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Seatnumber;
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
public class MaintainSeatnumberControlTest {
    
    public MaintainSeatnumberControlTest() {
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
     * Test of selectRecord method, of class MaintainSeatnumberControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainSeatnumberControl instance = new MaintainSeatnumberControl();
        Seatnumber expResult = null;
        Seatnumber result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainSeatnumberControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Seatnumber s = null;
        MaintainSeatnumberControl instance = new MaintainSeatnumberControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainSeatnumberControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Seatnumber s = null;
        MaintainSeatnumberControl instance = new MaintainSeatnumberControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainSeatnumberControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Seatnumber s = null;
        MaintainSeatnumberControl instance = new MaintainSeatnumberControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainSeatnumberControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainSeatnumberControl instance = new MaintainSeatnumberControl();
        ArrayList<Seatnumber> expResult = null;
        ArrayList<Seatnumber> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
