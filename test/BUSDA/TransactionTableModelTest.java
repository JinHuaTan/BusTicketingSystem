/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSDA;

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
public class TransactionTableModelTest {
    
    public TransactionTableModelTest() {
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
     * Test of getColumnClass method, of class TransactionTableModel.
     */
    @Test
    public void testGetColumnClass() {
        System.out.println("getColumnClass");
        int column = 0;
        TransactionTableModel instance = new TransactionTableModel();
        Class expResult = null;
        Class result = instance.getColumnClass(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class TransactionTableModel.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        TransactionTableModel instance = new TransactionTableModel();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class TransactionTableModel.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        TransactionTableModel instance = new TransactionTableModel();
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class TransactionTableModel.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        TransactionTableModel instance = new TransactionTableModel();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class TransactionTableModel.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int rowIndex = 0;
        int columnIndex = 0;
        TransactionTableModel instance = new TransactionTableModel();
        Object expResult = null;
        Object result = instance.getValueAt(rowIndex, columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveAll method, of class TransactionTableModel.
     */
    @Test
    public void testRetrieveAll() throws Exception {
        System.out.println("retrieveAll");
        String query = "";
        TransactionTableModel instance = new TransactionTableModel();
        instance.retrieveAll(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByTransID method, of class TransactionTableModel.
     */
    @Test
    public void testRetrieveByTransID() throws Exception {
        System.out.println("retrieveByTransID");
        String transID = "";
        TransactionTableModel instance = new TransactionTableModel();
        instance.retrieveByTransID(transID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByStaffID method, of class TransactionTableModel.
     */
    @Test
    public void testRetrieveByStaffID() throws Exception {
        System.out.println("retrieveByStaffID");
        String staffID = "";
        TransactionTableModel instance = new TransactionTableModel();
        instance.retrieveByStaffID(staffID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveByDate method, of class TransactionTableModel.
     */
    @Test
    public void testRetrieveByDate() throws Exception {
        System.out.println("retrieveByDate");
        String date = "";
        TransactionTableModel instance = new TransactionTableModel();
        instance.retrieveByDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TransactionTableModel.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        TransactionTableModel.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
