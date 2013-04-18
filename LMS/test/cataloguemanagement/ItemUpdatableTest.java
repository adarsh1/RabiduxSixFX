/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.sql.SQLException;
import java.util.HashMap;
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
public class ItemUpdatableTest {
    
    public ItemUpdatableTest() {
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
     * Test of addNewItem method, of class ItemUpdatable.
     */
    @Test
    public void testAddNewItem() throws Exception {
        System.out.println("addNewItem");
        HashMap<String, Object> details = null;
        ItemUpdatable instance = new ItemUpdatableImpl();
        instance.addNewItem(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateItem method, of class ItemUpdatable.
     */
    @Test
    public void testUpdateItem() throws Exception {
        System.out.println("updateItem");
        HashMap<String, Object> details = null;
        ItemUpdatable instance = new ItemUpdatableImpl();
        instance.updateItem(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class ItemUpdatable.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        String itemID = "";
        ItemUpdatable instance = new ItemUpdatableImpl();
        HashMap expResult = null;
        HashMap result = instance.getItem(itemID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class ItemUpdatable.
     */
    @Test
    public void testDeleteItem() throws Exception {
        System.out.println("deleteItem");
        String itemID = "";
        ItemUpdatable instance = new ItemUpdatableImpl();
        instance.deleteItem(itemID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ItemUpdatableImpl implements ItemUpdatable {

        public void addNewItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        }

        public void updateItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        }

        public HashMap<String, Object> getItem(String itemID) throws SQLException, ClassNotFoundException {
            return null;
        }

        public void deleteItem(String itemID) throws SQLException, ClassNotFoundException {
        }
    }
}