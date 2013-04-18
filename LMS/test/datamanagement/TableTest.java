/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

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
public class TableTest {
    
    public TableTest() {
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
     * Test of values method, of class Table.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Table[] expResult = null;
        Table[] result = Table.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Table.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Table expResult = null;
        Table result = Table.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableName method, of class Table.
     */
    @Test
    public void testGetTableName() {
        System.out.println("getTableName");
        Table instance = null;
        String expResult = "";
        String result = instance.getTableName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttribute method, of class Table.
     */
    @Test
    public void testGetAttribute() {
        System.out.println("getAttribute");
        String token = "";
        Table instance = null;
        String expResult = "";
        String result = instance.getAttribute(token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}