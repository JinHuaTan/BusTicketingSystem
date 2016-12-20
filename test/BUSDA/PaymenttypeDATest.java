/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Paymenttype;
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
public class PaymenttypeDATest {
    
    public PaymenttypeDATest() {
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
     * Test of selectRecord method, of class PaymenttypeDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        PaymenttypeDA instance = new PaymenttypeDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class PaymenttypeDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        PaymenttypeDA instance = new PaymenttypeDA();
        Paymenttype expResult = null;
        Paymenttype result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecordbyPayment method, of class PaymenttypeDA.
     */
    @Test
    public void testGetRecordbyPayment() {
        System.out.println("getRecordbyPayment");
        String ID = "";
        PaymenttypeDA instance = new PaymenttypeDA();
        Paymenttype expResult = null;
        Paymenttype result = instance.getRecordbyPayment(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class PaymenttypeDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Paymenttype s = null;
        PaymenttypeDA instance = new PaymenttypeDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class PaymenttypeDA.
     */
    @Test
    public void testUpdateRecord() throws Exception {
        System.out.println("updateRecord");
        Paymenttype s = null;
        PaymenttypeDA instance = new PaymenttypeDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class PaymenttypeDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Paymenttype s = null;
        PaymenttypeDA instance = new PaymenttypeDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PaymenttypeDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PaymenttypeDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
