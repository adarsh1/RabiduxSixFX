/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resetfine;

import cataloguemanagement.Borrowable;
import cataloguemanagement.CatalogueCopy;
import cataloguemanagement.PastTransaction;
import exception.NotEligibleToBorrowOrReserveException;
import exception.TypeMismatchException;
import java.sql.SQLException;
import usermanagement.Member;
import usermanagement.User;

/**
 *
 * @author Richard
 */
public class ResetFineMgr {
 
     
    private Member finedMember;
    
    //a member object required to construct
    /**
     *
     * @param currentMember
     */
    public ResetFineMgr(Member currentMember){
        this.finedMember = currentMember;
    }
    /**
     *
     */
    public ResetFineMgr(){
        //empty constructor
    }
    

    /**
     * @return the finedMember
     */
    public Member getCurrentMember() {
        return finedMember;
    }

    /**
     * @param finedMember the currentMember to set
     */
    public void setFinedMember(Member finedMember) {
        this.finedMember = finedMember;
    }
    
    
    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void setMember(String userID) throws SQLException, ClassNotFoundException
    {
        finedMember = (Member)User.getUser(userID);
        
    }

    /**
     *
     * @return
     */
    public String getUserName()
    {
        return finedMember.getUsername();
    }
    
    /**
     *
     * @return
     */
    public String getUserFine()
    {
        return (finedMember.getFineAmount() + "");
    }
    
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void reset() throws SQLException, ClassNotFoundException
    {
        finedMember.resetFine();
    }
}
