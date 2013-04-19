/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.DataStore;
import exception.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author mmin001
 */

public class Book extends CatalogueCopy 
    implements Borrowable,Extendable,Reservable,ReservationCancellable,Returnable,ItemUpdatable{
    
    /**
     *
     */
    public static int GRACE_PERIOD = 3;
    
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
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException  
     */
    public static Book getBook(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException {
        
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
     * @throws CopyNotFoundException 
     * @throws UserNotFoundException
     * @throws CopyBorrowedException
     * @throws NullResultException
     * @throws CopyReservedException  
     */
    @Override
    public PastTransaction borrow(String userID, int loanDuration) throws SQLException, ClassNotFoundException, CopyNotFoundException, UserNotFoundException, NullResultException, CopyReservedException, CopyBorrowedException {
        
        DataStore dataStore = new DataStore();
        
        if (dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
            throw new CopyBorrowedException();
            
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
     * @throws CopyNotFoundException 
     * @throws NullResultException 
     * @throws RecordNotFoundException
     * @throws ItemNotFoundException 
     * @throws CopyOverdueException 
     * @throws CopyReservedException  
     */
    @Override
    public void extend(String loanID, int loanDuration) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException, RecordNotFoundException, ItemNotFoundException, CopyOverdueException, CopyReservedException {
        
        DataStore dataStore = new DataStore();
                
        if (dataStore.isCopyOverdue(super.getIndividualCopyID())) {
            
            throw new CopyOverdueException();
            
        }
        
        if (dataStore.isCopyReserved(super.getIndividualCopyID())) {
            
            throw new CopyReservedException();
            
        }
        
        dataStore.extend(super.getIndividualCopyID(), loanID, loanDuration);
        
    }

    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws CopyNotBorrowedException
     * @throws NullResultException 
     * @throws UserNotFoundException
     * @throws CopyReservedException
     * @throws CopyBorrowedException  
     */
    @Override
    public void reserve(String userID) throws SQLException, ClassNotFoundException, CopyNotFoundException, CopyNotBorrowedException, NullResultException, CopyReservedException, UserNotFoundException, CopyBorrowedException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
            throw new CopyNotBorrowedException();
            
        }
        
        if (dataStore.isCopyReserved(super.getIndividualCopyID())) {
            
            throw new CopyReservedException();
            
        }
        
        dataStore.reserve(super.getIndividualCopyID(), userID);
        
    }

    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws CopyNotReservedException
     * @throws UserNotFoundException 
     * @throws NullResultException  
     */
    @Override
    public void cancelReservation(String userID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException, UserNotFoundException, CopyNotReservedException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyReserved(super.getIndividualCopyID())) {
            
            throw new CopyNotReservedException();
            
        }
        
        dataStore.cancelReservation(super.getIndividualCopyID(), userID);
        
    }

    /**
     *
     * @param fine
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws NullResultException
     * @throws CopyNotBorrowedException  
     */
    @Override
    public void returnCopy(double fine) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException, CopyNotBorrowedException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
            throw new CopyNotBorrowedException();
            
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
     * @throws CopyNotFoundException
     * @throws NullResultException  
     */
    @Override
    public boolean isReserved() throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        DataStore dataStore = new DataStore();
        
        dataStore.refreshReserve(super.getIndividualCopyID(), Book.GRACE_PERIOD);
        return dataStore.isCopyReserved(super.getIndividualCopyID());
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException  
     */
    @Override
    public boolean isBorrowed() throws SQLException, ClassNotFoundException, CopyNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isCopyBorrowed(super.getIndividualCopyID());
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException  
     */
    @Override
    public ReservedCopy getReservedCopy() throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getReservedCopy(super.getIndividualCopyID());
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException
     * @throws UserNotFoundException 
     * @throws InvalidUserTypeException  
     */
    @Override
    public PastTransaction getPastTransaction() throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException, UserNotFoundException, InvalidUserTypeException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getRecord(super.getIndividualCopyID());
        
    }

    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InvalidItemTypeException
     */
    @Override
    public void addNewItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, InvalidItemTypeException {
        
        DataStore dataStore = new DataStore();      
        dataStore.addItem(details, CatalogueCopy.BOOK);
        
    }

    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws InvalidItemTypeException
     */
    @Override
    public void updateItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, ItemNotFoundException, InvalidItemTypeException {
        
        DataStore dataStore = new DataStore();
        dataStore.updateItem(details, CatalogueCopy.BOOK);
        
    }

    /**
     *
     * @param itemID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws NullResultException
     * @throws InvalidItemTypeException
     */
    @Override
    public HashMap<String, Object> getItem(String itemID) throws SQLException, ClassNotFoundException, ItemNotFoundException, NullResultException, InvalidItemTypeException {
        
        DataStore dataStore = new DataStore();
        HashMap<String, Object> details;
        
        details = dataStore.getItemInfo(itemID, CatalogueCopy.BOOK);
        
        return details;
        
    }

    /**
     *
     * @param itemID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws InvalidItemTypeException
     */
    @Override
    public void deleteItem(String itemID) throws SQLException, ClassNotFoundException, ItemNotFoundException, InvalidItemTypeException {
        
        DataStore dataStore = new DataStore();
        dataStore.deleteItem(itemID, CatalogueCopy.BOOK);
        
    }

    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void addNewCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();      
        dataStore.addCopy(details);
        
    }

    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws NullResultException
     */
    @Override
    public void updateCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        DataStore dataStore = new DataStore();      
        dataStore.updateCopy(details);
        
    }

    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws NullResultException
     */
    @Override
    public HashMap<String, Object> getCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        DataStore dataStore = new DataStore();
        HashMap<String, Object> details;
        
        details = dataStore.getCopyInfo(copyID);
        
        return details;
        
    }

    /**
     *
     * @param copyID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     */
    @Override
    public void deleteCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException {
        
        DataStore dataStore = new DataStore();
        dataStore.deleteCopy(copyID);
        
    }

    @Override
    public boolean isOverdued() throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isCopyOverdue(super.getIndividualCopyID());
        
    }

}