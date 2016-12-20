/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Ticket;
import BUSDOMAIN.Trip;
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
public class MaintainTicketControlTest {
    
    public MaintainTicketControlTest() {
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
     * Test of selectRecord method, of class MaintainTicketControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainTicketControl instance = new MaintainTicketControl();
        Ticket expResult = null;
        Ticket result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainTicketControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Ticket s = null;
        MaintainTicketControl instance = new MaintainTicketControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainTicketControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Ticket s = null;
        MaintainTicketControl instance = new MaintainTicketControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainTicketControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Ticket s = null;
        MaintainTicketControl instance = new MaintainTicketControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainTicketControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainTicketControl instance = new MaintainTicketControl();
        ArrayList<Ticket> expResult = null;
        ArrayList<Ticket> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBunchTickets method, of class MaintainTicketControl.
     */
    @Test
    public void testCreateBunchTickets() {
        System.out.println("createBunchTickets");
        Trip t = null;
        MaintainTicketControl instance = new MaintainTicketControl();
        instance.createBunchTickets(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveBunchTickets method, of class MaintainTicketControl.
     */
    @Test
    public void testRetrieveBunchTickets() {
        System.out.println("retrieveBunchTickets");
        Trip t = null;
        MaintainTicketControl instance = new MaintainTicketControl();
        ArrayList<Ticket> expResult = null;
        ArrayList<Ticket> result = instance.retrieveBunchTickets(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBunchTickets method, of class MaintainTicketControl.
     */
    @Test
    public void testDeleteBunchTickets() {
        System.out.println("deleteBunchTickets");
        Trip t = null;
        MaintainTicketControl instance = new MaintainTicketControl();
        instance.deleteBunchTickets(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfterLastCode method, of class MaintainTicketControl.
     */
    @Test
    public void testGetAfterLastCode() {
        System.out.println("getAfterLastCode");
        MaintainTicketControl instance = new MaintainTicketControl();
        String expResult = "";
        String result = instance.getAfterLastCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecordbyTrip method, of class MaintainTicketControl.
     */
    @Test
    public void testDeleteRecordbyTrip() {
        System.out.println("deleteRecordbyTrip");
        Trip t = null;
        Ticket s = null;
        MaintainTicketControl instance = new MaintainTicketControl();
        instance.deleteRecordbyTrip(t, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
