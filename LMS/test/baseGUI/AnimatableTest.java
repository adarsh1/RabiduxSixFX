/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseGUI;

import javafx.scene.Node;
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
public class AnimatableTest {
    
    public AnimatableTest() {
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
     * Test of handleOnShowAnimation method, of class Animatable.
     */
    @Test
    public void testHandleOnShowAnimation() {
        System.out.println("handleOnShowAnimation");
        Node node = null;
        int millis = 0;
        double offset = 0.0;
        Animatable instance = new AnimatableImpl();
        instance.handleOnShowAnimation(node, millis, offset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleNodeFadeTransition method, of class Animatable.
     */
    @Test
    public void testHandleNodeFadeTransition_4args() {
        System.out.println("handleNodeFadeTransition");
        Node node = null;
        int millis = 0;
        double fromValue = 0.0;
        double toValue = 0.0;
        Animatable instance = new AnimatableImpl();
        instance.handleNodeFadeTransition(node, millis, fromValue, toValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleNodeFadeTransition method, of class Animatable.
     */
    @Test
    public void testHandleNodeFadeTransition_Node_int() {
        System.out.println("handleNodeFadeTransition");
        Node node = null;
        int millis = 0;
        Animatable instance = new AnimatableImpl();
        instance.handleNodeFadeTransition(node, millis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleNodeScaleTransition method, of class Animatable.
     */
    @Test
    public void testHandleNodeScaleTransition() {
        System.out.println("handleNodeScaleTransition");
        Node node = null;
        int millis = 0;
        double fromValue = 0.0;
        double toValue = 0.0;
        Animatable instance = new AnimatableImpl();
        instance.handleNodeScaleTransition(node, millis, fromValue, toValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playOnShowAnimation method, of class Animatable.
     */
    @Test
    public void testPlayOnShowAnimation() {
        System.out.println("playOnShowAnimation");
        Animatable instance = new AnimatableImpl();
        instance.playOnShowAnimation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AnimatableImpl implements Animatable {

        public void handleOnShowAnimation(Node node, int millis, double offset) {
        }

        public void handleNodeFadeTransition(Node node, int millis, double fromValue, double toValue) {
        }

        public void handleNodeFadeTransition(Node node, int millis) {
        }

        public void handleNodeScaleTransition(Node node, int millis, double fromValue, double toValue) {
        }

        public void playOnShowAnimation() {
        }
    }
}