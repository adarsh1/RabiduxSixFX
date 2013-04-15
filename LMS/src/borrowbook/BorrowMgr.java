
package borrowbook;

import cataloguemanagement.Borrowable;
import cataloguemanagement.CatalogueItem;
import cataloguemanagement.PastTransaction;
import exception.NotEligibleToBorrowOrReserveException;
import exception.TypeMismatchException;
import java.sql.SQLException;
import usermanagement.Member;

/**
 *
 * @author Allen
 */
public class BorrowMgr {
    
    private Member currentMember;
    private Borrowable item;   
    
    //a member object required to construct
    public BorrowMgr(Member currentMember){
        this.currentMember = currentMember;
    }
    public BorrowMgr(){
        //empty constructor
    }
    //borrow the book
    public PastTransaction borrow() throws SQLException, ClassNotFoundException, NotEligibleToBorrowOrReserveException{
        //if this member is allowed to borrow or reserve
        if(currentMember.isEligibleToBorrowOrReserve()){
          return item.borrow(currentMember.getUserID(), currentMember.getLoanDuration());
        }
        else {
            throw new NotEligibleToBorrowOrReserveException("Sorry, you are not able to borrow");
        }
    }
    
    //create a borrowable item based on item ID
    public void createItem(String copyID) throws SQLException, ClassNotFoundException, TypeMismatchException{
        //get the catalogue item from catalogue management
        CatalogueItem catalogueItem = CatalogueItem.getCatalogueItem(copyID);
        //if the item is of Borrowable instance
        if (catalogueItem instanceof Borrowable){
            //cast to borrowable type
            setItem( (Borrowable) catalogueItem );
        }
        else{
            throw new TypeMismatchException(catalogueItem.getTitle(),"Borrowable");
        }
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
    public Borrowable getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Borrowable item) {
        this.item = item;
    }
    
    
    
    
}
