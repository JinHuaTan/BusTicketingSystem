/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Boarding;
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
public class MaintainBoardingControlTest {
    
    public MaintainBoardingControlTest() {
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
     * Test of selectRecord method, of class MaintainBoardingControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainBoardingControl instance = new MaintainBoardingControl();
        Boarding expResult = null;
        Boarding result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainBoardingControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Boarding s = null;
        MaintainBoardingControl instance = new MaintainBoardingControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainBoardingControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Boarding s = null;
        MaintainBoardingControl instance = new MaintainBoardingControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainBoardingControl.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Boarding s = null;
        MaintainBoardingControl instance = new MaintainBoardingControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class MaintainBoardingControl.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        MaintainBoardingControl instance = new MaintainBoardingControl();
        ArrayList<Boarding> expResult = null;
        ArrayList<Boarding> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
