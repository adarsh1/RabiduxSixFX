/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.PastTransaction;
import cataloguemanagement.ReservedCopy;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class BorrowRecordAccessibleTest {
    
    public BorrowRecordAccessibleTest() {
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
     * Test of getPastTransactions method, of class BorrowRecordAccessible.
     */
    @Test
    public void testGetPastTransactions() throws Exception {
        System.out.println("getPastTransactions");
        BorrowRecordAccessible instance = new BorrowRecordAccessibleImpl();
        ArrayList expResult = null;
        ArrayList result = instance.getPastTransactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCopies method, of class BorrowRecordAccessible.
     */
    @Test
    public void testGetReservedCopies() throws Exception {
        System.out.println("getReservedCopies");
        BorrowRecordAccessible instance = new BorrowRecordAccessibleImpl();
        ArrayList expResult = null;
        ArrayList result = instance.getReservedCopies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentHoldingItems method, of class BorrowRecordAccessible.
     */
    @Test
    public void testGetCurrentHoldingItems() throws Exception {
        System.out.println("getCurrentHoldingItems");
        BorrowRecordAccessible instance = new BorrowRecordAccessibleImpl();
        ArrayList expResult = null;
        ArrayList result = instance.getCurrentHoldingItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BorrowRecordAccessibleImpl implements BorrowRecordAccessible {

        public ArrayList<PastTransaction> getPastTransactions() throws SQLException, ClassNotFoundException {
            return null;
        }

        public ArrayList<ReservedCopy> getReservedCopies() throws SQLException, ClassNotFoundException {
            return null;
        }

        public ArrayList<CurrentHolding> getCurrentHoldingItems() throws SQLException, ClassNotFoundException {
            return null;
        }
    }
}