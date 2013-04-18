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
public class UpdatableCopyTest {
    
    public UpdatableCopyTest() {
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
     * Test of addNewCopy method, of class UpdatableCopy.
     */
    @Test
    public void testAddNewCopy() {
        System.out.println("addNewCopy");
        String location = "";
        UpdatableCopy instance = new UpdatableCopy();
        instance.addNewCopy(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCopy method, of class UpdatableCopy.
     */
    @Test
    public void testUpdateCopy() throws Exception {
        System.out.println("updateCopy");
        String copyID = "";
        String location = "";
        UpdatableCopy instance = new UpdatableCopy();
        instance.updateCopy(copyID, location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopyDetails method, of class UpdatableCopy.
     */
    @Test
    public void testGetCopyDetails() throws Exception {
        System.out.println("getCopyDetails");
        String copyID = "";
        UpdatableCopy instance = new UpdatableCopy();
        HashMap expResult = null;
        HashMap result = instance.getCopyDetails(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCopy method, of class UpdatableCopy.
     */
    @Test
    public void testDeleteCopy() throws Exception {
        System.out.println("deleteCopy");
        String copyID = "";
        UpdatableCopy instance = new UpdatableCopy();
        instance.deleteCopy(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}