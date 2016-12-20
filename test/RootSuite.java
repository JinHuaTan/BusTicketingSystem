/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Suite.SuiteClasses({BUSUI.BUSUISuite.class, images.ImagesSuite.class, JDatePicker.JDatePickerSuite.class, BUSDOMAIN.BUSDOMAINSuite.class, BUSCONTROL.BUSCONTROLSuite.class, Ticket.TicketSuite.class, Receipt.ReceiptSuite.class, staffImages.StaffImagesSuite.class, BUSDA.BUSDASuite.class, xlImages.XlImagesSuite.class})
public class RootSuite {

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
