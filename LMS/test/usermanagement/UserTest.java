/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

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
public class UserTest {
    
    public UserTest() {
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
     * Test of getUser method, of class User.
     */
    @Test
    public void testGetUser_String_String() throws Exception {
        System.out.println("getUser");
        String username = "";
        String password = "";
        User expResult = null;
        User result = User.getUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class User.
     */
    @Test
    public void testGetUser_String() throws Exception {
        System.out.println("getUser");
        String userID = "";
        User expResult = null;
        User result = User.getUser(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSuspended method, of class User.
     */
    @Test
    public void testIsSuspended() throws Exception {
        System.out.println("isSuspended");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isSuspended();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserID method, of class User.
     */
    @Test
    public void testGetUserID() {
        System.out.println("getUserID");
        User instance = new User();
        String expResult = "";
        String result = instance.getUserID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserID method, of class User.
     */
    @Test
    public void testSetUserID() {
        System.out.println("setUserID");
        String userID = "";
        User instance = new User();
        instance.setUserID(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        User instance = new User();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsertype method, of class User.
     */
    @Test
    public void testGetUsertype() {
        System.out.println("getUsertype");
        User instance = new User();
        int expResult = 0;
        int result = instance.getUsertype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsertype method, of class User.
     */
    @Test
    public void testSetUsertype() {
        System.out.println("setUsertype");
        int usertype = 0;
        User instance = new User();
        instance.setUsertype(usertype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}