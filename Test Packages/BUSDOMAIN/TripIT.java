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
public class TripIT {
    
    public TripIT() {
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
     * Test of getTripid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetTripid() {
        System.out.println("getTripid");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.getTripid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTripid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetTripid() {
        System.out.println("setTripid");
        String tripid = "";
        Trip instance = new Trip();
        instance.setTripid(tripid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartdate method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetDepartdate() {
        System.out.println("getDepartdate");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.getDepartdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartdate method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetDepartdate() {
        System.out.println("setDepartdate");
        String departdate = "";
        Trip instance = new Trip();
        instance.setDepartdate(departdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArrivaldate method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetArrivaldate() {
        System.out.println("getArrivaldate");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.getArrivaldate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArrivaldate method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetArrivaldate() {
        System.out.println("setArrivaldate");
        String arrivaldate = "";
        Trip instance = new Trip();
        instance.setArrivaldate(arrivaldate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFareperticket method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetFareperticket() {
        System.out.println("getFareperticket");
        Trip instance = new Trip();
        double expResult = 0.0;
        double result = instance.getFareperticket();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFareperticket method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetFareperticket() {
        System.out.println("setFareperticket");
        double fareperticket = 0.0;
        Trip instance = new Trip();
        instance.setFareperticket(fareperticket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBusid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetBusid() {
        System.out.println("getBusid");
        Trip instance = new Trip();
        Bus expResult = null;
        Bus result = instance.getBusid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBusid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetBusid() {
        System.out.println("setBusid");
        Bus busid = null;
        Trip instance = new Trip();
        instance.setBusid(busid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRouteid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetRouteid() {
        System.out.println("getRouteid");
        Trip instance = new Trip();
        Route expResult = null;
        Route result = instance.getRouteid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRouteid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetRouteid() {
        System.out.println("setRouteid");
        Route routeid = null;
        Trip instance = new Trip();
        instance.setRouteid(routeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDriverlistid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetDriverlistid() {
        System.out.println("getDriverlistid");
        Trip instance = new Trip();
        Driverlist expResult = null;
        Driverlist result = instance.getDriverlistid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDriverlistid method, of class Trip.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetDriverlistid() {
        System.out.println("setDriverlistid");
        Driverlist driid = null;
        Trip instance = new Trip();
        instance.setDriverlistid(driid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Trip.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testToString() {
        System.out.println("toString");
        Trip instance = new Trip();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
