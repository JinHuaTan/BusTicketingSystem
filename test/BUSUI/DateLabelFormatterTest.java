/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSUI;

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
public class DateLabelFormatterTest {
    
    public DateLabelFormatterTest() {
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
     * Test of stringToValue method, of class DateLabelFormatter.
     */
    @Test
    public void testStringToValue() throws Exception {
        System.out.println("stringToValue");
        String text = "";
        DateLabelFormatter instance = new DateLabelFormatter();
        Object expResult = null;
        Object result = instance.stringToValue(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueToString method, of class DateLabelFormatter.
     */
    @Test
    public void testValueToString() throws Exception {
        System.out.println("valueToString");
        Object value = null;
        DateLabelFormatter instance = new DateLabelFormatter();
        String expResult = "";
        String result = instance.valueToString(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
