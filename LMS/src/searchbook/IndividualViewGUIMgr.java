
package searchbook;

import cataloguemanagement.ReservableCopyGroup;
import exception.CopyBorrowedException;
import exception.CopyNotBorrowedException;
import exception.CopyNotFoundException;
import exception.CopyReservedException;
import exception.ItemNotFoundException;
import exception.NotEligibleToBorrowOrReserveException;
import exception.NullResultException;
import exception.UserNotFoundException;
import exception.UserSuspendedException;
import java.sql.SQLException;
import usermanagement.Member;

/**
 *
 * @author Adarsh
 */
public class IndividualViewGUIMgr {
    
    private Member currentMember;
    private ReservableCopyGroup item;   
    /**
     *
     */
    public static final int STUDENT_RESERVE_DURATION = 3;
    
    /**
     * This Constructor sets the currentMember of the object to currentMember
     * @param currentMember 
     */
    //a member object required to construct
    public IndividualViewGUIMgr(Member currentMember){
        this.currentMember = currentMember;
    }
    /**
     * Default Constructor
     */
    public IndividualViewGUIMgr(){
        //empty constructor
    }
    /**
     * Reserves the ith {@link cataloguemanagement.Reservable} object in {@link #item}
     * @param i the index of the {@link cataloguemanagement.Reservable} object in {@link #item}
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NotEligibleToBorrowOrReserveException 
     */
    //reserve the book
    public void reserve(int i) throws SQLException, ClassNotFoundException, NotEligibleToBorrowOrReserveException, UserNotFoundException, CopyNotFoundException, CopyNotBorrowedException, NullResultException, CopyReservedException, CopyBorrowedException, UserSuspendedException{
        if (currentMember.isSuspended()){
            throw new UserSuspendedException();
        }
        //if this member is allowed to borrow or reserve
        if(!currentMember.isEligibleToReserve()){
            throw new NotEligibleToBorrowOrReserveException("You have exceeded your maximum reservations, you are not elligible to reserve");             
        }
        else {
            item.getCopies().get(i).reserve(currentMember.getUserID());
        }
    }
    //create a borrowable item based on item ID
    /**
     * Initializes {@link #item} based on the itemID in ID.
     * @param ID the itemID String to generate the {@link ReservableCopyGroup}.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void createItem(String ID) throws SQLException, ClassNotFoundException, ItemNotFoundException, CopyNotFoundException{
        //get the catalogue item from catalogue management
        ReservableCopyGroup rItem = ReservableCopyGroup.getReservableCopyGroup(ID);
        //if the item is of Borrowable instance
            setItem(rItem );
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
     * @return the {@link #item}
     */
    public ReservableCopyGroup getItem() {
        return item;
    }

    /**
     * Sets the {@link #item}
     * @param item the item to set
     */
    public void setItem(ReservableCopyGroup item) {
        this.item = item;
    }
    
    
    
    
}
