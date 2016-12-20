/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

import BUSDOMAIN.Route;
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
public class RouteDATest {
    
    public RouteDATest() {
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
     * Test of getAllColumnName method, of class RouteDA.
     */
    @Test
    public void testGetAllColumnName() {
        System.out.println("getAllColumnName");
        RouteDA instance = new RouteDA();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllColumnName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecordByColumn method, of class RouteDA.
     */
    @Test
    public void testSearchRecordByColumn() {
        System.out.println("searchRecordByColumn");
        String routeName = "";
        String searchData = "";
        RouteDA instance = new RouteDA();
        ArrayList<Route> expResult = null;
        ArrayList<Route> result = instance.searchRecordByColumn(routeName, searchData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class RouteDA.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        RouteDA instance = new RouteDA();
        ArrayList<Route> expResult = null;
        ArrayList<Route> result = instance.getAllRecord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class RouteDA.
     */
    @Test
    public void testSelectRecord() {
        System.out.println("selectRecord");
        String id = "";
        RouteDA instance = new RouteDA();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class RouteDA.
     */
    @Test
    public void testGetRecord() {
        System.out.println("getRecord");
        String ID = "";
        RouteDA instance = new RouteDA();
        Route expResult = null;
        Route result = instance.getRecord(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecord method, of class RouteDA.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        Route s = null;
        RouteDA instance = new RouteDA();
        instance.addRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class RouteDA.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Route s = null;
        RouteDA instance = new RouteDA();
        instance.updateRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class RouteDA.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Route s = null;
        RouteDA instance = new RouteDA();
        instance.deleteRecord(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayRecord method, of class RouteDA.
     */
    @Test
    public void testDisplayRecord() {
        System.out.println("displayRecord");
        char command = ' ';
        RouteDA instance = new RouteDA();
        String expResult = "";
        String result = instance.displayRecord(command);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class RouteDA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RouteDA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
