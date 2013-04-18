/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Holdings;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedCopy;
import java.util.ArrayList;
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
public class HoldingsMgrTest {
    
    public HoldingsMgrTest() {
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
     * Test of extend method, of class HoldingsMgr.
     */
    @Test
    public void testExtend() throws Exception {
        System.out.println("extend");
        int i = 0;
        HoldingsMgr instance = new HoldingsMgr();
        instance.extend(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelReservation method, of class HoldingsMgr.
     */
    @Test
    public void testCancelReservation() throws Exception {
        System.out.println("cancelReservation");
        int i = 0;
        HoldingsMgr instance = new HoldingsMgr();
        instance.cancelReservation(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class HoldingsMgr.
     */
    @Test
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        HoldingsMgr instance = new HoldingsMgr();
        instance.createItem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentMember method, of class HoldingsMgr.
     */
    @Test
    public void testGetCurrentMember() {
        System.out.println("getCurrentMember");
        HoldingsMgr instance = new HoldingsMgr();
        Member expResult = null;
        Member result = instance.getCurrentMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentMember method, of class HoldingsMgr.
     */
    @Test
    public void testSetCurrentMember() {
        System.out.println("setCurrentMember");
        Member currentMember = null;
        HoldingsMgr instance = new HoldingsMgr();
        instance.setCurrentMember(currentMember);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCopies method, of class HoldingsMgr.
     */
    @Test
    public void testGetReservedCopies() {
        System.out.println("getReservedCopies");
        HoldingsMgr instance = new HoldingsMgr();
        ArrayList expResult = null;
        ArrayList result = instance.getReservedCopies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReservedCopies method, of class HoldingsMgr.
     */
    @Test
    public void testSetReservedCopies() {
        System.out.println("setReservedCopies");
        ArrayList<ReservedCopy> item = null;
        HoldingsMgr instance = new HoldingsMgr();
        instance.setReservedCopies(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentHoldings method, of class HoldingsMgr.
     */
    @Test
    public void testGetCurrentHoldings() {
        System.out.println("getCurrentHoldings");
        HoldingsMgr instance = new HoldingsMgr();
        ArrayList expResult = null;
        ArrayList result = instance.getCurrentHoldings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentHoldings method, of class HoldingsMgr.
     */
    @Test
    public void testSetCurrentHoldings() {
        System.out.println("setCurrentHoldings");
        ArrayList<CurrentHolding> item = null;
        HoldingsMgr instance = new HoldingsMgr();
        instance.setCurrentHoldings(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoOfCurrentHoldings method, of class HoldingsMgr.
     */
    @Test
    public void testGetNoOfCurrentHoldings() {
        System.out.println("getNoOfCurrentHoldings");
        HoldingsMgr instance = new HoldingsMgr();
        int expResult = 0;
        int result = instance.getNoOfCurrentHoldings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoOfReservedCopies method, of class HoldingsMgr.
     */
    @Test
    public void testGetNoOfReservedCopies() {
        System.out.println("getNoOfReservedCopies");
        HoldingsMgr instance = new HoldingsMgr();
        int expResult = 0;
        int result = instance.getNoOfReservedCopies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}