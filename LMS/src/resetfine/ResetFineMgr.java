/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resetfine;

import exception.InvalidUserTypeException;
import exception.NullResultException;
import exception.UserNotFoundException;
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
     * @param userName
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws InvalidUserTypeException  
     */
    public void setMember(String userName) throws SQLException, ClassNotFoundException, UserNotFoundException, InvalidUserTypeException
    {
        finedMember = (Member)User.getUserByName(userName);
        
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
     * @throws UserNotFoundException 
     * @throws NullResultException  
     */
    public void reset() throws SQLException, ClassNotFoundException, UserNotFoundException, NullResultException
    {
        finedMember.resetFine();
    }
}
