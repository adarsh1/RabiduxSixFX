/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package librarianpage;

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
public class LibrarianFXControllerTest {
    
    public LibrarianFXControllerTest() {
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
     * Test of handleReturnMenuButtonAction method, of class LibrarianFXController.
     */
    @Test
    public void testHandleReturnMenuButtonAction() {
        System.out.println("handleReturnMenuButtonAction");
        ActionEvent event = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.handleReturnMenuButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handlefineMenuButtonAction method, of class LibrarianFXController.
     */
    @Test
    public void testHandlefineMenuButtonAction() {
        System.out.println("handlefineMenuButtonAction");
        ActionEvent event = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.handlefineMenuButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleupdateMenuButtonAction method, of class LibrarianFXController.
     */
    @Test
    public void testHandleupdateMenuButtonAction() {
        System.out.println("handleupdateMenuButtonAction");
        ActionEvent event = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.handleupdateMenuButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logoutbuttonhandler method, of class LibrarianFXController.
     */
    @Test
    public void testLogoutbuttonhandler() {
        System.out.println("logoutbuttonhandler");
        MouseEvent event = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.logoutbuttonhandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LibrarianFXController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observable o = null;
        Object arg = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.update(o, arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleLogoutYesButtonAction method, of class LibrarianFXController.
     */
    @Test
    public void testHandleLogoutYesButtonAction() {
        System.out.println("handleLogoutYesButtonAction");
        ActionEvent event = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.handleLogoutYesButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleLogoutNoButtonAction method, of class LibrarianFXController.
     */
    @Test
    public void testHandleLogoutNoButtonAction() {
        System.out.println("handleLogoutNoButtonAction");
        ActionEvent event = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.handleLogoutNoButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class LibrarianFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class LibrarianFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBasePane method, of class LibrarianFXController.
     */
    @Test
    public void testGetBasePane() {
        System.out.println("getBasePane");
        LibrarianFXController instance = new LibrarianFXController();
        AnchorPane expResult = null;
        AnchorPane result = instance.getBasePane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBasePane method, of class LibrarianFXController.
     */
    @Test
    public void testSetBasePane() {
        System.out.println("setBasePane");
        AnchorPane basePane = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.setBasePane(basePane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHelpPane method, of class LibrarianFXController.
     */
    @Test
    public void testGetHelpPane() {
        System.out.println("getHelpPane");
        LibrarianFXController instance = new LibrarianFXController();
        Pane expResult = null;
        Pane result = instance.getHelpPane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHelpPane method, of class LibrarianFXController.
     */
    @Test
    public void testSetHelpPane() {
        System.out.println("setHelpPane");
        Pane helpPane = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.setHelpPane(helpPane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuPane method, of class LibrarianFXController.
     */
    @Test
    public void testGetMenuPane() {
        System.out.println("getMenuPane");
        LibrarianFXController instance = new LibrarianFXController();
        Pane expResult = null;
        Pane result = instance.getMenuPane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMenuPane method, of class LibrarianFXController.
     */
    @Test
    public void testSetMenuPane() {
        System.out.println("setMenuPane");
        Pane menuPane = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.setMenuPane(menuPane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContentPlaceHolderPane method, of class LibrarianFXController.
     */
    @Test
    public void testGetContentPlaceHolderPane() {
        System.out.println("getContentPlaceHolderPane");
        LibrarianFXController instance = new LibrarianFXController();
        Pane expResult = null;
        Pane result = instance.getContentPlaceHolderPane();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContentPlaceHolderPane method, of class LibrarianFXController.
     */
    @Test
    public void testSetContentPlaceHolderPane() {
        System.out.println("setContentPlaceHolderPane");
        AnchorPane contentPlaceHolderPane = null;
        LibrarianFXController instance = new LibrarianFXController();
        instance.setContentPlaceHolderPane(contentPlaceHolderPane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitPane method, of class LibrarianFXController.
     */
    @Test
    public void testTransitPane_3args() {
        System.out.println("transitPane");
        String resourceURL = "";
        Pane placeHolderPane = null;
        ModelController modelController = null;
        LibrarianFXController instance = new LibrarianFXController();
        FXMLLoader expResult = null;
        FXMLLoader result = instance.transitPane(resourceURL, placeHolderPane, modelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitPane method, of class LibrarianFXController.
     */
    @Test
    public void testTransitPane_String() {
        System.out.println("transitPane");
        String resourceURL = "";
        LibrarianFXController instance = new LibrarianFXController();
        FXMLLoader expResult = null;
        FXMLLoader result = instance.transitPane(resourceURL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class LibrarianFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        LibrarianFXController instance = new LibrarianFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}