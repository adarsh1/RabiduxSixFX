/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

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
@Suite.SuiteClasses({exception.BorrowExceptionTest.class, exception.InvalidKeywordExceptionTest.class, exception.CopyNotBorrowedExceptionTest.class, exception.CopyNotReservedExceptionTest.class, exception.TypeMismatchExceptionTest.class, exception.ExtendExceptionTest.class, exception.LoginExceptionTest.class, exception.RecordNotFoundExceptionTest.class, exception.CopyNotFoundExceptionTest.class, exception.CopyReservedExceptionTest.class, exception.DatabaseExceptionTest.class, exception.NotEligibleToBorrowOrReserveExceptionTest.class, exception.NullResultExceptionTest.class, exception.ItemNotFoundExceptionTest.class, exception.CopyOverdueExceptionTest.class, exception.CopyBorrowedExceptionTest.class, exception.ReserveExceptionTest.class, exception.UserNotFoundExceptionTest.class, exception.CopyOnLoanExceptionTest.class, exception.IncorrectPasswordExceptionTest.class, exception.InvalidUserTypeExceptionTest.class, exception.SearchExceptionTest.class, exception.ItemExistExceptionTest.class})
public class ExceptionSuite {

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