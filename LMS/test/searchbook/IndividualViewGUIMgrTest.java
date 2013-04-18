/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import cataloguemanagement.ReservableCopyGroup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import usermanagement.Faculty;
import usermanagement.Member;
import usermanagement.Student;

/**
 *
 * @author Allen
 */
public class IndividualViewGUIMgrTest {
    
    public IndividualViewGUIMgrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Member fm=new Faculty();
        fm.setUserID("1000000004");
        fm.setUsername("faculty1");
        Member sm=new Student();
        sm.setUserID("1000000005");
        sm.setUsername("student1");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reserve method, of class IndividualViewGUIMgr.
     */
    @Test
    public void testReserve() throws Exception {
        System.out.println("reserveFaculty");
        int i = 0;
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        instance.setCurrentMember(fm);
        instance.reserve(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class IndividualViewGUIMgr.
     */
    @Test
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        String ID = "";
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        instance.createItem(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentMember method, of class IndividualViewGUIMgr.
     */
    @Test
    public void testGetCurrentMember() {
        System.out.println("getCurrentMember");
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        Member expResult = null;
        Member result = instance.getCurrentMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentMember method, of class IndividualViewGUIMgr.
     */
    @Test
    public void testSetCurrentMember() {
        System.out.println("setCurrentMember");
        Member currentMember = null;
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        instance.setCurrentMember(currentMember);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class IndividualViewGUIMgr.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        ReservableCopyGroup expResult = null;
        ReservableCopyGroup result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class IndividualViewGUIMgr.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        ReservableCopyGroup item = null;
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        instance.setItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}