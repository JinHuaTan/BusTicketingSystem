/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSDOMAIN.Ticket;
import BUSDOMAIN.Trip;
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
public class PurchaseTicketInfoTest {
    
    public PurchaseTicketInfoTest() {
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
     * Test of CreateTicketJButtons method, of class PurchaseTicketInfo.
     */
    @Test
    public void testCreateTicketJButtons() {
        System.out.println("CreateTicketJButtons");
        Trip t = null;
        PurchaseTicketInfo instance = null;
        instance.CreateTicketJButtons(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateButtonsInPanel method, of class PurchaseTicketInfo.
     */
    @Test
    public void testCreateButtonsInPanel() {
        System.out.println("CreateButtonsInPanel");
        String tripid = "";
        PurchaseTicketInfo instance = null;
        instance.CreateButtonsInPanel(tripid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTextInfo method, of class PurchaseTicketInfo.
     */
    @Test
    public void testSetTextInfo() {
        System.out.println("setTextInfo");
        Trip t = null;
        Ticket tc = null;
        PurchaseTicketInfo instance = null;
        instance.setTextInfo(t, tc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PurchaseTicketInfo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PurchaseTicketInfo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
