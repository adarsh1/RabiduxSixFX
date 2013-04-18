/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.Calendar;
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
public class DisplayableTest {
    
    public DisplayableTest() {
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
     * Test of getItemID method, of class Displayable.
     */
    @Test
    public void testGetItemID() {
        System.out.println("getItemID");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getItemID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndividualCopyID method, of class Displayable.
     */
    @Test
    public void testGetIndividualCopyID() {
        System.out.println("getIndividualCopyID");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getIndividualCopyID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Displayable.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Displayable.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class Displayable.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublishDate method, of class Displayable.
     */
    @Test
    public void testGetPublishDate() {
        System.out.println("getPublishDate");
        Displayable instance = new DisplayableImpl();
        Calendar expResult = null;
        Calendar result = instance.getPublishDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN method, of class Displayable.
     */
    @Test
    public void testGetISBN() {
        System.out.println("getISBN");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getISBN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenre method, of class Displayable.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getGenre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Displayable.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Displayable instance = new DisplayableImpl();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DisplayableImpl implements Displayable {

        public String getItemID() {
            return "";
        }

        public String getIndividualCopyID() {
            return "";
        }

        public String getTitle() {
            return "";
        }

        public String getDescription() {
            return "";
        }

        public String getAuthor() {
            return "";
        }

        public Calendar getPublishDate() {
            return null;
        }

        public String getISBN() {
            return "";
        }

        public String getGenre() {
            return "";
        }

        public String getLocation() {
            return "";
        }
    }
}