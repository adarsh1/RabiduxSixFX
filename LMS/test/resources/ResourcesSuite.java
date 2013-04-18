/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Allen
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({resources.xml.XmlSuite.class, resources.JMetro.JMetroSuite.class, resources.css.CssSuite.class, resources.images.ImagesSuite.class})
public class ResourcesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}