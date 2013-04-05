
package searchbook;

import cataloguemanagement.ReservableCopyGroup;
import java.sql.SQLException;
import usermanagement.Member;

/**
 *
 * @author Adarsh
 */
public class IndividualViewGUIMgr {
    
    private Member currentMember;
    private ReservableCopyGroup item;   
    
    //a member object required to construct
    public IndividualViewGUIMgr(Member currentMember){
        this.currentMember = currentMember;
    }
    public IndividualViewGUIMgr(){
        //empty constructor
    }
    
    //create a borrowable item based on item ID
    public void createItem(String ID) throws SQLException, ClassNotFoundException{
        //get the catalogue item from catalogue management
        ReservableCopyGroup rItem = ReservableCopyGroup.getReservableCopyGroup(ID);
        //if the item is of Borrowable instance
            setItem(rItem );
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

    /**
     * @return the item
     */
    public ReservableCopyGroup getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(ReservableCopyGroup item) {
        this.item = item;
    }
    
    
    
    
}
