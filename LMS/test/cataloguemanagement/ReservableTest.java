/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.sql.SQLException;
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
public class ReservableTest {
    
    public ReservableTest() {
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
     * Test of reserve method, of class Reservable.
     */
    @Test
    public void testReserve() throws Exception {
        System.out.println("reserve");
        String userID = "";
        Reservable instance = new ReservableImpl();
        instance.reserve(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isReserved method, of class Reservable.
     */
    @Test
    public void testIsReserved() throws Exception {
        System.out.println("isReserved");
        Reservable instance = new ReservableImpl();
        boolean expResult = false;
        boolean result = instance.isReserved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBorrowed method, of class Reservable.
     */
    @Test
    public void testIsBorrowed() throws Exception {
        System.out.println("isBorrowed");
        Reservable instance = new ReservableImpl();
        boolean expResult = false;
        boolean result = instance.isBorrowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservedCopy method, of class Reservable.
     */
    @Test
    public void testGetReservedCopy() throws Exception {
        System.out.println("getReservedCopy");
        Reservable instance = new ReservableImpl();
        ReservedCopy expResult = null;
        ReservedCopy result = instance.getReservedCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPastTransaction method, of class Reservable.
     */
    @Test
    public void testGetPastTransaction() throws Exception {
        System.out.println("getPastTransaction");
        Reservable instance = new ReservableImpl();
        PastTransaction expResult = null;
        PastTransaction result = instance.getPastTransaction();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ReservableImpl implements Reservable {

        public void reserve(String userID) throws SQLException, ClassNotFoundException {
        }

        public boolean isReserved() throws SQLException, ClassNotFoundException {
            return false;
        }

        public boolean isBorrowed() throws SQLException, ClassNotFoundException {
            return false;
        }

        public ReservedCopy getReservedCopy() throws SQLException, ClassNotFoundException {
            return null;
        }

        public PastTransaction getPastTransaction() throws SQLException, ClassNotFoundException {
            return null;
        }

        @Override
        public String getItemID() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getIndividualCopyID() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getTitle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getDescription() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getAuthor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Calendar getPublishDate() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getISBN() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getGenre() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getLocation() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}