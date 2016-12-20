/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSDOMAIN.Counter;
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
public class CRUDCounterTest {
    
    public CRUDCounterTest() {
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
     * Test of design method, of class CRUDCounter.
     */
    @Test
    public void testDesign() {
        System.out.println("design");
        CRUDCounter instance = new CRUDCounter();
        instance.design();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crudField method, of class CRUDCounter.
     */
    @Test
    public void testCrudField() {
        System.out.println("crudField");
        CRUDCounter instance = new CRUDCounter();
        instance.crudField();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveCounter method, of class CRUDCounter.
     */
    @Test
    public void testRetrieveCounter() {
        System.out.println("retrieveCounter");
        Counter c = null;
        CRUDCounter instance = new CRUDCounter();
        instance.retrieveCounter(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CRUDCounter.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CRUDCounter instance = new CRUDCounter();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateButtonsInPanel method, of class CRUDCounter.
     */
    @Test
    public void testCreateButtonsInPanel() {
        System.out.println("CreateButtonsInPanel");
        ArrayList<Counter> busList = null;
        CRUDCounter instance = new CRUDCounter();
        instance.CreateButtonsInPanel(busList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImageIcon method, of class CRUDCounter.
     */
    @Test
    public void testCreateImageIcon() {
        System.out.println("createImageIcon");
        String path = "";
        int w = 0;
        int h = 0;
        ImageIcon expResult = null;
        ImageIcon result = CRUDCounter.createImageIcon(path, w, h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CRUDCounter.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CRUDCounter.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
