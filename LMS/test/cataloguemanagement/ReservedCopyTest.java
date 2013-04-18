/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

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
public class ReservedCopyTest {
    
    public ReservedCopyTest() {
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
     * Test of getCopyID method, of class ReservedCopy.
     */
    @Test
    public void testGetCopyID() {
        System.out.println("getCopyID");
        ReservedCopy instance = new ReservedCopy();
        String expResult = "";
        String result = instance.getCopyID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopyID method, of class ReservedCopy.
     */
    @Test
    public void testSetCopyID() {
        System.out.println("setCopyID");
        String copyID = "";
        ReservedCopy instance = new ReservedCopy();
        instance.setCopyID(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateAvailable method, of class ReservedCopy.
     */
    @Test
    public void testGetDateAvailable() {
        System.out.println("getDateAvailable");
        ReservedCopy instance = new ReservedCopy();
        Calendar expResult = null;
        Calendar result = instance.getDateAvailable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateAvailable method, of class ReservedCopy.
     */
    @Test
    public void testSetDateAvailable() {
        System.out.println("setDateAvailable");
        Calendar dateAvailable = null;
        ReservedCopy instance = new ReservedCopy();
        instance.setDateAvailable(dateAvailable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopy method, of class ReservedCopy.
     */
    @Test
    public void testGetCopy() {
        System.out.println("getCopy");
        ReservedCopy instance = new ReservedCopy();
        ReservationCancellable expResult = null;
        ReservationCancellable result = instance.getCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopy method, of class ReservedCopy.
     */
    @Test
    public void testSetCopy() {
        System.out.println("setCopy");
        ReservationCancellable copy = null;
        ReservedCopy instance = new ReservedCopy();
        instance.setCopy(copy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}