/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

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
public class TypeMismatchExceptionTest {
    
    public TypeMismatchExceptionTest() {
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
     * Test of getMessage method, of class TypeMismatchException.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        TypeMismatchException instance = new TypeMismatchException();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}