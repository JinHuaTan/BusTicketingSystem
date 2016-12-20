/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

import java.sql.Timestamp;
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
public class TransTest {
    
    public TransTest() {
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
     * Test of getTransid method, of class Trans.
     */
    @Test
    public void testGetTransid() {
        System.out.println("getTransid");
        Trans instance = new Trans();
        String expResult = "";
        String result = instance.getTransid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransid method, of class Trans.
     */
    @Test
    public void testSetTransid() {
        System.out.println("setTransid");
        String transid = "";
        Trans instance = new Trans();
        instance.setTransid(transid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaidstatus method, of class Trans.
     */
    @Test
    public void testGetPaidstatus() {
        System.out.println("getPaidstatus");
        Trans instance = new Trans();
        String expResult = "";
        String result = instance.getPaidstatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaidstatus method, of class Trans.
     */
    @Test
    public void testSetPaidstatus() {
        System.out.println("setPaidstatus");
        String paidstatus = "";
        Trans instance = new Trans();
        instance.setPaidstatus(paidstatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTtlamount method, of class Trans.
     */
    @Test
    public void testGetTtlamount() {
        System.out.println("getTtlamount");
        Trans instance = new Trans();
        Double expResult = null;
        Double result = instance.getTtlamount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTtlamount method, of class Trans.
     */
    @Test
    public void testSetTtlamount() {
        System.out.println("setTtlamount");
        Double ttlamount = null;
        Trans instance = new Trans();
        instance.setTtlamount(ttlamount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecid method, of class Trans.
     */
    @Test
    public void testGetRecid() {
        System.out.println("getRecid");
        Trans instance = new Trans();
        Cancelchange expResult = null;
        Cancelchange result = instance.getRecid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecid method, of class Trans.
     */
    @Test
    public void testSetRecid() {
        System.out.println("setRecid");
        Cancelchange recid = null;
        Trans instance = new Trans();
        instance.setRecid(recid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCounterid method, of class Trans.
     */
    @Test
    public void testGetCounterid() {
        System.out.println("getCounterid");
        Trans instance = new Trans();
        Counter expResult = null;
        Counter result = instance.getCounterid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCounterid method, of class Trans.
     */
    @Test
    public void testSetCounterid() {
        System.out.println("setCounterid");
        Counter counterid = null;
        Trans instance = new Trans();
        instance.setCounterid(counterid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPymtid method, of class Trans.
     */
    @Test
    public void testGetPymtid() {
        System.out.println("getPymtid");
        Trans instance = new Trans();
        Paymenttype expResult = null;
        Paymenttype result = instance.getPymtid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPymtid method, of class Trans.
     */
    @Test
    public void testSetPymtid() {
        System.out.println("setPymtid");
        Paymenttype pymtid = null;
        Trans instance = new Trans();
        instance.setPymtid(pymtid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaffid method, of class Trans.
     */
    @Test
    public void testGetStaffid() {
        System.out.println("getStaffid");
        Trans instance = new Trans();
        Staff expResult = null;
        Staff result = instance.getStaffid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaffid method, of class Trans.
     */
    @Test
    public void testSetStaffid() {
        System.out.println("setStaffid");
        Staff staffid = null;
        Trans instance = new Trans();
        instance.setStaffid(staffid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustname method, of class Trans.
     */
    @Test
    public void testGetCustname() {
        System.out.println("getCustname");
        Trans instance = new Trans();
        String expResult = "";
        String result = instance.getCustname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustname method, of class Trans.
     */
    @Test
    public void testSetCustname() {
        System.out.println("setCustname");
        String custname = "";
        Trans instance = new Trans();
        instance.setCustname(custname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactnum method, of class Trans.
     */
    @Test
    public void testGetContactnum() {
        System.out.println("getContactnum");
        Trans instance = new Trans();
        String expResult = "";
        String result = instance.getContactnum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContactnum method, of class Trans.
     */
    @Test
    public void testSetContactnum() {
        System.out.println("setContactnum");
        String contactnum = "";
        Trans instance = new Trans();
        instance.setContactnum(contactnum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreditcardnumber method, of class Trans.
     */
    @Test
    public void testGetCreditcardnumber() {
        System.out.println("getCreditcardnumber");
        Trans instance = new Trans();
        String expResult = "";
        String result = instance.getCreditcardnumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreditcardnumber method, of class Trans.
     */
    @Test
    public void testSetCreditcardnumber() {
        System.out.println("setCreditcardnumber");
        String creditcardnumber = "";
        Trans instance = new Trans();
        instance.setCreditcardnumber(creditcardnumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscounttype method, of class Trans.
     */
    @Test
    public void testGetDiscounttype() {
        System.out.println("getDiscounttype");
        Trans instance = new Trans();
        String expResult = "";
        String result = instance.getDiscounttype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiscounttype method, of class Trans.
     */
    @Test
    public void testSetDiscounttype() {
        System.out.println("setDiscounttype");
        String discounttype = "";
        Trans instance = new Trans();
        instance.setDiscounttype(discounttype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscountamount method, of class Trans.
     */
    @Test
    public void testGetDiscountamount() {
        System.out.println("getDiscountamount");
        Trans instance = new Trans();
        Double expResult = null;
        Double result = instance.getDiscountamount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiscountamount method, of class Trans.
     */
    @Test
    public void testSetDiscountamount() {
        System.out.println("setDiscountamount");
        Double discountamount = null;
        Trans instance = new Trans();
        instance.setDiscountamount(discountamount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransdate method, of class Trans.
     */
    @Test
    public void testGetTransdate() {
        System.out.println("getTransdate");
        Trans instance = new Trans();
        Timestamp expResult = null;
        Timestamp result = instance.getTransdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransdate method, of class Trans.
     */
    @Test
    public void testSetTransdate() {
        System.out.println("setTransdate");
        Timestamp transdate = null;
        Trans instance = new Trans();
        instance.setTransdate(transdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Trans.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Trans instance = new Trans();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
