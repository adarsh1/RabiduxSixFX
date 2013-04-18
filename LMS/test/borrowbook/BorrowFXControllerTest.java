/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowbook;

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
public class BorrowFXControllerTest {
    
    public BorrowFXControllerTest() {
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
     * Test of handleGetDetailsButtonAction method, of class BorrowFXController.
     */
    @Test
    public void testHandleGetDetailsButtonAction() {
        System.out.println("handleGetDetailsButtonAction");
        ActionEvent event = null;
        BorrowFXController instance = new BorrowFXController();
        instance.handleGetDetailsButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleConfirmButtonAction method, of class BorrowFXController.
     */
    @Test
    public void testHandleConfirmButtonAction() {
        System.out.println("handleConfirmButtonAction");
        ActionEvent event = null;
        BorrowFXController instance = new BorrowFXController();
        instance.handleConfirmButtonAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class BorrowFXController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL fxmlFileLocation = null;
        ResourceBundle resources = null;
        BorrowFXController instance = new BorrowFXController();
        instance.initialize(fxmlFileLocation, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialData method, of class BorrowFXController.
     */
    @Test
    public void testSetInitialData() {
        System.out.println("setInitialData");
        ModelController modelController = null;
        BorrowFXController instance = new BorrowFXController();
        instance.setInitialData(modelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class BorrowFXController.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        BorrowFXController instance = new BorrowFXController();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}