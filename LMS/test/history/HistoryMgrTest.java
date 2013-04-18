/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package history;

import cataloguemanagement.PastTransaction;
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
public class HistoryMgrTest {
    
    public HistoryMgrTest() {
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
     * Test of getCurrentMember method, of class HistoryMgr.
     */
    @Test
    public void testGetCurrentMember() {
        System.out.println("getCurrentMember");
        HistoryMgr instance = new HistoryMgr();
        Member expResult = null;
        Member result = instance.getCurrentMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentMember method, of class HistoryMgr.
     */
    @Test
    public void testSetCurrentMember() {
        System.out.println("setCurrentMember");
        Member currentMember = null;
        HistoryMgr instance = new HistoryMgr();
        instance.setCurrentMember(currentMember);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemGroup method, of class HistoryMgr.
     */
    @Test
    public void testGetItemGroup() {
        System.out.println("getItemGroup");
        HistoryMgr instance = new HistoryMgr();
        ArrayList expResult = null;
        ArrayList result = instance.getItemGroup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemGroup method, of class HistoryMgr.
     */
    @Test
    public void testSetItemGroup() {
        System.out.println("setItemGroup");
        ArrayList<PastTransaction> group = null;
        HistoryMgr instance = new HistoryMgr();
        instance.setItemGroup(group);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemSize method, of class HistoryMgr.
     */
    @Test
    public void testGetItemSize() {
        System.out.println("getItemSize");
        HistoryMgr instance = new HistoryMgr();
        int expResult = 0;
        int result = instance.getItemSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHistory method, of class HistoryMgr.
     */
    @Test
    public void testGetHistory() {
        System.out.println("getHistory");
        HistoryMgr instance = new HistoryMgr();
        instance.getHistory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}