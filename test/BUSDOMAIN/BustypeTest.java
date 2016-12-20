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
public class BustypeTest {
    
    public BustypeTest() {
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
     * Test of getNoofseat method, of class Bustype.
     */
    @Test
    public void testGetNoofseat() {
        System.out.println("getNoofseat");
        Bustype instance = new Bustype();
        int expResult = 0;
        int result = instance.getNoofseat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNoofseat method, of class Bustype.
     */
    @Test
    public void testSetNoofseat() {
        System.out.println("setNoofseat");
        int noofseat = 0;
        Bustype instance = new Bustype();
        instance.setNoofseat(noofseat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBustypeid method, of class Bustype.
     */
    @Test
    public void testGetBustypeid() {
        System.out.println("getBustypeid");
        Bustype instance = new Bustype();
        String expResult = "";
        String result = instance.getBustypeid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBustypeid method, of class Bustype.
     */
    @Test
    public void testSetBustypeid() {
        System.out.println("setBustypeid");
        String bustypeid = "";
        Bustype instance = new Bustype();
        instance.setBustypeid(bustypeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBustype method, of class Bustype.
     */
    @Test
    public void testGetBustype() {
        System.out.println("getBustype");
        Bustype instance = new Bustype();
        String expResult = "";
        String result = instance.getBustype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBustype method, of class Bustype.
     */
    @Test
    public void testSetBustype() {
        System.out.println("setBustype");
        String bustype = "";
        Bustype instance = new Bustype();
        instance.setBustype(bustype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Bustype.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bustype instance = new Bustype();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
