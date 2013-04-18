/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
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
public class IndividualViewGUIControllerTest {
    
    public IndividualViewGUIControllerTest() {
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
     * Test of initialize method, of class IndividualViewGUIController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        IndividualViewGUIController instance = new IndividualViewGUIController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class IndividualViewGUIController.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        IndividualViewGUIController instance = new IndividualViewGUIController();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class IndividualViewGUIController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        IndividualViewGUIController instance = new IndividualViewGUIController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class IndividualViewGUIController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        IndividualViewGUIController instance = new IndividualViewGUIController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}