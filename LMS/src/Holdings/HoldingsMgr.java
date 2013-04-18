
package Holdings;

//import lib and packages

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedCopy;
import exception.CopyNotFoundException;
import exception.ItemNotFoundException;
import exception.NotEligibleToBorrowOrReserveException;
import exception.NullResultException;
import exception.RecordNotFoundException;
import exception.TypeMismatchException;
import exception.UserNotFoundException;
import exception.UserSuspendedException;
import java.sql.SQLException;
import java.util.ArrayList;
import usermanagement.Member;
/**
 *
 * @author Adarsh
 */

//relationship with other classes
public class HoldingsMgr {
     
    //parameters
    private Member currentMember;    
    private ArrayList<ReservedCopy> reservedCopies;
    private ArrayList<CurrentHolding> currentHoldings;
    /**
     *
     */
    public static final int MAX_EXTENSIONS=3;
    //constrcutor
    /**
     *
     */
    public HoldingsMgr(){      
       
    }

    /**
     * @param currentMember 
     */
     //a member object required to construct
    public HoldingsMgr(Member currentMember){
        this.currentMember = currentMember;
    }
    /**
     * Extends the ith {@link cataloguemanagement.CurrentHolding} object in {@link #currentHoldings}
     * @param i the index of the {@link cataloguemanagement.CurrentHolding} object in {@link #currentHoldings}
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NotEligibleToBorrowOrReserveException 
     */
    //borrow the book
    public void extend(int i) throws ClassNotFoundException, CopyNotFoundException, ItemNotFoundException, NotEligibleToBorrowOrReserveException, NullResultException, RecordNotFoundException, SQLException, UserNotFoundException, UserSuspendedException{
        //if this member is allowed to borrow or reserve
        if(currentMember.isSuspended())
            throw new UserSuspendedException();
        if(currentHoldings.get(i).getNumOfExtend()<MAX_EXTENSIONS){
             currentHoldings.get(i).getCopy().extend(currentHoldings.get(i).getLoanID(), currentMember.getLoanDuration());
        }
        else {
            throw new NotEligibleToBorrowOrReserveException("Sorry, you are not able to extend this book any further");
        }
    }
    /**
     * Reserves the ith {@link cataloguemanagement.ReservedCopy} object in {@link #reservedCopies}
     * @param i the index of the {@link cataloguemanagement.Reservable} object in {@link #reservedCopies}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void cancelReservation(int i) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException, UserNotFoundException{
        //if this member is allowed to borrow or reserve
             reservedCopies.get(i).getCopy().cancelReservation(currentMember.getUserID());
    }
    //create a borrowable item based on item ID
    /**
     * Initializes {@link #reservedCopies} and the {@link #currentHoldings} based on the {@link #currentMember}.
     * @throws TypeMismatchException
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void createItem() throws SQLException, ClassNotFoundException, TypeMismatchException, UserNotFoundException, CopyNotFoundException, ItemNotFoundException{
        //get the catalogue item from catalogue management
        setReservedCopies(currentMember.getReservedCopies());
        setCurrentHoldings(currentMember.getCurrentHoldingItems());
    }

    /**
     * @return the {@link #currentMember}
     */
    public Member getCurrentMember() {
        return currentMember;
    }

     /** 
     * Sets the {@link #currentMember}
     * @param currentMember the currentMember to set
     */
    public void setCurrentMember(Member currentMember) {
        this.currentMember = currentMember;
    }

    /**
     * 
     * @return the {@link #reservedCopies}.
     */
    public ArrayList<ReservedCopy> getReservedCopies() {
        return reservedCopies;
    }

    /**
     * Sets the {@link #reservedCopies}
     * @param item the item to set
     */
    public void setReservedCopies(ArrayList<ReservedCopy> item) {
        reservedCopies = item;
    }
    /**
     * 
     * @return the {@link #currentHoldings}.
     */
    public ArrayList<CurrentHolding> getCurrentHoldings() {
        return currentHoldings;
    }

    /**
     * Sets the {@link #currentHoldings}
     * @param item the currentHoldings to set
     */
    public void setCurrentHoldings(ArrayList<CurrentHolding> item) {
        currentHoldings = item;
    }
    /**
     * 
     * @return the {@link #currentHoldings} size.
     */
    public int getNoOfCurrentHoldings(){
      return  currentHoldings.size();
    }
    /**
     * 
     * @return the {@link #reservedCopies} size.
     */
    public int getNoOfReservedCopies(){
      return  reservedCopies.size();
    }
    
}   


  