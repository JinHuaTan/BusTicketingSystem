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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Tan-LT
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BUSDA.StaffDATest.class, BUSDA.TransactionTableModelTest.class, BUSDA.TransDATest.class, BUSDA.JobpositionDATest.class, BUSDA.RouteDATest.class, BUSDA.AnnualReportPopularPlacesTest.class, BUSDA.TopPlacesTableModelTest.class, BUSDA.BustypeDATest.class, BUSDA.CounterDATest.class, BUSDA.BoardingDATest.class, BUSDA.DslocationDATest.class, BUSDA.TripDATest.class, BUSDA.AnnualSalesReportTableModelTest.class, BUSDA.TicketDATest.class, BUSDA.BusDATest.class, BUSDA.PaymenttypeDATest.class, BUSDA.DriverlistDATest.class, BUSDA.SeatnumberDATest.class})
public class BUSDASuite {

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
