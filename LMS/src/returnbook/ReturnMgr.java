/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package returnbook;

import cataloguemanagement.CatalogueCopy;
import cataloguemanagement.PastTransaction;
import cataloguemanagement.Returnable;
import exception.CopyNotFoundException;
import exception.InvalidUserTypeException;
import exception.ItemNotFoundException;
import exception.NullResultException;
import exception.TypeMismatchException;
import exception.UserNotFoundException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    /**
     *
     * @param currentLibrarian
     */
    public ReturnMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
        fine = 0;
    }
    /**
     *
     */
    public ReturnMgr(){
        //empty constructor
        fine = 0;
    }
    //borrow the book
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean returnbook() throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException{
        
        boolean finepresent = calculatefine();
        item.returnCopy(fine);
        return finepresent;
    }
    
    
    //create a borrowable item based on item ID
    /**
     *
     * @param copyID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws TypeMismatchException
     */
    public void createItem(String copyID) throws SQLException, ClassNotFoundException, TypeMismatchException, CopyNotFoundException, ItemNotFoundException, UserNotFoundException, InvalidUserTypeException{
        //get the catalogue item from catalogue management
        CatalogueCopy catalogueItem = CatalogueCopy.getCatalogueCopy(copyID);
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
    
    
    /**
     *
     * @return
     */
    public boolean calculatefine()
    {
        Calendar now = Calendar.getInstance();
        Calendar toreturn = loandetails.getDateToReturn();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
        System.out.println("Date now:   " + dateFormatter.format(now.getTime()));
        System.out.println("Date to return:   " + dateFormatter.format(toreturn.getTime()));
        System.out.println(now.before(toreturn));
        if(now.before(toreturn))
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
    
    /**
     *
     * @return
     */
    public float getfine()
    {
        return fine;
    }
    
}
