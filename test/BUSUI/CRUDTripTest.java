/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSDOMAIN.Counter;
import BUSDOMAIN.Staff;
import BUSDOMAIN.Trip;
import java.util.ArrayList;
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
public class CRUDTripTest {
    
    public CRUDTripTest() {
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
     * Test of design method, of class CRUDTrip.
     */
    @Test
    public void testDesign() {
        System.out.println("design");
        CRUDTrip instance = null;
        instance.design();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crudField method, of class CRUDTrip.
     */
    @Test
    public void testCrudField() {
        System.out.println("crudField");
        CRUDTrip instance = null;
        instance.crudField();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveTrip method, of class CRUDTrip.
     */
    @Test
    public void testRetrieveTrip() {
        System.out.println("retrieveTrip");
        Trip c = null;
        CRUDTrip instance = null;
        instance.retrieveTrip(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CRUDTrip.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CRUDTrip instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateButtonsInPanel method, of class CRUDTrip.
     */
    @Test
    public void testCreateButtonsInPanel() {
        System.out.println("CreateButtonsInPanel");
        ArrayList<Trip> busList = null;
        CRUDTrip instance = null;
        instance.CreateButtonsInPanel(busList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImageIcon method, of class CRUDTrip.
     */
    @Test
    public void testCreateImageIcon() {
        System.out.println("createImageIcon");
        String path = "";
        int w = 0;
        int h = 0;
        ImageIcon expResult = null;
        ImageIcon result = CRUDTrip.createImageIcon(path, w, h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of designPanel method, of class CRUDTrip.
     */
    @Test
    public void testDesignPanel() {
        System.out.println("designPanel");
        Counter ds = null;
        Staff s = null;
        CRUDTrip instance = null;
        instance.designPanel(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CRUDTrip.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CRUDTrip.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
