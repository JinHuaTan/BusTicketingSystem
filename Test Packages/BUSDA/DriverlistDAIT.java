/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Driverlist;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class DriverlistDAIT {
    
    public DriverlistDAIT() {
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
     * Test of getAllRecord method, of class DriverlistDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        DriverlistDA instance = new DriverlistDA();
        ArrayList<Driverlist> expResult = null;
        ArrayList<Driverlist> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class DriverlistDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        DriverlistDA instance = new DriverlistDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class DriverlistDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        DriverlistDA instance = new DriverlistDA();
        Driverlist expResult = null;
        Driverlist result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class DriverlistDA.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testAddRecord() {
        System.out.println("addRecord");
        Driverlist s = null;
        DriverlistDA instance = new DriverlistDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class DriverlistDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Driverlist s = null;
        DriverlistDA instance = new DriverlistDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class DriverlistDA.
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Driverlist s = null;
        DriverlistDA instance = new DriverlistDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfterLastCode method, of class DriverlistDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetAfterLastCode() {
        System.out.println("getAfterLastCode");
        DriverlistDA instance = new DriverlistDA();
        String expResult = "";
        String result = instance.getAfterLastCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DriverlistDA.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DriverlistDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
