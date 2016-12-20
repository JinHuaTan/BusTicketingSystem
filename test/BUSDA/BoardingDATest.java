/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Boarding;
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
public class BoardingDATest {
    
    public BoardingDATest() {
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
     * Test of getAllRecord method, of class BoardingDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        BoardingDA instance = new BoardingDA();
        ArrayList<Boarding> expResult = null;
        ArrayList<Boarding> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class BoardingDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        BoardingDA instance = new BoardingDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class BoardingDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        BoardingDA instance = new BoardingDA();
        Boarding expResult = null;
        Boarding result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class BoardingDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Boarding s = null;
        BoardingDA instance = new BoardingDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class BoardingDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Boarding s = null;
        BoardingDA instance = new BoardingDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class BoardingDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Boarding s = null;
        BoardingDA instance = new BoardingDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class BoardingDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BoardingDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
