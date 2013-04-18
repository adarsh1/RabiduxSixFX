/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
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
public class LoginFXControllerTest {
    
    public LoginFXControllerTest() {
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
     * Test of handleOnKeyTyped method, of class LoginFXController.
     */
    @Test
    public void testHandleOnKeyTyped() {
        System.out.println("handleOnKeyTyped");
        KeyEvent event = null;
        LoginFXController instance = new LoginFXController();
        instance.handleOnKeyTyped(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleOnKeyReleased method, of class LoginFXController.
     */
    @Test
    public void testHandleOnKeyReleased() {
        System.out.println("handleOnKeyReleased");
        KeyEvent event = null;
        LoginFXController instance = new LoginFXController();
        instance.handleOnKeyReleased(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLoginButton method, of class LoginFXController.
     */
    @Test
    public void testUpdateLoginButton() {
        System.out.println("updateLoginButton");
        LoginFXController instance = new LoginFXController();
        instance.updateLoginButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleLoginButtonAction method, of class LoginFXController.
     */
    @Test
    public void testHandleLoginButtonAction() {
        System.out.println("handleLoginButtonAction");
        ActionEvent event = null;
        LoginFXController instance = new LoginFXController();
        instance.handleLoginButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class LoginFXController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Node node = null;
        LoginFXController instance = new LoginFXController();
        instance.login(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class LoginFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        LoginFXController instance = new LoginFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class LoginFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        LoginFXController instance = new LoginFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class LoginFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        LoginFXController instance = new LoginFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}