/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseGUI;

import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
public class BaseFXControllerTest {
    
    public BaseFXControllerTest() {
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
     * Test of displaySuccess method, of class BaseFXController.
     */
    @Test
    public void testDisplaySuccess() {
        System.out.println("displaySuccess");
        String header = "";
        String text = "";
        BaseFXController instance = new BaseFXControllerImpl();
        instance.displaySuccess(header, text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayWarning method, of class BaseFXController.
     */
    @Test
    public void testDisplayWarning() {
        System.out.println("displayWarning");
        String header = "";
        String text = "";
        BaseFXController instance = new BaseFXControllerImpl();
        instance.displayWarning(header, text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessagePaneID method, of class BaseFXController.
     */
    @Test
    public void testGetMessagePaneID() {
        System.out.println("getMessagePaneID");
        BaseFXController instance = new BaseFXControllerImpl();
        String expResult = "";
        String result = instance.getMessagePaneID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleHideMessageButtonAction method, of class BaseFXController.
     */
    @Test
    public void testHandleHideMessageButtonAction() {
        System.out.println("handleHideMessageButtonAction");
        ActionEvent event = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.handleHideMessageButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class BaseFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModelController method, of class BaseFXController.
     */
    @Test
    public void testGetModelController() {
        System.out.println("getModelController");
        BaseFXController instance = new BaseFXControllerImpl();
        ModelController expResult = null;
        ModelController result = instance.getModelController();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModelController method, of class BaseFXController.
     */
    @Test
    public void testSetModelController() {
        System.out.println("setModelController");
        ModelController modelController = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.setModelController(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleOnShowAnimation method, of class BaseFXController.
     */
    @Test
    public void testHandleOnShowAnimation_3args() {
        System.out.println("handleOnShowAnimation");
        Node node = null;
        int millis = 0;
        double offset = 0.0;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.handleOnShowAnimation(node, millis, offset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleOnShowAnimation method, of class BaseFXController.
     */
    @Test
    public void testHandleOnShowAnimation_Node() {
        System.out.println("handleOnShowAnimation");
        Node node = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.handleOnShowAnimation(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleNodeFadeTransition method, of class BaseFXController.
     */
    @Test
    public void testHandleNodeFadeTransition_4args() {
        System.out.println("handleNodeFadeTransition");
        Node node = null;
        int millis = 0;
        double fromValue = 0.0;
        double toValue = 0.0;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.handleNodeFadeTransition(node, millis, fromValue, toValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleNodeFadeTransition method, of class BaseFXController.
     */
    @Test
    public void testHandleNodeFadeTransition_Node_int() {
        System.out.println("handleNodeFadeTransition");
        Node node = null;
        int millis = 0;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.handleNodeFadeTransition(node, millis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleNodeScaleTransition method, of class BaseFXController.
     */
    @Test
    public void testHandleNodeScaleTransition_4args() {
        System.out.println("handleNodeScaleTransition");
        Node node = null;
        int millis = 0;
        double fromValue = 0.0;
        double toValue = 0.0;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.handleNodeScaleTransition(node, millis, fromValue, toValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleNodeScaleTransition method, of class BaseFXController.
     */
    @Test
    public void testHandleNodeScaleTransition_Node_int() {
        System.out.println("handleNodeScaleTransition");
        Node node = null;
        int millis = 0;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.handleNodeScaleTransition(node, millis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitPane method, of class BaseFXController.
     */
    @Test
    public void testTransitPane() {
        System.out.println("transitPane");
        String resourceURL = "";
        Pane placeHolderPane = null;
        ModelController modelController = null;
        BaseFXController instance = new BaseFXControllerImpl();
        FXMLLoader expResult = null;
        FXMLLoader result = instance.transitPane(resourceURL, placeHolderPane, modelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitScene method, of class BaseFXController.
     */
    @Test
    public void testTransitScene_3args() {
        System.out.println("transitScene");
        String resourceURL = "";
        Node node = null;
        ModelController modelController = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.transitScene(resourceURL, node, modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitScene method, of class BaseFXController.
     */
    @Test
    public void testTransitScene_String_Node() {
        System.out.println("transitScene");
        String resourceURL = "";
        Node node = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.transitScene(resourceURL, node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFXML method, of class BaseFXController.
     */
    @Test
    public void testLoadFXML() throws Exception {
        System.out.println("loadFXML");
        FXMLLoader fxmlLoader = null;
        BaseFXController instance = new BaseFXControllerImpl();
        Parent expResult = null;
        Parent result = instance.loadFXML(fxmlLoader);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateFXMLLoader method, of class BaseFXController.
     */
    @Test
    public void testGenerateFXMLLoader() {
        System.out.println("generateFXMLLoader");
        String resourceURL = "";
        BaseFXController instance = new BaseFXControllerImpl();
        FXMLLoader expResult = null;
        FXMLLoader result = instance.generateFXMLLoader(resourceURL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialStage method, of class BaseFXController.
     */
    @Test
    public void testInitialStage() {
        System.out.println("initialStage");
        Stage stage = null;
        Parent root = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.initialStage(stage, root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enableAll method, of class BaseFXController.
     */
    @Test
    public void testEnableAll() {
        System.out.println("enableAll");
        BaseFXController instance = new BaseFXControllerImpl();
        instance.enableAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disableAll method, of class BaseFXController.
     */
    @Test
    public void testDisableAll() {
        System.out.println("disableAll");
        BaseFXController instance = new BaseFXControllerImpl();
        instance.disableAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class BaseFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        BaseFXController instance = new BaseFXControllerImpl();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class BaseFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        BaseFXController instance = new BaseFXControllerImpl();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BaseFXControllerImpl extends BaseFXController {

        public void setInitialData(ModelController modelController) {
        }

        public void playOnShowAnimation() {
        }
    }
}