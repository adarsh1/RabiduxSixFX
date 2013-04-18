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
import usermanagement.Member;

/**
 *
 * @author Allen
 */
public class PastTransactionTest {
    
    public PastTransactionTest() {
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
     * Test of getDateBorrowed method, of class PastTransaction.
     */
    @Test
    public void testGetDateBorrowed() {
        System.out.println("getDateBorrowed");
        PastTransaction instance = new PastTransaction();
        Calendar expResult = null;
        Calendar result = instance.getDateBorrowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateBorrowed method, of class PastTransaction.
     */
    @Test
    public void testSetDateBorrowed() {
        System.out.println("setDateBorrowed");
        Calendar dateBorrowed = null;
        PastTransaction instance = new PastTransaction();
        instance.setDateBorrowed(dateBorrowed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateReturned method, of class PastTransaction.
     */
    @Test
    public void testGetDateReturned() {
        System.out.println("getDateReturned");
        PastTransaction instance = new PastTransaction();
        Calendar expResult = null;
        Calendar result = instance.getDateReturned();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateReturned method, of class PastTransaction.
     */
    @Test
    public void testSetDateReturned() {
        System.out.println("setDateReturned");
        Calendar dateReturned = null;
        PastTransaction instance = new PastTransaction();
        instance.setDateReturned(dateReturned);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateToReturn method, of class PastTransaction.
     */
    @Test
    public void testGetDateToReturn() {
        System.out.println("getDateToReturn");
        PastTransaction instance = new PastTransaction();
        Calendar expResult = null;
        Calendar result = instance.getDateToReturn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateToReturn method, of class PastTransaction.
     */
    @Test
    public void testSetDateToReturn() {
        System.out.println("setDateToReturn");
        Calendar dateToReturn = null;
        PastTransaction instance = new PastTransaction();
        instance.setDateToReturn(dateToReturn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFineAmount method, of class PastTransaction.
     */
    @Test
    public void testGetFineAmount() {
        System.out.println("getFineAmount");
        PastTransaction instance = new PastTransaction();
        double expResult = 0.0;
        double result = instance.getFineAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFineAmount method, of class PastTransaction.
     */
    @Test
    public void testSetFineAmount() {
        System.out.println("setFineAmount");
        double fineAmount = 0.0;
        PastTransaction instance = new PastTransaction();
        instance.setFineAmount(fineAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfExtend method, of class PastTransaction.
     */
    @Test
    public void testGetNumOfExtend() {
        System.out.println("getNumOfExtend");
        PastTransaction instance = new PastTransaction();
        int expResult = 0;
        int result = instance.getNumOfExtend();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumOfExtend method, of class PastTransaction.
     */
    @Test
    public void testSetNumOfExtend() {
        System.out.println("setNumOfExtend");
        int numOfExtend = 0;
        PastTransaction instance = new PastTransaction();
        instance.setNumOfExtend(numOfExtend);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopy method, of class PastTransaction.
     */
    @Test
    public void testGetCopy() {
        System.out.println("getCopy");
        PastTransaction instance = new PastTransaction();
        Displayable expResult = null;
        Displayable result = instance.getCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopy method, of class PastTransaction.
     */
    @Test
    public void testSetCopy() {
        System.out.println("setCopy");
        Displayable copy = null;
        PastTransaction instance = new PastTransaction();
        instance.setCopy(copy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMember method, of class PastTransaction.
     */
    @Test
    public void testGetMember() {
        System.out.println("getMember");
        PastTransaction instance = new PastTransaction();
        Member expResult = null;
        Member result = instance.getMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMember method, of class PastTransaction.
     */
    @Test
    public void testSetMember() {
        System.out.println("setMember");
        Member member = null;
        PastTransaction instance = new PastTransaction();
        instance.setMember(member);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoanID method, of class PastTransaction.
     */
    @Test
    public void testGetLoanID() {
        System.out.println("getLoanID");
        PastTransaction instance = new PastTransaction();
        String expResult = "";
        String result = instance.getLoanID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoanID method, of class PastTransaction.
     */
    @Test
    public void testSetLoanID() {
        System.out.println("setLoanID");
        String loanID = "";
        PastTransaction instance = new PastTransaction();
        instance.setLoanID(loanID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}