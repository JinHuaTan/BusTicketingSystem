/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Dslocation;
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
 * @author Tan-LT
 */
public class DslocationDATest {
    
    public DslocationDATest() {
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
     * Test of getAllRecord method, of class DslocationDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        DslocationDA instance = new DslocationDA();
        ArrayList<Dslocation> expResult = null;
        ArrayList<Dslocation> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class DslocationDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        DslocationDA instance = new DslocationDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class DslocationDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        DslocationDA instance = new DslocationDA();
        Dslocation expResult = null;
        Dslocation result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class DslocationDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Dslocation s = null;
        DslocationDA instance = new DslocationDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class DslocationDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Dslocation s = null;
        DslocationDA instance = new DslocationDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class DslocationDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Dslocation s = null;
        DslocationDA instance = new DslocationDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DslocationDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DslocationDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
