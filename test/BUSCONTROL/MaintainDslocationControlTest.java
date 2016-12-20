/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Dslocation;
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
public class MaintainDslocationControlTest {
    
    public MaintainDslocationControlTest() {
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
     * Test of selectRecord method, of class MaintainDslocationControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainDslocationControl instance = new MaintainDslocationControl();
        Dslocation expResult = null;
        Dslocation result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainDslocationControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Dslocation s = null;
        MaintainDslocationControl instance = new MaintainDslocationControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainDslocationControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Dslocation s = null;
        MaintainDslocationControl instance = new MaintainDslocationControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainDslocationControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Dslocation s = null;
        MaintainDslocationControl instance = new MaintainDslocationControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainDslocationControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainDslocationControl instance = new MaintainDslocationControl();
        ArrayList<Dslocation> expResult = null;
        ArrayList<Dslocation> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
