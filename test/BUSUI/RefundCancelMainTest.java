/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import BUSDOMAIN.Counter;
import BUSDOMAIN.Staff;
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
public class RefundCancelMainTest {
    
    public RefundCancelMainTest() {
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
     * Test of design method, of class RefundCancelMain.
     */
    @Test
    public void testDesign() {
        System.out.println("design");
        Counter ds = null;
        Staff s = null;
        RefundCancelMain instance = null;
        instance.design(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of designPanel method, of class RefundCancelMain.
     */
    @Test
    public void testDesignPanel() {
        System.out.println("designPanel");
        Counter ds = null;
        Staff s = null;
        RefundCancelMain instance = null;
        instance.designPanel(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImageIcon method, of class RefundCancelMain.
     */
    @Test
    public void testCreateImageIcon() {
        System.out.println("createImageIcon");
        String path = "";
        int w = 0;
        int h = 0;
        ImageIcon expResult = null;
        ImageIcon result = RefundCancelMain.createImageIcon(path, w, h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class RefundCancelMain.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RefundCancelMain.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
