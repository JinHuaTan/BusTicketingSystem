/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Bustype;
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
public class MaintainBustypeControlTest {
    
    public MaintainBustypeControlTest() {
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
     * Test of selectRecord method, of class MaintainBustypeControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainBustypeControl instance = new MaintainBustypeControl();
        Bustype expResult = null;
        Bustype result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainBustypeControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainBustypeControl instance = new MaintainBustypeControl();
        ArrayList<Bustype> expResult = null;
        ArrayList<Bustype> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainBustypeControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Bustype s = null;
        MaintainBustypeControl instance = new MaintainBustypeControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainBustypeControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Bustype s = null;
        MaintainBustypeControl instance = new MaintainBustypeControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainBustypeControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Bustype s = null;
        MaintainBustypeControl instance = new MaintainBustypeControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
