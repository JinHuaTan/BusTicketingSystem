/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Bustype;
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
public class BustypeDATest {
    
    public BustypeDATest() {
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
     * Test of getAllRecord method, of class BustypeDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        BustypeDA instance = new BustypeDA();
        ArrayList<Bustype> expResult = null;
        ArrayList<Bustype> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class BustypeDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        BustypeDA instance = new BustypeDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class BustypeDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        BustypeDA instance = new BustypeDA();
        Bustype expResult = null;
        Bustype result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class BustypeDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Bustype s = null;
        BustypeDA instance = new BustypeDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class BustypeDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Bustype s = null;
        BustypeDA instance = new BustypeDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class BustypeDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Bustype s = null;
        BustypeDA instance = new BustypeDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class BustypeDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BustypeDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
