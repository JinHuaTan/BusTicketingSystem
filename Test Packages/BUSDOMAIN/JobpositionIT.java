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
public class JobpositionIT {
    
    public JobpositionIT() {
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
     * Test of getPositionid method, of class Jobposition.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetPositionid() {
        System.out.println("getPositionid");
        Jobposition instance = new Jobposition();
        String expResult = "";
        String result = instance.getPositionid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionid method, of class Jobposition.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetPositionid() {
        System.out.println("setPositionid");
        String positionid = "";
        Jobposition instance = new Jobposition();
        instance.setPositionid(positionid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobposition method, of class Jobposition.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetJobposition() {
        System.out.println("getJobposition");
        Jobposition instance = new Jobposition();
        String expResult = "";
        String result = instance.getJobposition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJobposition method, of class Jobposition.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetJobposition() {
        System.out.println("setJobposition");
        String jobposition = "";
        Jobposition instance = new Jobposition();
        instance.setJobposition(jobposition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Jobposition.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testToString() {
        System.out.println("toString");
        Jobposition instance = new Jobposition();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
