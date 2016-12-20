/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Seatnumber;
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
public class SeatnumberDATest {
    
    public SeatnumberDATest() {
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
     * Test of getAllRecord method, of class SeatnumberDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        SeatnumberDA instance = new SeatnumberDA();
        ArrayList<Seatnumber> expResult = null;
        ArrayList<Seatnumber> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class SeatnumberDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        SeatnumberDA instance = new SeatnumberDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class SeatnumberDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        SeatnumberDA instance = new SeatnumberDA();
        Seatnumber expResult = null;
        Seatnumber result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class SeatnumberDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Seatnumber s = null;
        SeatnumberDA instance = new SeatnumberDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class SeatnumberDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Seatnumber s = null;
        SeatnumberDA instance = new SeatnumberDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class SeatnumberDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Seatnumber s = null;
        SeatnumberDA instance = new SeatnumberDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class SeatnumberDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SeatnumberDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
