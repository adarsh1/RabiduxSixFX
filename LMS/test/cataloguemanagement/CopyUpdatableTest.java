/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.sql.SQLException;
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
public class CopyUpdatableTest {
    
    public CopyUpdatableTest() {
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
     * Test of addNewCopy method, of class CopyUpdatable.
     */
    @Test
    public void testAddNewCopy() throws Exception {
        System.out.println("addNewCopy");
        HashMap<String, Object> details = null;
        CopyUpdatable instance = new CopyUpdatableImpl();
        instance.addNewCopy(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCopy method, of class CopyUpdatable.
     */
    @Test
    public void testUpdateCopy() throws Exception {
        System.out.println("updateCopy");
        HashMap<String, Object> details = null;
        CopyUpdatable instance = new CopyUpdatableImpl();
        instance.updateCopy(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopy method, of class CopyUpdatable.
     */
    @Test
    public void testGetCopy() throws Exception {
        System.out.println("getCopy");
        String copyID = "";
        CopyUpdatable instance = new CopyUpdatableImpl();
        HashMap expResult = null;
        HashMap result = instance.getCopy(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCopy method, of class CopyUpdatable.
     */
    @Test
    public void testDeleteCopy() throws Exception {
        System.out.println("deleteCopy");
        String copyID = "";
        CopyUpdatable instance = new CopyUpdatableImpl();
        instance.deleteCopy(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CopyUpdatableImpl implements CopyUpdatable {

        public void addNewCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        }

        public void updateCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        }

        public HashMap<String, Object> getCopy(String copyID) throws SQLException, ClassNotFoundException {
            return null;
        }

        public void deleteCopy(String copyID) throws SQLException, ClassNotFoundException {
        }
    }
}