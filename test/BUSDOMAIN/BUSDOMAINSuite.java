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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Tan-LT
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BUSDOMAIN.PaymenttypeTest.class, BUSDOMAIN.TransTest.class, BUSDOMAIN.TripTest.class, BUSDOMAIN.RouteTest.class, BUSDOMAIN.DriverlistTest.class, BUSDOMAIN.BustypeTest.class, BUSDOMAIN.StaffTest.class, BUSDOMAIN.SeatnumberTest.class, BUSDOMAIN.BusTest.class, BUSDOMAIN.CancelchangeTest.class, BUSDOMAIN.CounterTest.class, BUSDOMAIN.BoardingTest.class, BUSDOMAIN.TicketTest.class, BUSDOMAIN.JobpositionTest.class, BUSDOMAIN.DslocationTest.class})
public class BUSDOMAINSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
