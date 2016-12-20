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
public class RouteTest {
    
    public RouteTest() {
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
     * Test of getRouteid method, of class Route.
     */
    @Test
    public void testGetRouteid() {
        System.out.println("getRouteid");
        Route instance = new Route();
        String expResult = "";
        String result = instance.getRouteid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRouteid method, of class Route.
     */
    @Test
    public void testSetRouteid() {
        System.out.println("setRouteid");
        String routeid = "";
        Route instance = new Route();
        instance.setRouteid(routeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistance method, of class Route.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Route instance = new Route();
        double expResult = 0.0;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDistance method, of class Route.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        double distance = 0.0;
        Route instance = new Route();
        instance.setDistance(distance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBdpid method, of class Route.
     */
    @Test
    public void testGetBdpid() {
        System.out.println("getBdpid");
        Route instance = new Route();
        Boarding expResult = null;
        Boarding result = instance.getBdpid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBdpid method, of class Route.
     */
    @Test
    public void testSetBdpid() {
        System.out.println("setBdpid");
        Boarding bdpid = null;
        Route instance = new Route();
        instance.setBdpid(bdpid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestid method, of class Route.
     */
    @Test
    public void testGetDestid() {
        System.out.println("getDestid");
        Route instance = new Route();
        Dslocation expResult = null;
        Dslocation result = instance.getDestid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestid method, of class Route.
     */
    @Test
    public void testSetDestid() {
        System.out.println("setDestid");
        Dslocation destid = null;
        Route instance = new Route();
        instance.setDestid(destid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDppid method, of class Route.
     */
    @Test
    public void testGetDppid() {
        System.out.println("getDppid");
        Route instance = new Route();
        Boarding expResult = null;
        Boarding result = instance.getDppid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDppid method, of class Route.
     */
    @Test
    public void testSetDppid() {
        System.out.println("setDppid");
        Boarding dppid = null;
        Route instance = new Route();
        instance.setDppid(dppid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSourceid method, of class Route.
     */
    @Test
    public void testGetSourceid() {
        System.out.println("getSourceid");
        Route instance = new Route();
        Dslocation expResult = null;
        Dslocation result = instance.getSourceid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSourceid method, of class Route.
     */
    @Test
    public void testSetSourceid() {
        System.out.println("setSourceid");
        Dslocation sourceid = null;
        Route instance = new Route();
        instance.setSourceid(sourceid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Route.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Route instance = new Route();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
