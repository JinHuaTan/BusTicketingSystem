/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Ticket;
import BUSDOMAIN.Trip;
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
public class TicketDATest {
    
    public TicketDATest() {
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
     * Test of getAllRecord method, of class TicketDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        TicketDA instance = new TicketDA();
        ArrayList<Ticket> expResult = null;
        ArrayList<Ticket> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveBunchTickets method, of class TicketDA.
     */
    @Test
    public void testRetrieveBunchTickets() {
        System.out.println("retrieveBunchTickets");
        Trip t = null;
        TicketDA instance = new TicketDA();
        ArrayList<Ticket> expResult = null;
        ArrayList<Ticket> result = instance.retrieveBunchTickets(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBunchTickets method, of class TicketDA.
     */
    @Test
    public void testCreateBunchTickets() {
        System.out.println("createBunchTickets");
        Trip t = null;
        TicketDA instance = new TicketDA();
        instance.createBunchTickets(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBunchTickets method, of class TicketDA.
     */
    @Test
    public void testDeleteBunchTickets() {
        System.out.println("deleteBunchTickets");
        Trip t = null;
        TicketDA instance = new TicketDA();
        instance.deleteBunchTickets(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class TicketDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        TicketDA instance = new TicketDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class TicketDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        TicketDA instance = new TicketDA();
        Ticket expResult = null;
        Ticket result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfterLastCode method, of class TicketDA.
     */
    @Test
    public void testGetAfterLastCode() {
        System.out.println("getAfterLastCode");
        TicketDA instance = new TicketDA();
        String expResult = "";
        String result = instance.getAfterLastCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class TicketDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Ticket s = null;
        TicketDA instance = new TicketDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class TicketDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Ticket s = null;
        TicketDA instance = new TicketDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class TicketDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Ticket s = null;
        TicketDA instance = new TicketDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecordbyTrip method, of class TicketDA.
     */
    @Test
    public void testDeleteRecordbyTrip() {
        System.out.println("deleteRecordbyTrip");
        Trip t = null;
        Ticket s = null;
        TicketDA instance = new TicketDA();
        instance.deleteRecordbyTrip(t, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TicketDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TicketDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
