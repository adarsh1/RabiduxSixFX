/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
public class testBorrowTest {
    
    public testBorrowTest() {
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
     * Test of start method, of class testBorrow.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Stage primaryStage = null;
        testBorrow instance = new testBorrow();
        instance.start(primaryStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class testBorrow.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        testBorrow.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}