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

/**
 *
 * @author Richard
 */
public class ResetFineMgr {
 
     
    private Member currentMember;
    
    //a member object required to construct
    public ResetFineMgr(Member currentMember){
        this.currentMember = currentMember;
    }
    public ResetFineMgr(){
        //empty constructor
    }
    

    /**
     * @return the currentMember
     */
    public Member getCurrentMember() {
        return currentMember;
    }

    /**
     * @param currentMember the currentMember to set
     */
    public void setCurrentMember(Member currentMember) {
        this.currentMember = currentMember;
    }
    
    
    public void setMember(String userID)
    {
        //get member from datastore 
    }

    public String getUserName()
    {
        return currentMember.getUsername();
    }
    
    public String getUserFine()
    {
        return (currentMember.getFineAmount() + "");
    }
}
