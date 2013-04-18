/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowbook;

import cataloguemanagement.Borrowable;
import cataloguemanagement.PastTransaction;
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
public class BorrowMgrTest {
    
    public BorrowMgrTest() {
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
     * Test of borrow method, of class BorrowMgr.
     */
    @Test
    public void testBorrow() throws Exception {
        System.out.println("borrow");
        BorrowMgr instance = new BorrowMgr();
        PastTransaction expResult = null;
        PastTransaction result = instance.borrow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class BorrowMgr.
     */
    @Test
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        String copyID = "";
        BorrowMgr instance = new BorrowMgr();
        instance.createItem(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentMember method, of class BorrowMgr.
     */
    @Test
    public void testGetCurrentMember() {
        System.out.println("getCurrentMember");
        BorrowMgr instance = new BorrowMgr();
        Member expResult = null;
        Member result = instance.getCurrentMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentMember method, of class BorrowMgr.
     */
    @Test
    public void testSetCurrentMember() {
        System.out.println("setCurrentMember");
        Member currentMember = null;
        BorrowMgr instance = new BorrowMgr();
        instance.setCurrentMember(currentMember);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class BorrowMgr.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        BorrowMgr instance = new BorrowMgr();
        Borrowable expResult = null;
        Borrowable result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class BorrowMgr.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        Borrowable item = null;
        BorrowMgr instance = new BorrowMgr();
        instance.setItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}