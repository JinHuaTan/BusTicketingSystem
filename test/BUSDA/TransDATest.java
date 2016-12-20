/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Trans;
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
public class TransDATest {
    
    public TransDATest() {
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
     * Test of getAllRecord method, of class TransDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        TransDA instance = new TransDA();
        ArrayList<Trans> expResult = null;
        ArrayList<Trans> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class TransDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        TransDA instance = new TransDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class TransDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        TransDA instance = new TransDA();
        Trans expResult = null;
        Trans result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class TransDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Trans s = null;
        TransDA instance = new TransDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of voidRecord method, of class TransDA.
     */
    @Test
    public void testVoidRecord() {
        System.out.println("voidRecord");
        String transID = "";
        TransDA instance = new TransDA();
        instance.voidRecord(transID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfterLastCode method, of class TransDA.
     */
    @Test
    public void testGetAfterLastCode() {
        System.out.println("getAfterLastCode");
        TransDA instance = new TransDA();
        String expResult = "";
        String result = instance.getAfterLastCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TransDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TransDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
