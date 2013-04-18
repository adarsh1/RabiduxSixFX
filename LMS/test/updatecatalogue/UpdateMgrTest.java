/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatecatalogue;

import java.util.Calendar;
import java.util.HashMap;
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
public class UpdateMgrTest {
    
    public UpdateMgrTest() {
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
     * Test of addNewBook method, of class UpdateMgr.
     */
    @Test
    public void testAddNewBook() throws Exception {
        System.out.println("addNewBook");
        String title = "";
        String author = "";
        Calendar publishDate = null;
        String description = "";
        String ISBN = "";
        String genre = "";
        UpdateMgr instance = new UpdateMgr();
        instance.addNewBook(title, author, publishDate, description, ISBN, genre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBook method, of class UpdateMgr.
     */
    @Test
    public void testUpdateBook() throws Exception {
        System.out.println("updateBook");
        String itemID = "";
        String title = "";
        String author = "";
        Calendar publishDate = null;
        String description = "";
        String ISBN = "";
        String genre = "";
        UpdateMgr instance = new UpdateMgr();
        instance.updateBook(itemID, title, author, publishDate, description, ISBN, genre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemInfo method, of class UpdateMgr.
     */
    @Test
    public void testGetItemInfo() throws Exception {
        System.out.println("getItemInfo");
        String itemID = "";
        UpdateMgr instance = new UpdateMgr();
        HashMap expResult = null;
        HashMap result = instance.getItemInfo(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBook method, of class UpdateMgr.
     */
    @Test
    public void testDeleteBook() throws Exception {
        System.out.println("deleteBook");
        String itemID = "";
        UpdateMgr instance = new UpdateMgr();
        instance.deleteBook(itemID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewCopy method, of class UpdateMgr.
     */
    @Test
    public void testAddNewCopy() {
        System.out.println("addNewCopy");
        String location = "";
        UpdateMgr instance = new UpdateMgr();
        instance.addNewCopy(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCopy method, of class UpdateMgr.
     */
    @Test
    public void testUpdateCopy() throws Exception {
        System.out.println("updateCopy");
        String copyID = "";
        String location = "";
        UpdateMgr instance = new UpdateMgr();
        instance.updateCopy(copyID, location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopyDetails method, of class UpdateMgr.
     */
    @Test
    public void testGetCopyDetails() throws Exception {
        System.out.println("getCopyDetails");
        String copyID = "";
        UpdateMgr instance = new UpdateMgr();
        HashMap expResult = null;
        HashMap result = instance.getCopyDetails(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCopy method, of class UpdateMgr.
     */
    @Test
    public void testDeleteCopy() throws Exception {
        System.out.println("deleteCopy");
        String copyID = "";
        UpdateMgr instance = new UpdateMgr();
        instance.deleteCopy(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentLibrarian method, of class UpdateMgr.
     */
    @Test
    public void testGetCurrentLibrarian() {
        System.out.println("getCurrentLibrarian");
        UpdateMgr instance = new UpdateMgr();
        Librarian expResult = null;
        Librarian result = instance.getCurrentLibrarian();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentLibrarian method, of class UpdateMgr.
     */
    @Test
    public void testSetCurrentLibrarian() {
        System.out.println("setCurrentLibrarian");
        Librarian currentLibrarian = null;
        UpdateMgr instance = new UpdateMgr();
        instance.setCurrentLibrarian(currentLibrarian);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}