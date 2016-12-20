/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSDOMAIN.Bus;
import BUSDOMAIN.Counter;
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
 * @author Tan-LT
 */
public class CRUDBusTest {
    
    public CRUDBusTest() {
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
     * Test of design method, of class CRUDBus.
     */
    @Test
    public void testDesign() {
        System.out.println("design");
        CRUDBus instance = null;
        instance.design();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crudField method, of class CRUDBus.
     */
    @Test
    public void testCrudField() {
        System.out.println("crudField");
        CRUDBus instance = null;
        instance.crudField();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveBus method, of class CRUDBus.
     */
    @Test
    public void testRetrieveBus() {
        System.out.println("retrieveBus");
        Bus c = null;
        CRUDBus instance = null;
        instance.retrieveBus(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CRUDBus.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CRUDBus instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateButtonsInPanel method, of class CRUDBus.
     */
    @Test
    public void testCreateButtonsInPanel() {
        System.out.println("CreateButtonsInPanel");
        ArrayList<Bus> busList = null;
        CRUDBus instance = null;
        instance.CreateButtonsInPanel(busList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImageIcon method, of class CRUDBus.
     */
    @Test
    public void testCreateImageIcon() {
        System.out.println("createImageIcon");
        String path = "";
        int w = 0;
        int h = 0;
        ImageIcon expResult = null;
        ImageIcon result = CRUDBus.createImageIcon(path, w, h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of designPanel method, of class CRUDBus.
     */
    @Test
    public void testDesignPanel() {
        System.out.println("designPanel");
        Counter ds = null;
        Staff s = null;
        CRUDBus instance = null;
        instance.designPanel(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CRUDBus.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CRUDBus.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
