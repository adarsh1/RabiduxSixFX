/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import globalcontrol.ModelController;
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
public class LoginMgrTest {
    
    public LoginMgrTest() {
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
     * Test of createUser method, of class LoginMgr.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String username = "";
        String password = "";
        LoginMgr instance = new LoginMgr();
        instance.createUser(username, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModelController method, of class LoginMgr.
     */
    @Test
    public void testGetModelController() {
        System.out.println("getModelController");
        LoginMgr instance = new LoginMgr();
        ModelController expResult = null;
        ModelController result = instance.getModelController();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModelController method, of class LoginMgr.
     */
    @Test
    public void testSetModelController() {
        System.out.println("setModelController");
        ModelController modelController = null;
        LoginMgr instance = new LoginMgr();
        instance.setModelController(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class LoginMgr.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        LoginMgr instance = new LoginMgr();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class LoginMgr.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        LoginMgr instance = new LoginMgr();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}