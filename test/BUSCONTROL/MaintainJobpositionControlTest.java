/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSCONTROL;

import BUSDOMAIN.Jobposition;
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
public class MaintainJobpositionControlTest {
    
    public MaintainJobpositionControlTest() {
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
     * Test of selectRecord method, of class MaintainJobpositionControl.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        MaintainJobpositionControl instance = new MaintainJobpositionControl();
        Jobposition expResult = null;
        Jobposition result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecordbyJob method, of class MaintainJobpositionControl.
     */
    @Test
    public void testSelectRecordbyJob() {
        System.out.println("selectRecordbyJob");
        String id = "";
        MaintainJobpositionControl instance = new MaintainJobpositionControl();
        Jobposition expResult = null;
        Jobposition result = instance.selectRecordbyJob(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class MaintainJobpositionControl.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Jobposition s = null;
        MaintainJobpositionControl instance = new MaintainJobpositionControl();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MaintainJobpositionControl.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Jobposition s = null;
        MaintainJobpositionControl instance = new MaintainJobpositionControl();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MaintainJobpositionControl.
     */
    @Test
    public void testUpdateRecord() throws Exception {
        System.out.println("updateRecord");
        Jobposition s = null;
        MaintainJobpositionControl instance = new MaintainJobpositionControl();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
