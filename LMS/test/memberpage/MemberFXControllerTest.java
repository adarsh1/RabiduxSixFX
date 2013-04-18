/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memberpage;

import globalcontrol.ModelController;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
public class MemberFXControllerTest {
    
    public MemberFXControllerTest() {
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
     * Test of handleLogoutYesButtonAction method, of class MemberFXController.
     */
    @Test
    public void testHandleLogoutYesButtonAction() {
        System.out.println("handleLogoutYesButtonAction");
        ActionEvent event = null;
        MemberFXController instance = new MemberFXController();
        instance.handleLogoutYesButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleLogoutNoButtonAction method, of class MemberFXController.
     */
    @Test
    public void testHandleLogoutNoButtonAction() {
        System.out.println("handleLogoutNoButtonAction");
        ActionEvent event = null;
        MemberFXController instance = new MemberFXController();
        instance.handleLogoutNoButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleborrowMenuButtonAction method, of class MemberFXController.
     */
    @Test
    public void testHandleborrowMenuButtonAction() {
        System.out.println("handleborrowMenuButtonAction");
        ActionEvent event = null;
        MemberFXController instance = new MemberFXController();
        instance.handleborrowMenuButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleHistoryMenuButtonAction method, of class MemberFXController.
     */
    @Test
    public void testHandleHistoryMenuButtonAction() {
        System.out.println("handleHistoryMenuButtonAction");
        ActionEvent event = null;
        MemberFXController instance = new MemberFXController();
        instance.handleHistoryMenuButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleSearchMenuButtonAction method, of class MemberFXController.
     */
    @Test
    public void testHandleSearchMenuButtonAction() {
        System.out.println("handleSearchMenuButtonAction");
        ActionEvent event = null;
        MemberFXController instance = new MemberFXController();
        instance.handleSearchMenuButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleHoldingsMenuButtonAction method, of class MemberFXController.
     */
    @Test
    public void testHandleHoldingsMenuButtonAction() {
        System.out.println("handleHoldingsMenuButtonAction");
        ActionEvent event = null;
        MemberFXController instance = new MemberFXController();
        instance.handleHoldingsMenuButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logoutbuttonhandler method, of class MemberFXController.
     */
    @Test
    public void testLogoutbuttonhandler() {
        System.out.println("logoutbuttonhandler");
        MouseEvent event = null;
        MemberFXController instance = new MemberFXController();
        instance.logoutbuttonhandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MemberFXController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observable o = null;
        Object arg = null;
        MemberFXController instance = new MemberFXController();
        instance.update(o, arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class MemberFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        MemberFXController instance = new MemberFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class MemberFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        MemberFXController instance = new MemberFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class MemberFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        MemberFXController instance = new MemberFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBasePane method, of class MemberFXController.
     */
    @Test
    public void testGetBasePane() {
        System.out.println("getBasePane");
        MemberFXController instance = new MemberFXController();
        AnchorPane expResult = null;
        AnchorPane result = instance.getBasePane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBasePane method, of class MemberFXController.
     */
    @Test
    public void testSetBasePane() {
        System.out.println("setBasePane");
        AnchorPane basePane = null;
        MemberFXController instance = new MemberFXController();
        instance.setBasePane(basePane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHelpPane method, of class MemberFXController.
     */
    @Test
    public void testGetHelpPane() {
        System.out.println("getHelpPane");
        MemberFXController instance = new MemberFXController();
        Pane expResult = null;
        Pane result = instance.getHelpPane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHelpPane method, of class MemberFXController.
     */
    @Test
    public void testSetHelpPane() {
        System.out.println("setHelpPane");
        Pane helpPane = null;
        MemberFXController instance = new MemberFXController();
        instance.setHelpPane(helpPane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuPane method, of class MemberFXController.
     */
    @Test
    public void testGetMenuPane() {
        System.out.println("getMenuPane");
        MemberFXController instance = new MemberFXController();
        Pane expResult = null;
        Pane result = instance.getMenuPane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMenuPane method, of class MemberFXController.
     */
    @Test
    public void testSetMenuPane() {
        System.out.println("setMenuPane");
        Pane menuPane = null;
        MemberFXController instance = new MemberFXController();
        instance.setMenuPane(menuPane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContentPlaceHolderPane method, of class MemberFXController.
     */
    @Test
    public void testGetContentPlaceHolderPane() {
        System.out.println("getContentPlaceHolderPane");
        MemberFXController instance = new MemberFXController();
        Pane expResult = null;
        Pane result = instance.getContentPlaceHolderPane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContentPlaceHolderPane method, of class MemberFXController.
     */
    @Test
    public void testSetContentPlaceHolderPane() {
        System.out.println("setContentPlaceHolderPane");
        AnchorPane contentPlaceHolderPane = null;
        MemberFXController instance = new MemberFXController();
        instance.setContentPlaceHolderPane(contentPlaceHolderPane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitPane method, of class MemberFXController.
     */
    @Test
    public void testTransitPane_3args() {
        System.out.println("transitPane");
        String resourceURL = "";
        Pane placeHolderPane = null;
        ModelController modelController = null;
        MemberFXController instance = new MemberFXController();
        FXMLLoader expResult = null;
        FXMLLoader result = instance.transitPane(resourceURL, placeHolderPane, modelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitPane method, of class MemberFXController.
     */
    @Test
    public void testTransitPane_String() {
        System.out.println("transitPane");
        String resourceURL = "";
        MemberFXController instance = new MemberFXController();
        FXMLLoader expResult = null;
        FXMLLoader result = instance.transitPane(resourceURL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}