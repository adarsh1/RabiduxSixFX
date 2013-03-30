
package borrowbook;

import cataloguemanagement.Borrowable;
import cataloguemanagement.CatalogueItem;
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
    
    //borrow the book
    public void borrow() throws SQLException, ClassNotFoundException{
        //if this member is allowed to borrow or reserve
        if(currentMember.isEligibleToBorrowOrReserve()){
            item.borrow(currentMember.getUserID());
        }
    }
    
    //create a borrowable item based on item ID
    public void createItem(String itemID) throws SQLException, ClassNotFoundException, TypeMismatchException{
        //get the catalogue item from catalogue management
        CatalogueItem catalogueItem = CatalogueItem.getCatalogueItem(itemID);
        //if the item is of Borrowable instance
        if (catalogueItem instanceof Borrowable){
            //cast to borrowable type
            setItem( (Borrowable) catalogueItem );
        }
        else{
            throw new TypeMismatchException(itemID,"Borrowable");
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
