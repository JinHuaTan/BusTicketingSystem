/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Paymenttype;
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
public class MaintainPaymenttypeControlTest {
    
    public MaintainPaymenttypeControlTest() {
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
     * Test of selectRecord method, of class MaintainPaymenttypeControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainPaymenttypeControl instance = new MaintainPaymenttypeControl();
        Paymenttype expResult = null;
        Paymenttype result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecordbyPayment method, of class MaintainPaymenttypeControl.
     */
    @Test
    public void testSelectRecordbyPayment() {
        System.out.println("selectRecordbyPayment");
        String id = "";
        MaintainPaymenttypeControl instance = new MaintainPaymenttypeControl();
        Paymenttype expResult = null;
        Paymenttype result = instance.selectRecordbyPayment(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainPaymenttypeControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Paymenttype s = null;
        MaintainPaymenttypeControl instance = new MaintainPaymenttypeControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainPaymenttypeControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Paymenttype s = null;
        MaintainPaymenttypeControl instance = new MaintainPaymenttypeControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainPaymenttypeControl.
     */
    @Test
    public void testUpdateRecord() throws Exception {
        System.out.println("updateRecord");
        Paymenttype s = null;
        MaintainPaymenttypeControl instance = new MaintainPaymenttypeControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
