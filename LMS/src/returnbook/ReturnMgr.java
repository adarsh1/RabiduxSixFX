/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package returnbook;

import cataloguemanagement.Borrowable;
import cataloguemanagement.CatalogueItem;
import cataloguemanagement.PastTransaction;
import cataloguemanagement.Returnable;
import exception.CopyNotFoundException;
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
    private Member returningMember;
    
    //a member object required to construct
    public ReturnMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    public ReturnMgr(){
        //empty constructor
    }
    //borrow the book
    public boolean returnbook() throws SQLException, ClassNotFoundException{
        
        item.returnCopy(returningMember.getUserID());
        return true;
    }
    
    
    //create a borrowable item based on item ID
    public void createItem(String copyID) throws SQLException, ClassNotFoundException, TypeMismatchException, CopyNotFoundException{
        //get the catalogue item from catalogue management
        CatalogueItem catalogueItem = CatalogueItem.getCatalogueItem(copyID);
        //if the item is of Returnable instance
        if (catalogueItem instanceof Returnable){
            //cast to returnable type
            setItem( (Returnable) catalogueItem );
        
        }
        else{
            throw new TypeMismatchException(catalogueItem.getTitle(),"Returnable");
        }
    }

    /**
     * @return the currentLibrarian
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
