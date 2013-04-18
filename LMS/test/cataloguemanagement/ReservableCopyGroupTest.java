/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.ArrayList;
import java.util.Calendar;
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
public class ReservableCopyGroupTest {
    
    public ReservableCopyGroupTest() {
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
     * Test of getReservableCopyGroup method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetReservableCopyGroup() throws Exception {
        System.out.println("getReservableCopyGroup");
        String itemID = "";
        ReservableCopyGroup expResult = null;
        ReservableCopyGroup result = ReservableCopyGroup.getReservableCopyGroup(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservableCopyGroups method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetReservableCopyGroups() throws Exception {
        System.out.println("getReservableCopyGroups");
        String searchCriteria = "";
        String keyword = "";
        ArrayList expResult = null;
        ArrayList result = ReservableCopyGroup.getReservableCopyGroups(searchCriteria, keyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopiesAvailable method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetCopiesAvailable() {
        System.out.println("getCopiesAvailable");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        int expResult = 0;
        int result = instance.getCopiesAvailable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopiesAvailable method, of class ReservableCopyGroup.
     */
    @Test
    public void testSetCopiesAvailable() {
        System.out.println("setCopiesAvailable");
        int copiesAvailable = 0;
        ReservableCopyGroup instance = new ReservableCopyGroup();
        instance.setCopiesAvailable(copiesAvailable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemID method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetItemID() {
        System.out.println("getItemID");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        String expResult = "";
        String result = instance.getItemID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemID method, of class ReservableCopyGroup.
     */
    @Test
    public void testSetItemID() {
        System.out.println("setItemID");
        String itemID = "";
        ReservableCopyGroup instance = new ReservableCopyGroup();
        instance.setItemID(itemID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopies method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetCopies() {
        System.out.println("getCopies");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        ArrayList expResult = null;
        ArrayList result = instance.getCopies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCopy method, of class ReservableCopyGroup.
     */
    @Test
    public void testAddCopy() {
        System.out.println("addCopy");
        Reservable copy = null;
        ReservableCopyGroup instance = new ReservableCopyGroup();
        instance.addCopy(copy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublishDate method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetPublishDate() {
        System.out.println("getPublishDate");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        Calendar expResult = null;
        Calendar result = instance.getPublishDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetISBN() {
        System.out.println("getISBN");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        String expResult = "";
        String result = instance.getISBN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenre method, of class ReservableCopyGroup.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        ReservableCopyGroup instance = new ReservableCopyGroup();
        String expResult = "";
        String result = instance.getGenre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}