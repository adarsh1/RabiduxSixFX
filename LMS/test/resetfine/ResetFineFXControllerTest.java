/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resetfine;

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
public class ResetFineFXControllerTest {
    
    public ResetFineFXControllerTest() {
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
     * Test of handleGetDetailsButtonAction method, of class ResetFineFXController.
     */
    @Test
    public void testHandleGetDetailsButtonAction() {
        System.out.println("handleGetDetailsButtonAction");
        ActionEvent event = null;
        ResetFineFXController instance = new ResetFineFXController();
        instance.handleGetDetailsButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleResetButtonAction method, of class ResetFineFXController.
     */
    @Test
    public void testHandleResetButtonAction() {
        System.out.println("handleResetButtonAction");
        ActionEvent event = null;
        ResetFineFXController instance = new ResetFineFXController();
        instance.handleResetButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class ResetFineFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        ResetFineFXController instance = new ResetFineFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class ResetFineFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        ResetFineFXController instance = new ResetFineFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class ResetFineFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        ResetFineFXController instance = new ResetFineFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}