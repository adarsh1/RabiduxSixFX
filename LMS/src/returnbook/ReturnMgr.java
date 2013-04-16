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
import java.util.Calendar;
import java.util.Date;
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
    private float fine;
    private PastTransaction loandetails;
    
    //a member object required to construct
    public ReturnMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    public ReturnMgr(){
        //empty constructor
    }
    //borrow the book
    public boolean returnbook() throws SQLException, ClassNotFoundException{
        
        boolean finepresent = calculatefine();
        item.returnCopy(returningMember.getUserID(),fine);
        return finepresent;
    }
    
    
    //create a borrowable item based on item ID
    public void createItem(String copyID) throws SQLException, ClassNotFoundException, TypeMismatchException{
        //get the catalogue item from catalogue management
        CatalogueItem catalogueItem = CatalogueItem.getCatalogueItem(copyID);
        //if the item is of Borrowable instance
        if (catalogueItem instanceof Returnable){
            //cast to returnable type
            setItem( (Returnable) catalogueItem );
            loandetails = item.getPastTransaction();
            returningMember = loandetails.getMember();
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
    
    
    public boolean calculatefine()
    {
        Calendar c = Calendar.getInstance();
        Date currentdate = c.getTime();
        if(currentdate.before(loandetails.getDateToReturn().getTime()))
        {
            fine = 0;
            return false;
        }
        else
        {
            fine = 100;
            return true;
        }
        
    }
    
    public float getfine()
    {
        return fine;
    }
    
}
