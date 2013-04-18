/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class SearchFXControllerTest {
    
    public SearchFXControllerTest() {
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
     * Test of initialize method, of class SearchFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        SearchFXController instance = new SearchFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class SearchFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        SearchFXController instance = new SearchFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handlesearchbutton method, of class SearchFXController.
     */
    @Test
    public void testHandlesearchbutton() throws Exception {
        System.out.println("handlesearchbutton");
        ActionEvent event = null;
        SearchFXController instance = new SearchFXController();
        instance.handlesearchbutton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class SearchFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        SearchFXController instance = new SearchFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSearchButton method, of class SearchFXController.
     */
    @Test
    public void testUpdateSearchButton() {
        System.out.println("updateSearchButton");
        KeyEvent event = null;
        SearchFXController instance = new SearchFXController();
        instance.updateSearchButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchButtonPress method, of class SearchFXController.
     */
    @Test
    public void testSearchButtonPress() {
        System.out.println("searchButtonPress");
        ActionEvent event = null;
        SearchFXController instance = new SearchFXController();
        instance.searchButtonPress(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}