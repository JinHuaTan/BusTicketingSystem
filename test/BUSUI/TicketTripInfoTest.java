/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSDOMAIN.Counter;
import BUSDOMAIN.Staff;
import BUSDOMAIN.Trip;
import javax.swing.ImageIcon;
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
public class TicketTripInfoTest {
    
    public TicketTripInfoTest() {
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
     * Test of designPanel method, of class TicketTripInfo.
     */
    @Test
    public void testDesignPanel() {
        System.out.println("designPanel");
        Counter ds = null;
        Staff s = null;
        TicketTripInfo instance = null;
        instance.designPanel(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateTripJButton method, of class TicketTripInfo.
     */
    @Test
    public void testCreateTripJButton() {
        System.out.println("CreateTripJButton");
        Trip r = null;
        TicketTripInfo instance = null;
        instance.CreateTripJButton(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateButtonsInPanel method, of class TicketTripInfo.
     */
    @Test
    public void testCreateButtonsInPanel() {
        System.out.println("CreateButtonsInPanel");
        String src = "";
        String dest = "";
        TicketTripInfo instance = null;
        instance.CreateButtonsInPanel(src, dest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CompareDateWithTrip method, of class TicketTripInfo.
     */
    @Test
    public void testCompareDateWithTrip() {
        System.out.println("CompareDateWithTrip");
        Trip t = null;
        int d = 0;
        int m = 0;
        int y = 0;
        TicketTripInfo instance = null;
        instance.CompareDateWithTrip(t, d, m, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CompareDateWithJcombo method, of class TicketTripInfo.
     */
    @Test
    public void testCompareDateWithJcombo() {
        System.out.println("CompareDateWithJcombo");
        int d = 0;
        int m = 0;
        int y = 0;
        TicketTripInfo instance = null;
        boolean expResult = false;
        boolean result = instance.CompareDateWithJcombo(d, m, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImageIcon method, of class TicketTripInfo.
     */
    @Test
    public void testCreateImageIcon() {
        System.out.println("createImageIcon");
        String path = "";
        int w = 0;
        int h = 0;
        ImageIcon expResult = null;
        ImageIcon result = TicketTripInfo.createImageIcon(path, w, h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TicketTripInfo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TicketTripInfo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
