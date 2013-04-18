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
@Suite.SuiteClasses({BorrowExceptionTest.class, CopyNotReservedExceptionTest.class, TypeMismatchExceptionTest.class, LoginExceptionTest.class, CopyNotFoundExceptionTest.class, CopyReservedExceptionTest.class, DatabaseExceptionTest.class, ItemNotFoundExceptionTest.class, ReserveExceptionTest.class, UserNotFoundExceptionTest.class, UpdateExceptionTest.class, CopyOnLoanExceptionTest.class, IncorrectPasswordExceptionTest.class, InvalidItemTypeExceptionTest.class, SearchExceptionTest.class, InvalidKeywordExceptionTest.class, CopyNotBorrowedExceptionTest.class, ExtendExceptionTest.class, RecordNotFoundExceptionTest.class, NotEligibleToBorrowOrReserveExceptionTest.class, NullResultExceptionTest.class, CopyOverdueExceptionTest.class, CopyBorrowedExceptionTest.class, InvalidUserTypeExceptionTest.class, ItemExistExceptionTest.class})
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