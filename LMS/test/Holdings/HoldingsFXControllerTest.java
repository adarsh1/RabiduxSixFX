/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Holdings;

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
public class HoldingsFXControllerTest {
    
    public HoldingsFXControllerTest() {
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
     * Test of initialize method, of class HoldingsFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        HoldingsFXController instance = new HoldingsFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleConfirmYesButtonAction method, of class HoldingsFXController.
     */
    @Test
    public void testHandleConfirmYesButtonAction() {
        System.out.println("handleConfirmYesButtonAction");
        ActionEvent event = null;
        HoldingsFXController instance = new HoldingsFXController();
        instance.handleConfirmYesButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleConfirmNoButtonAction method, of class HoldingsFXController.
     */
    @Test
    public void testHandleConfirmNoButtonAction() {
        System.out.println("handleConfirmNoButtonAction");
        ActionEvent event = null;
        HoldingsFXController instance = new HoldingsFXController();
        instance.handleConfirmNoButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class HoldingsFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        HoldingsFXController instance = new HoldingsFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class HoldingsFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        HoldingsFXController instance = new HoldingsFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}