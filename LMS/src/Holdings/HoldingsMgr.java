
package Holdings;

//import lib and packages

import cataloguemanagement.Borrowable;
import cataloguemanagement.CatalogueItem;
import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedCopy;
import exception.NotEligibleToBorrowOrReserveException;
import exception.TypeMismatchException;
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
    public static final int MAX_EXTENSIONS=3;
    //constrcutor
    public HoldingsMgr(){      
       
    }

    /**
     * @return the currentMember
     */
     //a member object required to construct
    public HoldingsMgr(Member currentMember){
        this.currentMember = currentMember;
    }
    //borrow the book
    public void extend(int i) throws SQLException, ClassNotFoundException, NotEligibleToBorrowOrReserveException{
        //if this member is allowed to borrow or reserve
        if(currentHoldings.get(i).getNumOfExtend()<MAX_EXTENSIONS){
             currentHoldings.get(i).getCopy().extend(currentHoldings.get(i).getLoanID(), currentMember.getLoanDuration());
        }
        else {
            throw new NotEligibleToBorrowOrReserveException("Sorry, you are not able to extend this book any further");
        }
    }
    public void cancelReservation(int i) throws SQLException, ClassNotFoundException{
        //if this member is allowed to borrow or reserve
             reservedCopies.get(i).getCopy().cancelReservation(currentMember.getUserID());
    }
    //create a borrowable item based on item ID
    public void createItem() throws SQLException, ClassNotFoundException, TypeMismatchException{
        //get the catalogue item from catalogue management
        setReservedCopies(currentMember.getReservedCopies());
        setCurrentHoldings(currentMember.getCurrentHoldingItems());
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
    public ArrayList<ReservedCopy> getReservedCopies() {
        return reservedCopies;
    }

    /**
     * @param item the item to set
     */
    public void setReservedCopies(ArrayList<ReservedCopy> item) {
        reservedCopies = item;
    }
    public ArrayList<CurrentHolding> getCurrentHoldings() {
        return currentHoldings;
    }

    /**
     * @param item the item to set
     */
    public void setCurrentHoldings(ArrayList<CurrentHolding> item) {
        currentHoldings = item;
    }
    
    public int getNoOfCurrentHoldings(){
      return  currentHoldings.size();
    }
    
    public int getNoOfReservedCopies(){
      return  reservedCopies.size();
    }
    
}   


  