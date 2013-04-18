/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of initializeConnection method, of class Database.
     */
    @Test
    public void testInitializeConnection() throws Exception {
        System.out.println("initializeConnection");
        Database instance = new DatabaseImpl();
        instance.initializeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class Database.
     */
    @Test
    public void testCloseConnection() throws Exception {
        System.out.println("closeConnection");
        Database instance = new DatabaseImpl();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRecord method, of class Database.
     */
    @Test
    public void testInsertRecord() throws Exception {
        System.out.println("insertRecord");
        Table table = null;
        ArrayList<String> values = null;
        Database instance = new DatabaseImpl();
        instance.insertRecord(table, values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class Database.
     */
    @Test
    public void testUpdateRecord() throws Exception {
        System.out.println("updateRecord");
        Table table = null;
        ArrayList<String> set = null;
        ArrayList<String> where = null;
        Database instance = new DatabaseImpl();
        instance.updateRecord(table, set, where);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class Database.
     */
    @Test
    public void testDeleteRecord() throws Exception {
        System.out.println("deleteRecord");
        Table table = null;
        ArrayList<String> where = null;
        Database instance = new DatabaseImpl();
        instance.deleteRecord(table, where);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class Database.
     */
    @Test
    public void testSelectRecord_Table_ArrayList() throws Exception {
        System.out.println("selectRecord");
        Table table = null;
        ArrayList<String> where = null;
        Database instance = new DatabaseImpl();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(table, where);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class Database.
     */
    @Test
    public void testSelectRecord_Table_int() throws Exception {
        System.out.println("selectRecord");
        Table table = null;
        int top = 0;
        Database instance = new DatabaseImpl();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(table, top);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class Database.
     */
    @Test
    public void testSelectRecord_3args() throws Exception {
        System.out.println("selectRecord");
        Table table = null;
        ArrayList<String> where = null;
        int top = 0;
        Database instance = new DatabaseImpl();
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(table, where, top);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfRows method, of class Database.
     */
    @Test
    public void testGetNumOfRows() throws Exception {
        System.out.println("getNumOfRows");
        ResultSet resultSet = null;
        Database instance = new DatabaseImpl();
        int expResult = 0;
        int result = instance.getNumOfRows(resultSet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewID method, of class Database.
     */
    @Test
    public void testGetNewID() throws Exception {
        System.out.println("getNewID");
        Table table = null;
        Database instance = new DatabaseImpl();
        String expResult = "";
        String result = instance.getNewID(table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DatabaseImpl extends Database {

        public void initializeConnection() throws SQLException, ClassNotFoundException {
        }

        public void closeConnection() throws SQLException {
        }

        public void insertRecord(Table table, ArrayList<String> values) throws SQLException {
        }

        public void updateRecord(Table table, ArrayList<String> set, ArrayList<String> where) throws SQLException {
        }

        public void deleteRecord(Table table, ArrayList<String> where) throws SQLException {
        }

        public ResultSet selectRecord(Table table, ArrayList<String> where) throws SQLException {
            return null;
        }

        public ResultSet selectRecord(Table table, int top) throws SQLException {
            return null;
        }

        public ResultSet selectRecord(Table table, ArrayList<String> where, int top) throws SQLException {
            return null;
        }
    }
}