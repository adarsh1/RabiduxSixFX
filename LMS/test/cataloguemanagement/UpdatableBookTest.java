/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.Calendar;
import java.util.HashMap;
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
public class UpdatableBookTest {
    
    public UpdatableBookTest() {
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
     * Test of addNewBook method, of class UpdatableBook.
     */
    @Test
    public void testAddNewBook() {
        System.out.println("addNewBook");
        String title = "";
        String author = "";
        String description = "";
        Calendar publishDate = null;
        String ISBN = "";
        String genre = "";
        UpdatableBook instance = new UpdatableBook();
        instance.addNewBook(title, author, description, publishDate, ISBN, genre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBook method, of class UpdatableBook.
     */
    @Test
    public void testUpdateBook() throws Exception {
        System.out.println("updateBook");
        String itemID = "";
        String title = "";
        String author = "";
        String description = "";
        Calendar publishDate = null;
        String ISBN = "";
        String genre = "";
        UpdatableBook instance = new UpdatableBook();
        instance.updateBook(itemID, title, author, description, publishDate, ISBN, genre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookDetails method, of class UpdatableBook.
     */
    @Test
    public void testGetBookDetails() throws Exception {
        System.out.println("getBookDetails");
        String itemID = "";
        UpdatableBook instance = new UpdatableBook();
        HashMap expResult = null;
        HashMap result = instance.getBookDetails(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBook method, of class UpdatableBook.
     */
    @Test
    public void testDeleteBook() throws Exception {
        System.out.println("deleteBook");
        String itemID = "";
        UpdatableBook instance = new UpdatableBook();
        instance.deleteBook(itemID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}