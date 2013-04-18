/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

import cataloguemanagement.CatalogueCopy;
import cataloguemanagement.PastTransaction;
import cataloguemanagement.ReservableCopyGroup;
import cataloguemanagement.ReservedCopy;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import usermanagement.User;

/**
 *
 * @author Allen
 */
public class DataStoreTest {
    
    public DataStoreTest() {
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
     * Test of getCopy method, of class DataStore.
     */
    @Test
    public void testGetCopy() throws Exception {
        System.out.println("getCopy");
        String copyID = "";
        DataStore instance = new DataStore();
        CatalogueCopy expResult = null;
        CatalogueCopy result = instance.getCopy(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByName method, of class DataStore.
     */
    @Test
    public void testGetUserByName() throws Exception {
        System.out.println("getUserByName");
        String username = "";
        DataStore instance = new DataStore();
        User expResult = null;
        User result = instance.getUserByName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class DataStore.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String userID = "";
        DataStore instance = new DataStore();
        User expResult = null;
        User result = instance.getUser(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopyGroup method, of class DataStore.
     */
    @Test
    public void testGetCopyGroup() throws Exception {
        System.out.println("getCopyGroup");
        String itemID = "";
        DataStore instance = new DataStore();
        ReservableCopyGroup expResult = null;
        ReservableCopyGroup result = instance.getCopyGroup(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopyGroups method, of class DataStore.
     */
    @Test
    public void testGetCopyGroups() throws Exception {
        System.out.println("getCopyGroups");
        String searchCriteria = "";
        String keyword = "";
        DataStore instance = new DataStore();
        ArrayList expResult = null;
        ArrayList result = instance.getCopyGroups(searchCriteria, keyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCopyBorrowed method, of class DataStore.
     */
    @Test
    public void testIsCopyBorrowed() throws Exception {
        System.out.println("isCopyBorrowed");
        String copyID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isCopyBorrowed(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCopyOverdue method, of class DataStore.
     */
    @Test
    public void testIsCopyOverdue() throws Exception {
        System.out.println("isCopyOverdue");
        String copyID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isCopyOverdue(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCopyReserved method, of class DataStore.
     */
    @Test
    public void testIsCopyReserved() throws Exception {
        System.out.println("isCopyReserved");
        String copyID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isCopyReserved(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUserSuspended method, of class DataStore.
     */
    @Test
    public void testIsUserSuspended() throws Exception {
        System.out.println("isUserSuspended");
        String userID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isUserSuspended(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidUserPassword method, of class DataStore.
     */
    @Test
    public void testIsValidUserPassword() throws Exception {
        System.out.println("isValidUserPassword");
        String username = "";
        String password = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isValidUserPassword(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidBookID method, of class DataStore.
     */
    @Test
    public void testIsValidBookID() throws Exception {
        System.out.println("isValidBookID");
        String bookID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isValidBookID(bookID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidUserID method, of class DataStore.
     */
    @Test
    public void testIsValidUserID() throws Exception {
        System.out.println("isValidUserID");
        String userID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isValidUserID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidUsername method, of class DataStore.
     */
    @Test
    public void testIsValidUsername() throws Exception {
        System.out.println("isValidUsername");
        String username = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isValidUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidLoanID method, of class DataStore.
     */
    @Test
    public void testIsValidLoanID() throws Exception {
        System.out.println("isValidLoanID");
        String loanID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isValidLoanID(loanID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidCopyID method, of class DataStore.
     */
    @Test
    public void testIsValidCopyID() throws Exception {
        System.out.println("isValidCopyID");
        String copyID = "";
        DataStore instance = new DataStore();
        boolean expResult = false;
        boolean result = instance.isValidCopyID(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfBorrowing method, of class DataStore.
     */
    @Test
    public void testGetNumOfBorrowing() throws Exception {
        System.out.println("getNumOfBorrowing");
        String userID = "";
        DataStore instance = new DataStore();
        int expResult = 0;
        int result = instance.getNumOfBorrowing(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfReserving method, of class DataStore.
     */
    @Test
    public void testGetNumOfReserving() throws Exception {
        System.out.println("getNumOfReserving");
        String userID = "";
        DataStore instance = new DataStore();
        int expResult = 0;
        int result = instance.getNumOfReserving(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecords method, of class DataStore.
     */
    @Test
    public void testGetRecords() throws Exception {
        System.out.println("getRecords");
        String userID = "";
        DataStore instance = new DataStore();
        ArrayList expResult = null;
        ArrayList result = instance.getRecords(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrow method, of class DataStore.
     */
    @Test
    public void testBorrow() throws Exception {
        System.out.println("borrow");
        String copyID = "";
        String userID = "";
        int loanDuration = 0;
        DataStore instance = new DataStore();
        PastTransaction expResult = null;
        PastTransaction result = instance.borrow(copyID, userID, loanDuration);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of extend method, of class DataStore.
     */
    @Test
    public void testExtend() throws Exception {
        System.out.println("extend");
        String copyID = "";
        String loanID = "";
        int extend_time = 0;
        DataStore instance = new DataStore();
        PastTransaction expResult = null;
        PastTransaction result = instance.extend(copyID, loanID, extend_time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reserve method, of class DataStore.
     */
    @Test
    public void testReserve() throws Exception {
        System.out.println("reserve");
        String copyID = "";
        String userID = "";
        DataStore instance = new DataStore();
        instance.reserve(copyID, userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelReservation method, of class DataStore.
     */
    @Test
    public void testCancelReservation() throws Exception {
        System.out.println("cancelReservation");
        String copyID = "";
        String userID = "";
        DataStore instance = new DataStore();
        instance.cancelReservation(copyID, userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnBook method, of class DataStore.
     */
    @Test
    public void testReturnBook() throws Exception {
        System.out.println("returnBook");
        String copyID = "";
        double fine = 0.0;
        DataStore instance = new DataStore();
        instance.returnBook(copyID, fine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCopies method, of class DataStore.
     */
    @Test
    public void testGetReservedCopies() throws Exception {
        System.out.println("getReservedCopies");
        String userID = "";
        DataStore instance = new DataStore();
        ArrayList expResult = null;
        ArrayList result = instance.getReservedCopies(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentHoldings method, of class DataStore.
     */
    @Test
    public void testGetCurrentHoldings() throws Exception {
        System.out.println("getCurrentHoldings");
        String userID = "";
        DataStore instance = new DataStore();
        ArrayList expResult = null;
        ArrayList result = instance.getCurrentHoldings(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCopy method, of class DataStore.
     */
    @Test
    public void testGetReservedCopy() throws Exception {
        System.out.println("getReservedCopy");
        String copyID = "";
        DataStore instance = new DataStore();
        ReservedCopy expResult = null;
        ReservedCopy result = instance.getReservedCopy(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecord method, of class DataStore.
     */
    @Test
    public void testGetRecord() throws Exception {
        System.out.println("getRecord");
        String copyID = "";
        DataStore instance = new DataStore();
        PastTransaction expResult = null;
        PastTransaction result = instance.getRecord(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetFine method, of class DataStore.
     */
    @Test
    public void testResetFine() throws Exception {
        System.out.println("resetFine");
        String userID = "";
        DataStore instance = new DataStore();
        instance.resetFine(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class DataStore.
     */
    @Test
    public void testAddItem() throws Exception {
        System.out.println("addItem");
        HashMap<String, Object> details = null;
        int itemType = 0;
        DataStore instance = new DataStore();
        instance.addItem(details, itemType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateItem method, of class DataStore.
     */
    @Test
    public void testUpdateItem() throws Exception {
        System.out.println("updateItem");
        HashMap<String, Object> details = null;
        int itemType = 0;
        DataStore instance = new DataStore();
        instance.updateItem(details, itemType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemInfo method, of class DataStore.
     */
    @Test
    public void testGetItemInfo() throws Exception {
        System.out.println("getItemInfo");
        String itemID = "";
        int itemType = 0;
        DataStore instance = new DataStore();
        HashMap expResult = null;
        HashMap result = instance.getItemInfo(itemID, itemType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class DataStore.
     */
    @Test
    public void testDeleteItem() throws Exception {
        System.out.println("deleteItem");
        String itemID = "";
        int itemType = 0;
        DataStore instance = new DataStore();
        instance.deleteItem(itemID, itemType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCopy method, of class DataStore.
     */
    @Test
    public void testAddCopy() throws Exception {
        System.out.println("addCopy");
        HashMap<String, Object> details = null;
        DataStore instance = new DataStore();
        instance.addCopy(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCopy method, of class DataStore.
     */
    @Test
    public void testUpdateCopy() throws Exception {
        System.out.println("updateCopy");
        HashMap<String, Object> details = null;
        DataStore instance = new DataStore();
        instance.updateCopy(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopyInfo method, of class DataStore.
     */
    @Test
    public void testGetCopyInfo() throws Exception {
        System.out.println("getCopyInfo");
        String copyID = "";
        DataStore instance = new DataStore();
        HashMap expResult = null;
        HashMap result = instance.getCopyInfo(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCopy method, of class DataStore.
     */
    @Test
    public void testDeleteCopy() throws Exception {
        System.out.println("deleteCopy");
        String copyID = "";
        DataStore instance = new DataStore();
        instance.deleteCopy(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}