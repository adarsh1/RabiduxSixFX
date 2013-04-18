/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

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
public class BookTest {
    
    public BookTest() {
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
     * Test of isValidBook method, of class Book.
     */
    @Test
    public void testIsValidBook() throws Exception {
        System.out.println("isValidBook");
        String itemID = "";
        Boolean expResult = null;
        Boolean result = Book.isValidBook(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of borrow method, of class Book.
     */
    @Test
    public void testBorrow() throws Exception {
        System.out.println("borrow");
        String userID = "";
        int loanDuration = 0;
        Book instance = new Book();
        PastTransaction expResult = null;
        PastTransaction result = instance.borrow(userID, loanDuration);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    /**
     * Test of extend method, of class Book.
     */
    @Test
    public void testExtend() throws Exception {
        System.out.println("extend");
        String loanID = "";
        int loanDuration = 0;
        Book instance = new Book();
        instance.extend(loanID, loanDuration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reserve method, of class Book.
     */
    @Test
    public void testReserve() throws Exception {
        System.out.println("reserve");
        String userID = "";
        Book instance = new Book();
        instance.reserve(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelReservation method, of class Book.
     */
    @Test
    public void testCancelReservation() throws Exception {
        System.out.println("cancelReservation");
        String userID = "";
        Book instance = new Book();
        instance.cancelReservation(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCopy method, of class Book.
     */
    @Test
    public void testReturnCopy() throws Exception {
        System.out.println("returnCopy");
        double fine = 0.0;
        Book instance = new Book();
        instance.returnCopy(fine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isReserved method, of class Book.
     */
    @Test
    public void testIsReserved() throws Exception {
        System.out.println("isReserved");
        Book instance = new Book();
        boolean expResult = false;
        boolean result = instance.isReserved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBorrowed method, of class Book.
     */
    @Test
    public void testIsBorrowed() throws Exception {
        System.out.println("isBorrowed");
        Book instance = new Book();
        boolean expResult = false;
        boolean result = instance.isBorrowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCopy method, of class Book.
     */
    @Test
    public void testGetReservedCopy() throws Exception {
        System.out.println("getReservedCopy");
        Book instance = new Book();
        ReservedCopy expResult = null;
        ReservedCopy result = instance.getReservedCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPastTransaction method, of class Book.
     */
    @Test
    public void testGetPastTransaction() throws Exception {
        System.out.println("getPastTransaction");
        Book instance = new Book();
        PastTransaction expResult = null;
        PastTransaction result = instance.getPastTransaction();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewItem method, of class Book.
     */
    @Test
    public void testAddNewItem() throws Exception {
        System.out.println("addNewItem");
        HashMap<String, Object> details = null;
        Book instance = new Book();
        instance.addNewItem(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateItem method, of class Book.
     */
    @Test
    public void testUpdateItem() throws Exception {
        System.out.println("updateItem");
        HashMap<String, Object> details = null;
        Book instance = new Book();
        instance.updateItem(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class Book.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        String itemID = "";
        Book instance = new Book();
        HashMap expResult = null;
        HashMap result = instance.getItem(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class Book.
     */
    @Test
    public void testDeleteItem() throws Exception {
        System.out.println("deleteItem");
        String itemID = "";
        Book instance = new Book();
        instance.deleteItem(itemID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewCopy method, of class Book.
     */
    @Test
    public void testAddNewCopy() throws Exception {
        System.out.println("addNewCopy");
        HashMap<String, Object> details = null;
        Book instance = new Book();
        instance.addNewCopy(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCopy method, of class Book.
     */
    @Test
    public void testUpdateCopy() throws Exception {
        System.out.println("updateCopy");
        HashMap<String, Object> details = null;
        Book instance = new Book();
        instance.updateCopy(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopy method, of class Book.
     */
    @Test
    public void testGetCopy() throws Exception {
        System.out.println("getCopy");
        String copyID = "";
        Book instance = new Book();
        HashMap expResult = null;
        HashMap result = instance.getCopy(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCopy method, of class Book.
     */
    @Test
    public void testDeleteCopy() throws Exception {
        System.out.println("deleteCopy");
        String copyID = "";
        Book instance = new Book();
        instance.deleteCopy(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}