/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import exception.*;
import factory.SystemConfig;
import globalcontrol.ModelController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import usermanagement.Faculty;
import usermanagement.Librarian;
import usermanagement.Student;
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
         SystemConfig instance = SystemConfig.getInstance();
        instance.useMySQLDB();
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
    public void testCreateUserInvalidId() throws Exception {
        System.out.println("createUserInvalidId");
        String username = "usernamedoesnotexist";
        String password = "pass";
        LoginMgr instance = new LoginMgr();
        try{
            instance.createUser(username, password);
            fail("The test case is a prototype.");
        }
       catch(Exception e)
        {
          Assert.assertTrue("Incorrect Exception",e instanceof UserNotFoundException);
        }
    }
    
    @Test
    public void testCreateUserInvalidPass() throws Exception {
        System.out.println("createUserInvalidPassword");
        String username = "asp";
        String password = "not123";
        LoginMgr instance = new LoginMgr();
        try{
            instance.createUser(username, password);
            fail("The test case is a prototype.");
        }
       catch(Exception e)
        {
          Assert.assertTrue("Incorrect Exception",e instanceof IncorrectPasswordException);
        }
    }
    
    
    
    @Test
    public void testCreateProperUser() throws Exception {
        System.out.println("createProperUser");
        String username = "teststudent";
        String password = "testpass";
        LoginMgr instance = new LoginMgr();
        
        //Assume teststudent, testfaculty and testlibrarian are already registered users of the LMS
        // and are of the type Student, Faculty and Librarian respectively
        
        
        instance.createUser(username, password);
        if(instance.getUser() instanceof Student)
            fail("The test case is a prototype.");
        
        username = "testfaculty";
        password = "testpass";
        instance.createUser(username, password);
        if(instance.getUser() instanceof Faculty)
            fail("The test case is a prototype.");
        
        username = "testlibrarian";
        password = "testpass";
        instance.createUser(username, password);
        if(instance.getUser() instanceof Librarian)
            fail("The test case is a prototype.");
        
    }

}