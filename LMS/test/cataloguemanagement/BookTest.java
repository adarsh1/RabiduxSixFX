/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import factory.SystemConfig;
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
     * Test of isValidBook method, of class Book.
     */
    @Test
    public void testIsValidBook1() throws Exception {
        System.out.println("isValidBook");
        String itemID = "3000000002";
        Boolean expResult = true;
        Boolean result = Book.isValidBook(itemID);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidBook2() throws Exception {
        System.out.println("isValidBook");
        String itemID = "invalid";
        Boolean expResult = false;
        Boolean result = Book.isValidBook(itemID);
        assertEquals(expResult, result);
    }


    /**
     * Test of isReserved method, of class Book.
     */
    @Test
    public void testIsReserved1() throws Exception {
        System.out.println("isReserved");
        Book instance =(Book) CatalogueCopy.getCatalogueCopy("2000000004");
        boolean expResult = true;
        boolean result = instance.isReserved();
        assertEquals(expResult, result);
    }
    @Test
    public void testIsReserved2() throws Exception {
        System.out.println("isReserved");
        Book instance =(Book) CatalogueCopy.getCatalogueCopy("2000000005");
        boolean expResult = false;
        boolean result = instance.isReserved();
        assertEquals(expResult, result);
    }

    /**
     * Test of isBorrowed method, of class Book.
     */
    @Test
    public void testIsBorrowed1() throws Exception {
        System.out.println("isBorrowed");
        Book instance = (Book) CatalogueCopy.getCatalogueCopy("2000000005");
        boolean expResult = false;
        boolean result = instance.isBorrowed();
        assertEquals(expResult, result);
    }
    @Test
    public void testIsBorrowed2() throws Exception {
        System.out.println("isBorrowed");
        Book instance = (Book) CatalogueCopy.getCatalogueCopy("2000000003");
        boolean expResult = true;
        boolean result = instance.isBorrowed();
        assertEquals(expResult, result);
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