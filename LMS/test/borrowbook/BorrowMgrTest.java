/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowbook;

import cataloguemanagement.Book;
import cataloguemanagement.Borrowable;
import cataloguemanagement.CatalogueCopy;
import cataloguemanagement.PastTransaction;
import exception.CopyBorrowedException;
import exception.CopyNotFoundException;
import exception.NotEligibleToBorrowOrReserveException;
import exception.UserSuspendedException;
import factory.SystemConfig;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import usermanagement.Faculty;
import usermanagement.Member;
import usermanagement.User;

/**
 *
 * @author Allen
 */
public class BorrowMgrTest {
    
    public BorrowMgrTest() {
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
     * Test of borrow method, of class BorrowMgr.
     */
    @Test(expected = CopyBorrowedException.class)
    public void testBorrow1() throws Exception {
        System.out.println("borrow");
        BorrowMgr instance = new BorrowMgr();
        CatalogueCopy book = CatalogueCopy.getCatalogueCopy("2000000001");
        instance.setItem((Borrowable)book);
        User user = User.getUserByName("ding0066@e.ntu.edu.sg");
        Member student = (Member)user;
        instance.setCurrentMember((Member)student);
        PastTransaction result = instance.borrow();
    }
    
    @Test(expected = NotEligibleToBorrowOrReserveException.class)
    public void testBorrow2() throws Exception {
        System.out.println("borrow");
        BorrowMgr instance = new BorrowMgr();
        instance.setItem(new Book());
        Member member = new Faculty();
        member.setUserID("1000000001");
        instance.setCurrentMember(member);
        PastTransaction result = instance.borrow();
    }
    
    @Test(expected = UserSuspendedException.class)
    public void testBorrow3() throws Exception {
        System.out.println("borrow");
        BorrowMgr instance = new BorrowMgr();
        CatalogueCopy book = CatalogueCopy.getCatalogueCopy("2000000003");
        instance.setItem((Borrowable)book);
        User user = User.getUserByName("ding0066@e.ntu.edu.sg");
        Member student = (Member)user;
        student.setFineAmount(100);
        instance.setCurrentMember((Member)student);
        PastTransaction result = instance.borrow();
    }

    /**
     * Test of createItem method, of class BorrowMgr.
     */
    @Test(expected=CopyNotFoundException.class)
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        String copyID = "234";
        BorrowMgr instance = new BorrowMgr();
        instance.createItem(copyID);
    }

}