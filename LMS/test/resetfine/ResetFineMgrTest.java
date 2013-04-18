/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resetfine;

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
public class ResetFineMgrTest {
    
    public ResetFineMgrTest() {
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
     * Test of getCurrentMember method, of class ResetFineMgr.
     */
    @Test
    public void testGetCurrentMember() {
        System.out.println("getCurrentMember");
        ResetFineMgr instance = new ResetFineMgr();
        Member expResult = null;
        Member result = instance.getCurrentMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinedMember method, of class ResetFineMgr.
     */
    @Test
    public void testSetFinedMember() {
        System.out.println("setFinedMember");
        Member finedMember = null;
        ResetFineMgr instance = new ResetFineMgr();
        instance.setFinedMember(finedMember);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMember method, of class ResetFineMgr.
     */
    @Test
    public void testSetMember() throws Exception {
        System.out.println("setMember");
        String userName = "";
        ResetFineMgr instance = new ResetFineMgr();
        instance.setMember(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class ResetFineMgr.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        ResetFineMgr instance = new ResetFineMgr();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserFine method, of class ResetFineMgr.
     */
    @Test
    public void testGetUserFine() {
        System.out.println("getUserFine");
        ResetFineMgr instance = new ResetFineMgr();
        String expResult = "";
        String result = instance.getUserFine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class ResetFineMgr.
     */
    @Test
    public void testReset() throws Exception {
        System.out.println("reset");
        ResetFineMgr instance = new ResetFineMgr();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}