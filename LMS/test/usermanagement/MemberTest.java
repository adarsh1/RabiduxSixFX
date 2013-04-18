/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import java.util.ArrayList;
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
public class MemberTest {
    
    public MemberTest() {
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
     * Test of isEligibleToBorrowOrReserve method, of class Member.
     */
    @Test
    public void testIsEligibleToBorrowOrReserve() throws Exception {
        System.out.println("isEligibleToBorrowOrReserve");
        Member instance = new MemberImpl();
        boolean expResult = false;
        boolean result = instance.isEligibleToBorrowOrReserve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxHolding method, of class Member.
     */
    @Test
    public void testGetMaxHolding() {
        System.out.println("getMaxHolding");
        Member instance = new MemberImpl();
        int expResult = 0;
        int result = instance.getMaxHolding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxHolding method, of class Member.
     */
    @Test
    public void testSetMaxHolding() {
        System.out.println("setMaxHolding");
        int maxHolding = 0;
        Member instance = new MemberImpl();
        instance.setMaxHolding(maxHolding);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFineAmount method, of class Member.
     */
    @Test
    public void testGetFineAmount() {
        System.out.println("getFineAmount");
        Member instance = new MemberImpl();
        double expResult = 0.0;
        double result = instance.getFineAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFineAmount method, of class Member.
     */
    @Test
    public void testSetFineAmount() {
        System.out.println("setFineAmount");
        double fineAmount = 0.0;
        Member instance = new MemberImpl();
        instance.setFineAmount(fineAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetFine method, of class Member.
     */
    @Test
    public void testResetFine() throws Exception {
        System.out.println("resetFine");
        Member instance = new MemberImpl();
        instance.resetFine();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoanDuration method, of class Member.
     */
    @Test
    public void testGetLoanDuration() {
        System.out.println("getLoanDuration");
        Member instance = new MemberImpl();
        int expResult = 0;
        int result = instance.getLoanDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPastTransactions method, of class Member.
     */
    @Test
    public void testGetPastTransactions() throws Exception {
        System.out.println("getPastTransactions");
        Member instance = new MemberImpl();
        ArrayList expResult = null;
        ArrayList result = instance.getPastTransactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCopies method, of class Member.
     */
    @Test
    public void testGetReservedCopies() throws Exception {
        System.out.println("getReservedCopies");
        Member instance = new MemberImpl();
        ArrayList expResult = null;
        ArrayList result = instance.getReservedCopies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentHoldingItems method, of class Member.
     */
    @Test
    public void testGetCurrentHoldingItems() throws Exception {
        System.out.println("getCurrentHoldingItems");
        Member instance = new MemberImpl();
        ArrayList expResult = null;
        ArrayList result = instance.getCurrentHoldingItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MemberImpl extends Member {

        public int getLoanDuration() {
            return 0;
        }
    }
}