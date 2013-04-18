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
public class MgrFactoryTest {
    
    public MgrFactoryTest() {
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
     * Test of getInstance method, of class MgrFactory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MgrFactory expResult = null;
        MgrFactory result = MgrFactory.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}