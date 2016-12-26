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
public class StaffIT {
    
    public StaffIT() {
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
     * Test of getStaffid method, of class Staff.
     */
    @Test
    public void testGetStaffid() {
        System.out.println("getStaffid");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getStaffid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaffid method, of class Staff.
     */
    @Test
    public void testSetStaffid() {
        System.out.println("setStaffid");
        String staffid = "";
        Staff instance = new Staff();
        instance.setStaffid(staffid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Staff.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Staff.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Staff instance = new Staff();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Staff.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNric method, of class Staff.
     */
    @Test
    public void testGetNric() {
        System.out.println("getNric");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getNric();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNric method, of class Staff.
     */
    @Test
    public void testSetNric() {
        System.out.println("setNric");
        String nric = "";
        Staff instance = new Staff();
        instance.setNric(nric);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Staff.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Staff instance = new Staff();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaffname method, of class Staff.
     */
    @Test
    public void testGetStaffname() {
        System.out.println("getStaffname");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getStaffname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaffname method, of class Staff.
     */
    @Test
    public void testSetStaffname() {
        System.out.println("setStaffname");
        String staffname = "";
        Staff instance = new Staff();
        instance.setStaffname(staffname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobposition method, of class Staff.
     */
    @Test
    public void testGetJobposition() {
        System.out.println("getJobposition");
        Staff instance = new Staff();
        Jobposition expResult = null;
        Jobposition result = instance.getJobposition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJobposition method, of class Staff.
     */
    @Test
    public void testSetJobposition() {
        System.out.println("setJobposition");
        Jobposition jobposition = null;
        Staff instance = new Staff();
        instance.setJobposition(jobposition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Staff.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Staff instance = new Staff();
        double expResult = 0.0;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class Staff.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 0.0;
        Staff instance = new Staff();
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactno method, of class Staff.
     */
    @Test
    public void testGetContactno() {
        System.out.println("getContactno");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getContactno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContactno method, of class Staff.
     */
    @Test
    public void testSetContactno() {
        System.out.println("setContactno");
        String contactno = "";
        Staff instance = new Staff();
        instance.setContactno(contactno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Staff.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Staff.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Staff instance = new Staff();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Staff.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Staff.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Staff instance = new Staff();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstworkdate method, of class Staff.
     */
    @Test
    public void testGetFirstworkdate() {
        System.out.println("getFirstworkdate");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getFirstworkdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstworkdate method, of class Staff.
     */
    @Test
    public void testSetFirstworkdate() {
        System.out.println("setFirstworkdate");
        String firstworkdate = "";
        Staff instance = new Staff();
        instance.setFirstworkdate(firstworkdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastworkdate method, of class Staff.
     */
    @Test
    public void testGetLastworkdate() {
        System.out.println("getLastworkdate");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getLastworkdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastworkdate method, of class Staff.
     */
    @Test
    public void testSetLastworkdate() {
        System.out.println("setLastworkdate");
        String lastworkdate = "";
        Staff instance = new Staff();
        instance.setLastworkdate(lastworkdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccnumber method, of class Staff.
     */
    @Test
    public void testGetAccnumber() {
        System.out.println("getAccnumber");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getAccnumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccnumber method, of class Staff.
     */
    @Test
    public void testSetAccnumber() {
        System.out.println("setAccnumber");
        String accnumber = "";
        Staff instance = new Staff();
        instance.setAccnumber(accnumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPymtid method, of class Staff.
     */
    @Test
    public void testGetPymtid() {
        System.out.println("getPymtid");
        Staff instance = new Staff();
        Paymenttype expResult = null;
        Paymenttype result = instance.getPymtid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPymtid method, of class Staff.
     */
    @Test
    public void testSetPymtid() {
        System.out.println("setPymtid");
        Paymenttype pymtid = null;
        Staff instance = new Staff();
        instance.setPymtid(pymtid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecurityquestion method, of class Staff.
     */
    @Test
    public void testGetSecurityquestion() {
        System.out.println("getSecurityquestion");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getSecurityquestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecurityquestion method, of class Staff.
     */
    @Test
    public void testSetSecurityquestion() {
        System.out.println("setSecurityquestion");
        String securityquestion = "";
        Staff instance = new Staff();
        instance.setSecurityquestion(securityquestion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecuritypass method, of class Staff.
     */
    @Test
    public void testGetSecuritypass() {
        System.out.println("getSecuritypass");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getSecuritypass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecuritypass method, of class Staff.
     */
    @Test
    public void testSetSecuritypass() {
        System.out.println("setSecuritypass");
        String securitypass = "";
        Staff instance = new Staff();
        instance.setSecuritypass(securitypass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class Staff.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class Staff.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "";
        Staff instance = new Staff();
        instance.setUrl(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Staff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
