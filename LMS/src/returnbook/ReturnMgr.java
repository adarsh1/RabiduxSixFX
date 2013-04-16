/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package returnbook;

import cataloguemanagement.Borrowable;
import cataloguemanagement.CatalogueItem;
import cataloguemanagement.PastTransaction;
import cataloguemanagement.Returnable;
import exception.NotEligibleToBorrowOrReserveException;
import exception.TypeMismatchException;
import java.sql.SQLException;
import usermanagement.Librarian;
import usermanagement.Member;


/**
 *
 * @author Ambarish
 */
public class ReturnMgr {
    private Librarian currentLibrarian;
    private Returnable item;   
    
    //a member object required to construct
    public ReturnMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    public ReturnMgr(){
        //empty constructor
    }
    //borrow the book
  /*  public PastTransaction borrow() throws SQLException, ClassNotFoundException, NotEligibleToBorrowOrReserveException{
        //if this member is allowed to borrow or reserve
        if(currentMember.isEligibleToBorrowOrReserve()){
          return item.borrow(currentMember.getUserID(), currentMember.getLoanDuration());
        }
        else {
            throw new NotEligibleToBorrowOrReserveException("Sorry, you are not able to borrow");
        }
    }
    */
    //create a borrowable item based on item ID
    public void createItem(String copyID) throws SQLException, ClassNotFoundException, TypeMismatchException{
        //get the catalogue item from catalogue management
        CatalogueItem catalogueItem = CatalogueItem.getCatalogueItem(copyID);
        //if the item is of Borrowable instance
        if (catalogueItem instanceof Borrowable){
            //cast to borrowable type
            setItem( (Returnable) catalogueItem );
        }
        else{
            throw new TypeMismatchException(catalogueItem.getTitle(),"Borrowable");
        }
    }

    /**
     * @return the currentMember
     */
    public Librarian getCurrentLibrarian() {
        return currentLibrarian;
    }

    /**
     * @param currentLibrarian the currentMember to set
     */
    public void setCurrentLibrarian(Librarian currentLibrarian) {
        this.currentLibrarian = currentLibrarian;
    }

    /**
     * @return the item
     */
    public Returnable getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Returnable item) {
        this.item = item;
    }
    
    
    
    
}
