/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

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
public class CancelchangeIT {
    
    public CancelchangeIT() {
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
     * Test of getRecid method, of class Cancelchange.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetRecid() {
        System.out.println("getRecid");
        Cancelchange instance = new Cancelchange();
        String expResult = "";
        String result = instance.getRecid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecid method, of class Cancelchange.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetRecid() {
        System.out.println("setRecid");
        String recid = "";
        Cancelchange instance = new Cancelchange();
        instance.setRecid(recid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRefundtype method, of class Cancelchange.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetRefundtype() {
        System.out.println("getRefundtype");
        Cancelchange instance = new Cancelchange();
        String expResult = "";
        String result = instance.getRefundtype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRefundtype method, of class Cancelchange.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetRefundtype() {
        System.out.println("setRefundtype");
        String refundtype = "";
        Cancelchange instance = new Cancelchange();
        instance.setRefundtype(refundtype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmount method, of class Cancelchange.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetAmount() {
        System.out.println("getAmount");
        Cancelchange instance = new Cancelchange();
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmount method, of class Cancelchange.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetAmount() {
        System.out.println("setAmount");
        double amount = 0.0;
        Cancelchange instance = new Cancelchange();
        instance.setAmount(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Cancelchange.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testToString() {
        System.out.println("toString");
        Cancelchange instance = new Cancelchange();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
