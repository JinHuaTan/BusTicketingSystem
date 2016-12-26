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
public class BusTest {
    
    public BusTest() {
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
     * Test of getBustypeid method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetBustypeid() {
        System.out.println("getBustypeid");
        Bus instance = new Bus();
        Bustype expResult = null;
        Bustype result = instance.getBustypeid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
     
    }

    /**
     * Test of setBustypeid method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetBustypeid() {
        System.out.println("setBustypeid");
        Bustype bustypeid = null;
        Bus instance = new Bus();
        instance.setBustypeid(bustypeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBusid method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetBusid() {
        System.out.println("getBusid");
        Bus instance = new Bus();
        String expResult = "";
        String result = instance.getBusid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBusid method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetBusid() {
        System.out.println("setBusid");
        String busid = "";
        Bus instance = new Bus();
        instance.setBusid(busid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarplate method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetCarplate() {
        System.out.println("getCarplate");
        Bus instance = new Bus();
        String expResult = "";
        String result = instance.getCarplate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCarplate method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetCarplate() {
        System.out.println("setCarplate");
        String carplate = "";
        Bus instance = new Bus();
        instance.setCarplate(carplate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstdridate method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetFirstdridate() {
        System.out.println("getFirstdridate");
        Bus instance = new Bus();
        String expResult = "";
        String result = instance.getFirstdridate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstdridate method, of class Bus.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetFirstdridate() {
        System.out.println("setFirstdridate");
        String firstdridate = "";
        Bus instance = new Bus();
        instance.setFirstdridate(firstdridate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Bus.
     */
    @Test(expected=NullPointerException.class)
    public void testToString() {
        System.out.println("toString");
        Bus instance = new Bus();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
      
    }
    
}
