/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import exception.CopyBorrowedException;
import exception.CopyNotFoundException;
import exception.CopyReservedException;
import exception.ItemNotFoundException;
import exception.NotEligibleToBorrowOrReserveException;
import exception.UserSuspendedException;
import factory.SystemConfig;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import usermanagement.Faculty;
import usermanagement.Member;
import usermanagement.Student;


/**
 *
 * @author Allen
 */
public class IndividualViewGUIMgrTest {
    private Member fm;
    private Member fsm;
    private Member sm;
    public IndividualViewGUIMgrTest() {
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
        fm=new Faculty();
        fm.setUserID("10000000XX");
        fm.setUsername("faculty1");
        fsm=new Faculty();
        fsm.setUserID("1000000XXX");
        fsm.setUsername("facultysuspended");
        sm=new Student();
        sm.setUserID("100000000X");
        sm.setUsername("student1");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reserve method, of class IndividualViewGUIMgr.
     */
    @Test
    public void testReserve() throws Exception {
        System.out.println("reserveFaculty");
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        instance.setCurrentMember(fm);
        instance.createItem("300000000X");
        try{
        instance.reserve(0);
        instance.reserve(1);
        System.out.println("Reserved 2 Books");
        }
        catch(NotEligibleToBorrowOrReserveException e){
          Assert.fail("Failed reserving 2 Books");
        }
        try{
        instance.reserve(2);
        System.out.println("Reserved 3rd Book");
        }
        catch(NotEligibleToBorrowOrReserveException e){
          Assert.fail("Failed reserving 3rd Book");
        }
        try{
        instance.reserve(3);
        Assert.fail("Reserved 4th Book");
        }
        catch(Exception e){
          Assert.assertTrue("Incorrect Exception Thrown",e instanceof NotEligibleToBorrowOrReserveException);
          System.out.println("Faculty Not Eligible To Borrow 4th book");
        }
        System.out.println("reserveMember");
        instance.setCurrentMember(sm);
        try{
        instance.reserve(4);
        System.out.println("Reserved 1 Books");
        }
        catch(NotEligibleToBorrowOrReserveException e){
          Assert.fail("Failed reserving 1 Books");
        }
        try{
           instance.reserve(1);
           Assert.fail("reserving book already reserved");
        }
        catch(Exception e){
          Assert.assertTrue("Incorrect Exception Thrown",e instanceof CopyReservedException);
          System.out.println("Member cannot reserve Book Borrowed by someone else");
        }
        try{
           instance.reserve(4);
           Assert.fail("Failed reserving same book twice");
        }
        catch(Exception e){
          Assert.assertTrue("Incorrect Exception Thrown",e instanceof CopyReservedException);
          System.out.println("Member cannot reserve Book Twice");
        }
        try{
           instance.reserve(3);
           Assert.fail("Failed Borrower and Reserver the same");
        }
        catch(Exception e){
          Assert.assertTrue("Incorrect Exception Thrown",e instanceof CopyBorrowedException);
          System.out.println("Borrower and Reserver Cannot be the Same");
        }
        try{
        instance.reserve(5);
        System.out.println("Reserved 2nd Book");
        }
        catch(NotEligibleToBorrowOrReserveException e){
          Assert.fail("Failed reserving 2nd Book");
        }
        try{
        instance.reserve(6);
        Assert.fail("Reserved 3rd Book");
        }
        catch(Exception e){
          Assert.assertTrue("Incorrect Exception Thrown",e instanceof NotEligibleToBorrowOrReserveException);
          System.out.println("Student Not Eligible To Borrow 3rd book");
        }
    }
    @Test
    public void testSuspendedUserReserve() throws Exception {
        System.out.println("reserveSuspendedMember");
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        instance.setCurrentMember(fsm);
        instance.createItem("300000000X");
        try{
        instance.reserve(6);
        Assert.fail("Suspended Member Reserved A Book");
        }
        catch(Exception e){
          Assert.assertTrue("Incorrect Exception Thrown",e instanceof UserSuspendedException);
          System.out.println("Suspended Member Cannot Reserve");
        }
    }
    @Test
    public void testInvalidCopyID() throws Exception {
        System.out.println("CopyID");
        IndividualViewGUIMgr instance = new IndividualViewGUIMgr();
        instance.setCurrentMember(sm);
       try{System.out.println("ValidID");
           instance.createItem("300000000X");
           if(instance.getItem()!=null)
           {System.out.println("Item Created");
           }
           else
           {Assert.fail("No Exception but item not created");
           }
       }
       catch(Exception e){
        Assert.fail("Could not create item with valid ID, "+e.getMessage()+" Thrown");   
       }
       try{System.out.println("NullID");
           instance.createItem("");
           Assert.fail("Item created with null ID");
       }
       catch(Exception e){
           Assert.assertTrue("Incorrect Exception Thrown"+e.getMessage(),e instanceof ItemNotFoundException);
           System.out.println("Item Cannot be Created with null id");
       }
       try{System.out.println("InvalidID");
           instance.createItem("");
           Assert.fail("Item created with invalid ID");
       }
       catch(Exception e){
           Assert.assertTrue("Incorrect Exception Thrown",e instanceof ItemNotFoundException);
           System.out.println("Item Cannot be Created with invalid id");
       }
    }
    }
    