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
public class CatalogueCopyTest {
    
    public CatalogueCopyTest() {
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
     * Test of getCatalogueCopy method, of class CatalogueCopy.
     */
    @Test
    public void testGetCatalogueCopy() throws Exception {
        System.out.println("getCatalogueCopy");
        String copyID = "";
        CatalogueCopy expResult = null;
        CatalogueCopy result = CatalogueCopy.getCatalogueCopy(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidCopy method, of class CatalogueCopy.
     */
    @Test
    public void testIsValidCopy() throws Exception {
        System.out.println("isValidCopy");
        String copyID = "";
        Boolean expResult = null;
        Boolean result = CatalogueCopy.isValidCopy(copyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOverdue method, of class CatalogueCopy.
     */
    @Test
    public void testIsOverdue() throws Exception {
        System.out.println("isOverdue");
        CatalogueCopy instance = new CatalogueCopyImpl();
        Boolean expResult = null;
        Boolean result = instance.isOverdue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemID method, of class CatalogueCopy.
     */
    @Test
    public void testGetItemID() {
        System.out.println("getItemID");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getItemID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemID method, of class CatalogueCopy.
     */
    @Test
    public void testSetItemID() {
        System.out.println("setItemID");
        String itemID = "";
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setItemID(itemID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class CatalogueCopy.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class CatalogueCopy.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class CatalogueCopy.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthor method, of class CatalogueCopy.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "";
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class CatalogueCopy.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class CatalogueCopy.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class CatalogueCopy.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        CatalogueCopy instance = new CatalogueCopyImpl();
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class CatalogueCopy.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 0;
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublishDate method, of class CatalogueCopy.
     */
    @Test
    public void testGetPublishDate() {
        System.out.println("getPublishDate");
        CatalogueCopy instance = new CatalogueCopyImpl();
        Calendar expResult = null;
        Calendar result = instance.getPublishDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPublishDate method, of class CatalogueCopy.
     */
    @Test
    public void testSetPublishDate() {
        System.out.println("setPublishDate");
        Calendar date = null;
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setPublishDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndividualCopyID method, of class CatalogueCopy.
     */
    @Test
    public void testGetIndividualCopyID() {
        System.out.println("getIndividualCopyID");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getIndividualCopyID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndividualCopyID method, of class CatalogueCopy.
     */
    @Test
    public void testSetIndividualCopyID() {
        System.out.println("setIndividualCopyID");
        String copyID = "";
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setIndividualCopyID(copyID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class CatalogueCopy.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class CatalogueCopy.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        CatalogueCopy instance = new CatalogueCopyImpl();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN method, of class CatalogueCopy.
     */
    @Test
    public void testGetISBN() {
        System.out.println("getISBN");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getISBN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenre method, of class CatalogueCopy.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        CatalogueCopy instance = new CatalogueCopyImpl();
        String expResult = "";
        String result = instance.getGenre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CatalogueCopyImpl extends CatalogueCopy {
    }
}