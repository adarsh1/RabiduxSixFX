/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package returnbook;

import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class ReturnFXControllerTest {
    
    public ReturnFXControllerTest() {
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
     * Test of handleGetDetailsButtonAction method, of class ReturnFXController.
     */
    @Test
    public void testHandleGetDetailsButtonAction() {
        System.out.println("handleGetDetailsButtonAction");
        ActionEvent event = null;
        ReturnFXController instance = new ReturnFXController();
        instance.handleGetDetailsButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleConfirmButtonAction method, of class ReturnFXController.
     */
    @Test
    public void testHandleConfirmButtonAction() {
        System.out.println("handleConfirmButtonAction");
        ActionEvent event = null;
        ReturnFXController instance = new ReturnFXController();
        instance.handleConfirmButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class ReturnFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        ReturnFXController instance = new ReturnFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class ReturnFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        ReturnFXController instance = new ReturnFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class ReturnFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        ReturnFXController instance = new ReturnFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}