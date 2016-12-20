/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
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
public class PasswordHolderUITest {
    
    public PasswordHolderUITest() {
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
     * Test of getColor method, of class PasswordHolderUI.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        PasswordHolderUI instance = null;
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class PasswordHolderUI.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = null;
        PasswordHolderUI instance = null;
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHideOnFocus method, of class PasswordHolderUI.
     */
    @Test
    public void testIsHideOnFocus() {
        System.out.println("isHideOnFocus");
        PasswordHolderUI instance = null;
        boolean expResult = false;
        boolean result = instance.isHideOnFocus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHideOnFocus method, of class PasswordHolderUI.
     */
    @Test
    public void testSetHideOnFocus() {
        System.out.println("setHideOnFocus");
        boolean hideOnFocus = false;
        PasswordHolderUI instance = null;
        instance.setHideOnFocus(hideOnFocus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHint method, of class PasswordHolderUI.
     */
    @Test
    public void testGetHint() {
        System.out.println("getHint");
        PasswordHolderUI instance = null;
        String expResult = "";
        String result = instance.getHint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHint method, of class PasswordHolderUI.
     */
    @Test
    public void testSetHint() {
        System.out.println("setHint");
        String hint = "";
        PasswordHolderUI instance = null;
        instance.setHint(hint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintSafely method, of class PasswordHolderUI.
     */
    @Test
    public void testPaintSafely() {
        System.out.println("paintSafely");
        Graphics g = null;
        PasswordHolderUI instance = null;
        instance.paintSafely(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of focusGained method, of class PasswordHolderUI.
     */
    @Test
    public void testFocusGained() {
        System.out.println("focusGained");
        FocusEvent e = null;
        PasswordHolderUI instance = null;
        instance.focusGained(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of focusLost method, of class PasswordHolderUI.
     */
    @Test
    public void testFocusLost() {
        System.out.println("focusLost");
        FocusEvent e = null;
        PasswordHolderUI instance = null;
        instance.focusLost(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of installListeners method, of class PasswordHolderUI.
     */
    @Test
    public void testInstallListeners() {
        System.out.println("installListeners");
        PasswordHolderUI instance = null;
        instance.installListeners();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uninstallListeners method, of class PasswordHolderUI.
     */
    @Test
    public void testUninstallListeners() {
        System.out.println("uninstallListeners");
        PasswordHolderUI instance = null;
        instance.uninstallListeners();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
