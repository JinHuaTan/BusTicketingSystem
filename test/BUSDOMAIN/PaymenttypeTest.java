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
 * @author Tan-LT
 */
public class PaymenttypeTest {
    
    public PaymenttypeTest() {
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
     * Test of getPymtid method, of class Paymenttype.
     */
    @Test
    public void testGetPymtid() {
        System.out.println("getPymtid");
        Paymenttype instance = new Paymenttype();
        String expResult = "";
        String result = instance.getPymtid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPymtid method, of class Paymenttype.
     */
    @Test
    public void testSetPymtid() {
        System.out.println("setPymtid");
        String pymtid = "";
        Paymenttype instance = new Paymenttype();
        instance.setPymtid(pymtid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymenttype method, of class Paymenttype.
     */
    @Test
    public void testGetPaymenttype() {
        System.out.println("getPaymenttype");
        Paymenttype instance = new Paymenttype();
        String expResult = "";
        String result = instance.getPaymenttype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymenttype method, of class Paymenttype.
     */
    @Test
    public void testSetPaymenttype() {
        System.out.println("setPaymenttype");
        String paymenttype = "";
        Paymenttype instance = new Paymenttype();
        instance.setPaymenttype(paymenttype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Paymenttype.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Paymenttype instance = new Paymenttype();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
