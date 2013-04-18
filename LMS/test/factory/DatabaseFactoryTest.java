/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import datamanagement.Database;
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
public class DatabaseFactoryTest {
    
    public DatabaseFactoryTest() {
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
     * Test of getInstance method, of class DatabaseFactory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DatabaseFactory expResult = null;
        DatabaseFactory result = DatabaseFactory.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDatabase method, of class DatabaseFactory.
     */
    @Test
    public void testCreateDatabase() {
        System.out.println("createDatabase");
        DatabaseFactory instance = null;
        Database expResult = null;
        Database result = instance.createDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}