/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Suite.SuiteClasses({searchbook.SearchbookSuite.class, history.HistorySuite.class, Holdings.HoldingsSuite.class, borrowbook.BorrowbookSuite.class, lms.LmsSuite.class, exception.ExceptionSuite.class, resources.ResourcesSuite.class, returnbook.ReturnbookSuite.class, datamanagement.DatamanagementSuite.class, baseGUI.BaseGUISuite.class, factory.FactorySuite.class, cataloguemanagement.CataloguemanagementSuite.class, usermanagement.UsermanagementSuite.class, resetfine.ResetfineSuite.class, updatecatalogue.UpdatecatalogueSuite.class, memberpage.MemberpageSuite.class, globalcontrol.GlobalcontrolSuite.class, librarianpage.LibrarianpageSuite.class, login.LoginSuite.class})
public class RootSuite {

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