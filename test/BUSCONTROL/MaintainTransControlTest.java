/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Trans;
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
public class MaintainTransControlTest {
    
    public MaintainTransControlTest() {
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
     * Test of selectRecord method, of class MaintainTransControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainTransControl instance = new MaintainTransControl();
        Trans expResult = null;
        Trans result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainTransControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Trans s = null;
        MaintainTransControl instance = new MaintainTransControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of voidRecord method, of class MaintainTransControl.
     */
    @Test
    public void testVoidRecord() {
        System.out.println("voidRecord");
        String id = "";
        MaintainTransControl instance = new MaintainTransControl();
        instance.voidRecord(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastTransID method, of class MaintainTransControl.
     */
    @Test
    public void testGetLastTransID() {
        System.out.println("getLastTransID");
        MaintainTransControl instance = new MaintainTransControl();
        String expResult = "";
        String result = instance.getLastTransID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
