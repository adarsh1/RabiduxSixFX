/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globalcontrol;

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
public class ModelControllerTest {
    
    public ModelControllerTest() {
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
     * Test of getUser method, of class ModelController.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ModelController instance = new ModelController();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class ModelController.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        ModelController instance = new ModelController();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}