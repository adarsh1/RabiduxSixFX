/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

import java.sql.Connection;
import java.sql.ResultSet;
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
public class MySQLDBTest {
    
    public MySQLDBTest() {
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
     * Test of initializeConnection method, of class MySQLDB.
     */
    @Test
    public void testInitializeConnection() throws Exception {
        System.out.println("initializeConnection");
        MySQLDB instance = null;
        instance.initializeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class MySQLDB.
     */
    @Test
    public void testCloseConnection() throws Exception {
        System.out.println("closeConnection");
        MySQLDB instance = null;
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRecord method, of class MySQLDB.
     */
    @Test
    public void testInsertRecord() throws Exception {
        System.out.println("insertRecord");
        Table table = null;
        ArrayList<String> values = null;
        MySQLDB instance = null;
        instance.insertRecord(table, values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class MySQLDB.
     */
    @Test
    public void testUpdateRecord() throws Exception {
        System.out.println("updateRecord");
        Table table = null;
        ArrayList<String> set = null;
        ArrayList<String> where = null;
        MySQLDB instance = null;
        instance.updateRecord(table, set, where);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class MySQLDB.
     */
    @Test
    public void testDeleteRecord() throws Exception {
        System.out.println("deleteRecord");
        Table table = null;
        ArrayList<String> where = null;
        MySQLDB instance = null;
        instance.deleteRecord(table, where);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MySQLDB.
     */
    @Test
    public void testSelectRecord_Table_ArrayList() throws Exception {
        System.out.println("selectRecord");
        Table table = null;
        ArrayList<String> where = null;
        MySQLDB instance = null;
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(table, where);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MySQLDB.
     */
    @Test
    public void testSelectRecord_Table_int() throws Exception {
        System.out.println("selectRecord");
        Table table = null;
        int top = 0;
        MySQLDB instance = null;
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(table, top);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectRecord method, of class MySQLDB.
     */
    @Test
    public void testSelectRecord_3args() throws Exception {
        System.out.println("selectRecord");
        Table table = null;
        ArrayList<String> where = null;
        int top = 0;
        MySQLDB instance = null;
        ResultSet expResult = null;
        ResultSet result = instance.selectRecord(table, where, top);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class MySQLDB.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        MySQLDB instance = null;
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConnection method, of class MySQLDB.
     */
    @Test
    public void testSetConnection() {
        System.out.println("setConnection");
        Connection connection = null;
        MySQLDB instance = null;
        instance.setConnection(connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHost method, of class MySQLDB.
     */
    @Test
    public void testGetHost() {
        System.out.println("getHost");
        MySQLDB instance = null;
        String expResult = "";
        String result = instance.getHost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHost method, of class MySQLDB.
     */
    @Test
    public void testSetHost() {
        System.out.println("setHost");
        String host = "";
        MySQLDB instance = null;
        instance.setHost(host);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatabaseName method, of class MySQLDB.
     */
    @Test
    public void testGetDatabaseName() {
        System.out.println("getDatabaseName");
        MySQLDB instance = null;
        String expResult = "";
        String result = instance.getDatabaseName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatabaseName method, of class MySQLDB.
     */
    @Test
    public void testSetDatabaseName() {
        System.out.println("setDatabaseName");
        String databaseName = "";
        MySQLDB instance = null;
        instance.setDatabaseName(databaseName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class MySQLDB.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        MySQLDB instance = null;
        String expResult = "";
        String result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class MySQLDB.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        MySQLDB instance = null;
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class MySQLDB.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        MySQLDB instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class MySQLDB.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        MySQLDB instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}