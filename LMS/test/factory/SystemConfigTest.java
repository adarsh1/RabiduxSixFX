/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

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
public class SystemConfigTest {
    
    public SystemConfigTest() {
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
     * Test of getInstance method, of class SystemConfig.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SystemConfig expResult = null;
        SystemConfig result = SystemConfig.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of useMySQLDB method, of class SystemConfig.
     */
    @Test
    public void testUseMySQLDB() {
        System.out.println("useMySQLDB");
        SystemConfig instance = null;
        instance.useMySQLDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatabaseType method, of class SystemConfig.
     */
    @Test
    public void testGetDatabaseType() {
        System.out.println("getDatabaseType");
        SystemConfig instance = null;
        String expResult = "";
        String result = instance.getDatabaseType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMySQLPasswordHost method, of class SystemConfig.
     */
    @Test
    public void testGetMySQLPasswordHost() {
        System.out.println("getMySQLPasswordHost");
        SystemConfig instance = null;
        String expResult = "";
        String result = instance.getMySQLPasswordHost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMySQLPasswordDatabaseName method, of class SystemConfig.
     */
    @Test
    public void testGetMySQLPasswordDatabaseName() {
        System.out.println("getMySQLPasswordDatabaseName");
        SystemConfig instance = null;
        String expResult = "";
        String result = instance.getMySQLPasswordDatabaseName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMySQLPasswordUser method, of class SystemConfig.
     */
    @Test
    public void testGetMySQLPasswordUser() {
        System.out.println("getMySQLPasswordUser");
        SystemConfig instance = null;
        String expResult = "";
        String result = instance.getMySQLPasswordUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMySQLPasswordPassword method, of class SystemConfig.
     */
    @Test
    public void testGetMySQLPasswordPassword() {
        System.out.println("getMySQLPasswordPassword");
        SystemConfig instance = null;
        String expResult = "";
        String result = instance.getMySQLPasswordPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}