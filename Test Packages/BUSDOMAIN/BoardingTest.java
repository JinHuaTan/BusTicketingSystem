/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDOMAIN;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shaun Lee
 */
public class BoardingTest {
    
    public BoardingTest() {
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
     * Test of getBdpid method, of class Boarding.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetBdpid() {
        System.out.println("getBdpid");
        Boarding instance = new Boarding();
        String expResult = "B1";
        String result = instance.getBdpid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBdpid method, of class Boarding.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetBdpid() {
        System.out.println("setBdpid");
        String bdpid = "";
        Boarding instance = new Boarding();
        instance.setBdpid(bdpid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardpoint method, of class Boarding.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testGetBoardpoint() {
        System.out.println("getBoardpoint");
        Boarding instance = new Boarding();
        String expResult = "";
        String result = instance.getBoardpoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoardpoint method, of class Boarding.
     */
    @Test(expected=java.lang.AssertionError.class)
    public void testSetBoardpoint() {
        System.out.println("setBoardpoint");
        String boardpoint = "";
        Boarding instance = new Boarding();
        instance.setBoardpoint(boardpoint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Boarding.
     */
    @Test(expected=org.junit.ComparisonFailure.class)
    public void testToString() {
        System.out.println("toString");
        Boarding instance = new Boarding();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
