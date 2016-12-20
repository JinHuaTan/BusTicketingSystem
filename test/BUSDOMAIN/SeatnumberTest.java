/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

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
public class SeatnumberTest {
    
    public SeatnumberTest() {
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
     * Test of getSeatid method, of class Seatnumber.
     */
    @Test
    public void testGetSeatid() {
        System.out.println("getSeatid");
        Seatnumber instance = new Seatnumber();
        String expResult = "";
        String result = instance.getSeatid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeatid method, of class Seatnumber.
     */
    @Test
    public void testSetSeatid() {
        System.out.println("setSeatid");
        String seatid = "";
        Seatnumber instance = new Seatnumber();
        instance.setSeatid(seatid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeatnumber method, of class Seatnumber.
     */
    @Test
    public void testGetSeatnumber() {
        System.out.println("getSeatnumber");
        Seatnumber instance = new Seatnumber();
        String expResult = "";
        String result = instance.getSeatnumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeatnumber method, of class Seatnumber.
     */
    @Test
    public void testSetSeatnumber() {
        System.out.println("setSeatnumber");
        String seatnumber = "";
        Seatnumber instance = new Seatnumber();
        instance.setSeatnumber(seatnumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Seatnumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Seatnumber instance = new Seatnumber();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
