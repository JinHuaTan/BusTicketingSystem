/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Jobposition;
import java.sql.ResultSet;
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
public class JobpositionDATest {
    
    public JobpositionDATest() {
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
     * Test of selectRecord method, of class JobpositionDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        JobpositionDA instance = new JobpositionDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class JobpositionDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        JobpositionDA instance = new JobpositionDA();
        Jobposition expResult = null;
        Jobposition result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecordbyJob method, of class JobpositionDA.
     */
    @Test
    public void testGetRecordbyJob() {
        System.out.println("getRecordbyJob");
        String ID = "";
        JobpositionDA instance = new JobpositionDA();
        Jobposition expResult = null;
        Jobposition result = instance.getRecordbyJob(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class JobpositionDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Jobposition s = null;
        JobpositionDA instance = new JobpositionDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class JobpositionDA.
     */
    @Test
    public void testUpdateRecord() throws Exception {
        System.out.println("updateRecord");
        Jobposition s = null;
        JobpositionDA instance = new JobpositionDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class JobpositionDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Jobposition s = null;
        JobpositionDA instance = new JobpositionDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class JobpositionDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        JobpositionDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
