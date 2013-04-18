/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.DataStore;
import java.sql.*;
import java.util.*;

/**
 *
 * @author mmin001
 */

public class Book extends CatalogueCopy 
    implements Borrowable,Extendable,Reservable,ReservationCancellable,Returnable,ItemUpdatable{
    
    private String ISBN;
    private String genre;
    
    /**
     *
     */
    public Book () {
        
        super();
        
    }
    
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Book getBook(String copyID) throws SQLException, ClassNotFoundException {
        
        return (Book) CatalogueCopy.getCatalogueCopy(copyID);
        
    }
    
    /**
     *
     * @param itemID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Boolean isValidBook(String itemID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isValidBookID(itemID);
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getISBN() {
        
        return ISBN;
        
    }

    /**
     *
     * @param ISBN
     */
    public void setISBN(String ISBN) {
        
        this.ISBN = ISBN;
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getGenre() {
        
        return genre;
        
    }

    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        
        this.genre = genre;
        
    }

    /**
     *
     * @param userID
     * @param loanDuration
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public PastTransaction borrow(String userID, int loanDuration) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
//            throw new BookBorrowedException();
            
        }
        
        return dataStore.borrow(super.getIndividualCopyID(), userID, loanDuration);
        
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        
        return super.getTitle();
        
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription() {
        
        return super.getDescription();
        
    }

    /**
     *
     * @return
     */
    @Override
    public String getAuthor() {
        
        return super.getAuthor();
        
    }

    /**
     *
     * @return
     */
    @Override
    public Calendar getPublishDate() {
        
        return super.getPublishDate();
        
    }
    
    @Override
    public String getItemID(){
        
        return super.getItemID();
        
    }

    /**
     *
     * @param loanID
     * @param loanDuration
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void extend(String loanID, int loanDuration) throws SQLException, ClassNotFoundException{
        
        DataStore dataStore = new DataStore();
                
        if (dataStore.isCopyOverdue(super.getIndividualCopyID())) {
            
//            throw new CopyOverdueException();
            
        }
        
        dataStore.extend(super.getIndividualCopyID(), loanID, loanDuration);
        
    }

    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void reserve(String userID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
//            throw new CopyNotBorrowedException();
            
        }
        
        if (dataStore.isCopyReserved(super.getIndividualCopyID())) {
            
//            throw new CopyReservedException();
            
        }
        
        dataStore.reserve(super.getIndividualCopyID(), userID);
        
    }

    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void cancelReservation(String userID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyReserved(super.getIndividualCopyID())) {
            
//            throw new CopyNotReservedException();
            
        }
        
        dataStore.cancelReservation(super.getIndividualCopyID(), userID);
        
    }

    /**
     *
     * @param fine
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void returnCopy(double fine) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
//            throw new CopyNotBorrowedException();
            
        }
        
        dataStore.returnBook(super.getIndividualCopyID(), fine);
        
    }


    /**
     *
     * @return
     */
    @Override
    public String getIndividualCopyID() {
        
        return super.getIndividualCopyID();
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean isReserved() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isCopyReserved(super.getIndividualCopyID());
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean isBorrowed() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isCopyBorrowed(super.getIndividualCopyID());
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReservedCopy getReservedCopy() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getReservedCopy(super.getIndividualCopyID());
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public PastTransaction getPastTransaction() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getRecord(super.getIndividualCopyID());
        
    }

    @Override
    public void addNewItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();      
        dataStore.addItem(details, CatalogueCopy.BOOK);
        
    }

    @Override
    public void updateItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        dataStore.updateItem(details, CatalogueCopy.BOOK);
        
    }

    @Override
    public HashMap<String, Object> getItem(String itemID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        HashMap<String, Object> details;
        
        details = dataStore.getItemInfo(itemID, CatalogueCopy.BOOK);
        
        return details;
        
    }

    @Override
    public void deleteItem(String itemID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        dataStore.deleteItem(itemID, CatalogueCopy.BOOK);
        
    }

    @Override
    public void addNewCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();      
        dataStore.addCopy(details);
        
    }

    @Override
    public void updateCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();      
        dataStore.updateCopy(details);
        
    }

    @Override
    public HashMap<String, Object> getCopy(String copyID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        HashMap<String, Object> details;
        
        details = dataStore.getCopyInfo(copyID);
        
        return details;
        
    }

    @Override
    public void deleteCopy(String copyID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        dataStore.deleteCopy(copyID);
        
    }

}