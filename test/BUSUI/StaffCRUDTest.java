/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

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
public class StaffCRUDTest {
    
    public StaffCRUDTest() {
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
     * Test of design method, of class StaffCRUD.
     */
    @Test
    public void testDesign() {
        System.out.println("design");
        Counter ds = null;
        Staff s = null;
        StaffCRUD instance = null;
        instance.design(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateButtonsInPanel method, of class StaffCRUD.
     */
    @Test
    public void testCreateButtonsInPanel() {
        System.out.println("CreateButtonsInPanel");
        ArrayList<Staff> staffList = null;
        StaffCRUD instance = null;
        instance.CreateButtonsInPanel(staffList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImageIcon method, of class StaffCRUD.
     */
    @Test
    public void testCreateImageIcon() {
        System.out.println("createImageIcon");
        String path = "";
        int w = 0;
        int h = 0;
        ImageIcon expResult = null;
        ImageIcon result = StaffCRUD.createImageIcon(path, w, h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of designPanel method, of class StaffCRUD.
     */
    @Test
    public void testDesignPanel() {
        System.out.println("designPanel");
        Counter ds = null;
        Staff s = null;
        StaffCRUD instance = null;
        instance.designPanel(ds, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class StaffCRUD.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StaffCRUD.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
