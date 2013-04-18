/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import cataloguemanagement.ReservableCopyGroup;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import usermanagement.Member;

/**
 *
 * @author Allen
 */
public class SearchMgrTest {
    
    public SearchMgrTest() {
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
     * Test of setCurrentMember method, of class SearchMgr.
     */
    @Test
    public void testSetCurrentMember() {
        System.out.println("setCurrentMember");
        Member user = null;
        SearchMgr instance = new SearchMgr();
        instance.setCurrentMember(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchByTitle method, of class SearchMgr.
     */
    @Test
    public void testSearchByTitle() throws Exception {
        System.out.println("SearchByTitle");
        String searchstring = "";
        SearchMgr instance = new SearchMgr();
        instance.SearchByTitle(searchstring);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchByAuthor method, of class SearchMgr.
     */
    @Test
    public void testSearchByAuthor() throws Exception {
        System.out.println("SearchByAuthor");
        String searchstring = "";
        SearchMgr instance = new SearchMgr();
        instance.SearchByAuthor(searchstring);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchByISBN method, of class SearchMgr.
     */
    @Test
    public void testSearchByISBN() throws Exception {
        System.out.println("SearchByISBN");
        String searchstring = "";
        SearchMgr instance = new SearchMgr();
        instance.SearchByISBN(searchstring);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchByGenre method, of class SearchMgr.
     */
    @Test
    public void testSearchByGenre() throws Exception {
        System.out.println("SearchByGenre");
        String searchstring = "";
        SearchMgr instance = new SearchMgr();
        instance.SearchByGenre(searchstring);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemGroup method, of class SearchMgr.
     */
    @Test
    public void testGetItemGroup() {
        System.out.println("getItemGroup");
        SearchMgr instance = new SearchMgr();
        ArrayList expResult = null;
        ArrayList result = instance.getItemGroup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemGroup method, of class SearchMgr.
     */
    @Test
    public void testSetItemGroup() {
        System.out.println("setItemGroup");
        ArrayList<ReservableCopyGroup> group = null;
        SearchMgr instance = new SearchMgr();
        instance.setItemGroup(group);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoOfResults method, of class SearchMgr.
     */
    @Test
    public void testGetNoOfResults() {
        System.out.println("getNoOfResults");
        SearchMgr instance = new SearchMgr();
        int expResult = 0;
        int result = instance.getNoOfResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}