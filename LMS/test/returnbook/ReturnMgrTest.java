/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package returnbook;

import cataloguemanagement.Returnable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import usermanagement.Librarian;

/**
 *
 * @author Allen
 */
public class ReturnMgrTest {
    
    public ReturnMgrTest() {
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
     * Test of returnbook method, of class ReturnMgr.
     */
    @Test
    public void testReturnbook() throws Exception {
        System.out.println("returnbook");
        ReturnMgr instance = new ReturnMgr();
        boolean expResult = false;
        boolean result = instance.returnbook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class ReturnMgr.
     */
    @Test
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        String copyID = "";
        ReturnMgr instance = new ReturnMgr();
        instance.createItem(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentLibrarian method, of class ReturnMgr.
     */
    @Test
    public void testGetCurrentLibrarian() {
        System.out.println("getCurrentLibrarian");
        ReturnMgr instance = new ReturnMgr();
        Librarian expResult = null;
        Librarian result = instance.getCurrentLibrarian();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentLibrarian method, of class ReturnMgr.
     */
    @Test
    public void testSetCurrentLibrarian() {
        System.out.println("setCurrentLibrarian");
        Librarian currentLibrarian = null;
        ReturnMgr instance = new ReturnMgr();
        instance.setCurrentLibrarian(currentLibrarian);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class ReturnMgr.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        ReturnMgr instance = new ReturnMgr();
        Returnable expResult = null;
        Returnable result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class ReturnMgr.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        Returnable item = null;
        ReturnMgr instance = new ReturnMgr();
        instance.setItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculatefine method, of class ReturnMgr.
     */
    @Test
    public void testCalculatefine() {
        System.out.println("calculatefine");
        ReturnMgr instance = new ReturnMgr();
        boolean expResult = false;
        boolean result = instance.calculatefine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getfine method, of class ReturnMgr.
     */
    @Test
    public void testGetfine() {
        System.out.println("getfine");
        ReturnMgr instance = new ReturnMgr();
        float expResult = 0.0F;
        float result = instance.getfine();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}