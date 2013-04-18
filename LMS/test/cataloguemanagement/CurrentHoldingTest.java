/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allen
 */
public class CurrentHoldingTest {
    
    public CurrentHoldingTest() {
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
     * Test of getLoanID method, of class CurrentHolding.
     */
    @Test
    public void testGetLoanID() {
        System.out.println("getLoanID");
        CurrentHolding instance = new CurrentHolding();
        String expResult = "";
        String result = instance.getLoanID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoanID method, of class CurrentHolding.
     */
    @Test
    public void testSetLoanID() {
        System.out.println("setLoanID");
        String loanID = "";
        CurrentHolding instance = new CurrentHolding();
        instance.setLoanID(loanID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateBorrowed method, of class CurrentHolding.
     */
    @Test
    public void testGetDateBorrowed() {
        System.out.println("getDateBorrowed");
        CurrentHolding instance = new CurrentHolding();
        Calendar expResult = null;
        Calendar result = instance.getDateBorrowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateBorrowed method, of class CurrentHolding.
     */
    @Test
    public void testSetDateBorrowed() {
        System.out.println("setDateBorrowed");
        Calendar dateBorrowed = null;
        CurrentHolding instance = new CurrentHolding();
        instance.setDateBorrowed(dateBorrowed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateToReturn method, of class CurrentHolding.
     */
    @Test
    public void testGetDateToReturn() {
        System.out.println("getDateToReturn");
        CurrentHolding instance = new CurrentHolding();
        Calendar expResult = null;
        Calendar result = instance.getDateToReturn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateToReturn method, of class CurrentHolding.
     */
    @Test
    public void testSetDateToReturn() {
        System.out.println("setDateToReturn");
        Calendar dateToReturn = null;
        CurrentHolding instance = new CurrentHolding();
        instance.setDateToReturn(dateToReturn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFine method, of class CurrentHolding.
     */
    @Test
    public void testGetFine() {
        System.out.println("getFine");
        CurrentHolding instance = new CurrentHolding();
        double expResult = 0.0;
        double result = instance.getFine();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFine method, of class CurrentHolding.
     */
    @Test
    public void testSetFine() {
        System.out.println("setFine");
        double fine = 0.0;
        CurrentHolding instance = new CurrentHolding();
        instance.setFine(fine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfExtend method, of class CurrentHolding.
     */
    @Test
    public void testGetNumOfExtend() {
        System.out.println("getNumOfExtend");
        CurrentHolding instance = new CurrentHolding();
        int expResult = 0;
        int result = instance.getNumOfExtend();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumOfExtend method, of class CurrentHolding.
     */
    @Test
    public void testSetNumOfExtend() {
        System.out.println("setNumOfExtend");
        int numOfExtend = 0;
        CurrentHolding instance = new CurrentHolding();
        instance.setNumOfExtend(numOfExtend);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopy method, of class CurrentHolding.
     */
    @Test
    public void testGetCopy() {
        System.out.println("getCopy");
        CurrentHolding instance = new CurrentHolding();
        Extendable expResult = null;
        Extendable result = instance.getCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopy method, of class CurrentHolding.
     */
    @Test
    public void testSetCopy() {
        System.out.println("setCopy");
        Extendable copy = null;
        CurrentHolding instance = new CurrentHolding();
        instance.setCopy(copy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}