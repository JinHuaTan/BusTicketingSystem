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
public class CounterTest {
    
    public CounterTest() {
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
     * Test of getCounterid method, of class Counter.
     */
    @Test
    public void testGetCounterid() {
        System.out.println("getCounterid");
        Counter instance = new Counter();
        String expResult = "";
        String result = instance.getCounterid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCounterid method, of class Counter.
     */
    @Test
    public void testSetCounterid() {
        System.out.println("setCounterid");
        String counterid = "";
        Counter instance = new Counter();
        instance.setCounterid(counterid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCounteradd method, of class Counter.
     */
    @Test
    public void testGetCounteradd() {
        System.out.println("getCounteradd");
        Counter instance = new Counter();
        String expResult = "";
        String result = instance.getCounteradd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCounteradd method, of class Counter.
     */
    @Test
    public void testSetCounteradd() {
        System.out.println("setCounteradd");
        String counteradd = "";
        Counter instance = new Counter();
        instance.setCounteradd(counteradd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactnum method, of class Counter.
     */
    @Test
    public void testGetContactnum() {
        System.out.println("getContactnum");
        Counter instance = new Counter();
        String expResult = "";
        String result = instance.getContactnum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContactnum method, of class Counter.
     */
    @Test
    public void testSetContactnum() {
        System.out.println("setContactnum");
        String contactnum = "";
        Counter instance = new Counter();
        instance.setContactnum(contactnum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupervisorid method, of class Counter.
     */
    @Test
    public void testGetSupervisorid() {
        System.out.println("getSupervisorid");
        Counter instance = new Counter();
        Staff expResult = null;
        Staff result = instance.getSupervisorid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSupervisorid method, of class Counter.
     */
    @Test
    public void testSetSupervisorid() {
        System.out.println("setSupervisorid");
        Staff supervisorid = null;
        Counter instance = new Counter();
        instance.setSupervisorid(supervisorid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestid method, of class Counter.
     */
    @Test
    public void testGetDestid() {
        System.out.println("getDestid");
        Counter instance = new Counter();
        Dslocation expResult = null;
        Dslocation result = instance.getDestid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestid method, of class Counter.
     */
    @Test
    public void testSetDestid() {
        System.out.println("setDestid");
        Dslocation destid = null;
        Counter instance = new Counter();
        instance.setDestid(destid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Counter.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Counter instance = new Counter();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
