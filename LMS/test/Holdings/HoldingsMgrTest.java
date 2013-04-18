/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Holdings;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedCopy;
import exception.CopyReservedException;
import exception.NotEligibleToBorrowOrReserveException;
import exception.UserSuspendedException;
import factory.SystemConfig;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import usermanagement.Member;
import usermanagement.User;

/**
 *
 * @author Allen
 */
public class HoldingsMgrTest {
    
    public HoldingsMgrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SystemConfig instance = SystemConfig.getInstance();
        instance.useMySQLDB();
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
     * Test of extend method, of class HoldingsMgr.
     */
    @Test
    public void testExtendAboveLimit() throws Exception {
        System.out.println("extendabovelimit");
        int i = 0;
        HoldingsMgr instance = new HoldingsMgr();
        
        //Assume that tester is a member who has borrowed a single book and has extended it thrice.
        
        Member tester = (Member) User.getUser("1111111110");
        instance.setCurrentMember(tester);
        instance.setCurrentHoldings(tester.getCurrentHoldingItems());
        try{
            instance.extend(i);
            fail("The test case is a prototype.");
        }
        catch(Exception e)
        {
          Assert.assertTrue("Incorrect Exception",e instanceof NotEligibleToBorrowOrReserveException);
        }
    }

    
   
    /**
     * Test of extend method, of class HoldingsMgr.
     */
    @Test
    public void testExtendBelowLimit() throws Exception {
        System.out.println("extendbelowlimit");
        int i = 0;
        HoldingsMgr instance = new HoldingsMgr();
        
        //Assume that tester is a member who has borrowed a single book and has extended it thrice.
        
        Member tester = (Member) User.getUser("1111111112");
        instance.setCurrentMember(tester);
        instance.setCurrentHoldings(tester.getCurrentHoldingItems());
        try{
            instance.extend(i);
            System.out.println("Passed");
        }
        catch(Exception e)
        {
          fail("The test case is a prototype.");
        }
    }
    
    /**
     * Test of extend method, of class HoldingsMgr.
     */
    @Test
    public void testExtendBookReserved() throws Exception {
        System.out.println("extendreserved");
        int i = 0;
        HoldingsMgr instance = new HoldingsMgr();
        
        //Assume that tester is a member who has borrowed a single book and that book has now been reserved by another member
        
        Member tester = (Member) User.getUser("1111111113");
        instance.setCurrentMember(tester);
        instance.setCurrentHoldings(tester.getCurrentHoldingItems());
        try{
            instance.extend(i);
            fail("The test case is a prototype.");
        }
        catch(Exception e)
        {
          Assert.assertTrue("Incorrect Exception",e instanceof CopyReservedException);
        }
    }
    
        /**
     * Test of extend method, of class HoldingsMgr.
     */
    @Test
    public void testExtendSuspended() throws Exception {
        System.out.println("extendsuspended");
        int i = 0;
        HoldingsMgr instance = new HoldingsMgr();
        
        //Assume that tester is a member who has borrowed a single book and now has a fine.
        
        Member tester = (Member) User.getUser("1111111114");
        instance.setCurrentMember(tester);
        instance.setCurrentHoldings(tester.getCurrentHoldingItems());
        try{
            instance.extend(i);
            fail("The test case is a prototype.");
        }
        catch(Exception e)
        {
          Assert.assertTrue("Incorrect Exception",e instanceof UserSuspendedException);
        }
    }

    
}