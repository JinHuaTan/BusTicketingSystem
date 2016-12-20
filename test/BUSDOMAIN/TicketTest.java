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
public class TicketTest {
    
    public TicketTest() {
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
     * Test of getTripid method, of class Ticket.
     */
    @Test
    public void testGetTripid() {
        System.out.println("getTripid");
        Ticket instance = new Ticket();
        Trip expResult = null;
        Trip result = instance.getTripid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTripid method, of class Ticket.
     */
    @Test
    public void testSetTripid() {
        System.out.println("setTripid");
        Trip tripid = null;
        Ticket instance = new Ticket();
        instance.setTripid(tripid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransid method, of class Ticket.
     */
    @Test
    public void testGetTransid() {
        System.out.println("getTransid");
        Ticket instance = new Ticket();
        Trans expResult = null;
        Trans result = instance.getTransid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransid method, of class Ticket.
     */
    @Test
    public void testSetTransid() {
        System.out.println("setTransid");
        Trans transid = null;
        Ticket instance = new Ticket();
        instance.setTransid(transid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketid method, of class Ticket.
     */
    @Test
    public void testGetTicketid() {
        System.out.println("getTicketid");
        Ticket instance = new Ticket();
        String expResult = "";
        String result = instance.getTicketid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTicketid method, of class Ticket.
     */
    @Test
    public void testSetTicketid() {
        System.out.println("setTicketid");
        String ticketid = "";
        Ticket instance = new Ticket();
        instance.setTicketid(ticketid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailability method, of class Ticket.
     */
    @Test
    public void testGetAvailability() {
        System.out.println("getAvailability");
        Ticket instance = new Ticket();
        int expResult = 0;
        int result = instance.getAvailability();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailability method, of class Ticket.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        int availability = 0;
        Ticket instance = new Ticket();
        instance.setAvailability(availability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeatid method, of class Ticket.
     */
    @Test
    public void testGetSeatid() {
        System.out.println("getSeatid");
        Ticket instance = new Ticket();
        Seatnumber expResult = null;
        Seatnumber result = instance.getSeatid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeatid method, of class Ticket.
     */
    @Test
    public void testSetSeatid() {
        System.out.println("setSeatid");
        Seatnumber seatid = null;
        Ticket instance = new Ticket();
        instance.setSeatid(seatid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Ticket.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ticket instance = new Ticket();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
