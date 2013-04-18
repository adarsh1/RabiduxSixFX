/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatecatalogue;

import exception.CopyNotFoundException;
import exception.ItemNotFoundException;
import factory.SystemConfig;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        SystemConfig instance = SystemConfig.getInstance();
        instance.useMySQLDB();
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
    @Test(expected=NullPointerException.class)
    public void testAddNewBook() throws Exception {
        System.out.println("addNewBook");
        String title = "title";
        String author = "author";
        Calendar publishDate = null;
        String description = "description";
        String ISBN = "ISBN";
        String genre = "genre";
        UpdateMgr instance = new UpdateMgr();
        instance.addNewBook(title, author, publishDate, description, ISBN, genre);
    }

    
    /**
     * Test of updateBook method, of class UpdateMgr.
     */
    @Test(expected=NullPointerException.class)
    public void testUpdateBook1() throws Exception {
        System.out.println("updateBook");
        String itemID = "3000000001";
        String title = "title";
        String author = "author";
        Calendar publishDate = null;
        String description = "description";
        String ISBN = "ISBN";
        String genre = "genre";
        UpdateMgr instance = new UpdateMgr();
        instance.updateBook(itemID, title, author, publishDate, description, ISBN, genre);
    }
    
    @Test(expected=ItemNotFoundException.class)
    public void testUpdateBook2() throws Exception {
        System.out.println("updateBook");
        String itemID = "";
        String title = "title";
        String author = "author";
        Calendar publishDate = new GregorianCalendar(2011,2,2);
        String description = "description";
        String ISBN = "ISBN";
        String genre = "genre";
        UpdateMgr instance = new UpdateMgr();
        instance.updateBook(itemID, title, author, publishDate, description, ISBN, genre);
    }

    /**
     * Test of getItemInfo method, of class UpdateMgr.
     */
    @Test(expected=ItemNotFoundException.class)
    public void testGetItemInfo() throws Exception {
        System.out.println("getItemInfo");
        String itemID = "";
        UpdateMgr instance = new UpdateMgr();
        HashMap expResult = null;
        HashMap result = instance.getItemInfo(itemID);
    }

    /**
     * Test of deleteBook method, of class UpdateMgr.
     */
    @Test(expected=ItemNotFoundException.class)
    public void testDeleteBook() throws Exception {
        System.out.println("deleteBook");
        String itemID = "";
        UpdateMgr instance = new UpdateMgr();
        instance.deleteBook(itemID);
    }

    /**
     * Test of addNewCopy method, of class UpdateMgr.
     */
    @Test(expected=SQLException.class)
    public void testAddNewCopy() throws Exception {
        System.out.println("addNewCopy");
        String itemID = "";
        String location = "a location";
        UpdateMgr instance = new UpdateMgr();
        instance.addNewCopy(itemID, location);
    }

    /**
     * Test of updateCopy method, of class UpdateMgr.
     */
    @Test(expected=CopyNotFoundException.class)
    public void testUpdateCopy() throws Exception {
        System.out.println("updateCopy");
        String copyID = "";
        String location = "a location";
        UpdateMgr instance = new UpdateMgr();
        instance.updateCopy(copyID, location);
    }

    /**
     * Test of getCopyDetails method, of class UpdateMgr.
     */
    @Test(expected=CopyNotFoundException.class)
    public void testGetCopyDetails() throws Exception {
        System.out.println("getCopyDetails");
        String copyID = "";
        UpdateMgr instance = new UpdateMgr();
        HashMap result = instance.getCopyDetails(copyID);
    }

    /**
     * Test of deleteCopy method, of class UpdateMgr.
     */
    @Test(expected=CopyNotFoundException.class)
    public void testDeleteCopy() throws Exception {
        System.out.println("deleteCopy");
        String copyID = "";
        UpdateMgr instance = new UpdateMgr();
        instance.deleteCopy(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}