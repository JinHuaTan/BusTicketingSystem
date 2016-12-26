/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSDOMAIN.Counter;
import BUSDOMAIN.Route;
import BUSDOMAIN.Staff;
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
 * @author Shaun Lee
 */
public class CRUDRouteIT {
    
    public CRUDRouteIT() {
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
     * Test of design method, of class CRUDRoute.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testDesign() {
        System.out.println("design");
        CRUDRoute instance = null;
        instance.design();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crudField method, of class CRUDRoute.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testCrudField() {
        System.out.println("crudField");
        CRUDRoute instance = null;
        instance.crudField();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveRoute method, of class CRUDRoute.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testRetrieveRoute() {
        System.out.println("retrieveRoute");
        Route c = null;
        CRUDRoute instance = null;
        instance.retrieveRoute(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CRUDRoute.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testClear() {
        System.out.println("clear");
        CRUDRoute instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateButtonsInPanel method, of class CRUDRoute.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testCreateButtonsInPanel() {
        System.out.println("CreateButtonsInPanel");
        ArrayList<Route> busList = null;
        CRUDRoute instance = null;
        instance.CreateButtonsInPanel(busList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImageIcon method, of class CRUDRoute.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testCreateImageIcon() {
        System.out.println("createImageIcon");
        String path = "";
        int w = 0;
        int h = 0;
        ImageIcon expResult = null;
        ImageIcon result = CRUDRoute.createImageIcon(path, w, h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of designPanel method, of class CRUDRoute.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testDesignPanel() {
        System.out.println("designPanel");
        Counter ds = null;
        Staff s = null;
        CRUDRoute instance = null;
        instance.designPanel(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CRUDRoute.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CRUDRoute.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
