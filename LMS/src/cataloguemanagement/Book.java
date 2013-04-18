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
    implements Borrowable,Extendable,Reservable,ReservationCancellable,Returnable{
    
    private String ISBN;
    private String genre;
    
    public Book () {
        
        super();
        
    }
    
    public static Book getBook(String copyID) throws SQLException, ClassNotFoundException {
        
        return (Book) CatalogueCopy.getCatalogueCopy(copyID);
        
    }
    
    public static Boolean isValidBook(String itemID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isValidBookID(itemID);
        
    }
    
    @Override
    public String getISBN() {
        
        return ISBN;
        
    }

    public void setISBN(String ISBN) {
        
        this.ISBN = ISBN;
        
    }
    
    @Override
    public String getGenre() {
        
        return genre;
        
    }

    public void setGenre(String genre) {
        
        this.genre = genre;
        
    }

    @Override
    public PastTransaction borrow(String userID, int loanDuration) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
//            throw new BookBorrowedException();
            
        }
        
        return dataStore.borrow(super.getIndividualCopyID(), userID, loanDuration);
        
    }

    @Override
    public String getTitle() {
        
        return super.getTitle();
        
    }

    @Override
    public String getDescription() {
        
        return super.getDescription();
        
    }

    @Override
    public String getAuthor() {
        
        return super.getAuthor();
        
    }

    @Override
    public Calendar getPublishDate() {
        
        return super.getPublishDate();
        
    }
    
    @Override
    public String getItemID(){
        
        return super.getItemID();
        
    }

    @Override
    public void extend(String loanID, int loanDuration) throws SQLException, ClassNotFoundException{
        
        DataStore dataStore = new DataStore();
        
        if (dataStore.isCopyOverdue(super.getIndividualCopyID())) {
            
//            throw new CopyOverdueException();
            
        }
        
        dataStore.extend(super.getIndividualCopyID(), loanID, loanDuration);
        
    }

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

    @Override
    public void cancelReservation(String userID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyReserved(super.getIndividualCopyID())) {
            
//            throw new CopyNotReservedException();
            
        }
        
        dataStore.cancelReservation(super.getIndividualCopyID(), userID);
        
    }

    @Override
    public void returnCopy(double fine) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isCopyBorrowed(super.getIndividualCopyID())) {
            
//            throw new CopyNotBorrowedException();
            
        }
        
        dataStore.returnBook(super.getIndividualCopyID(), fine);
        
    }


    @Override
    public String getIndividualCopyID() {
        
        return super.getIndividualCopyID();
        
    }

    @Override
    public boolean isReserved() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isCopyReserved(super.getIndividualCopyID());
        
    }

    @Override
    public boolean isBorrowed() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isCopyBorrowed(super.getIndividualCopyID());
        
    }

    @Override
    public ReservedCopy getReservedCopy() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getReservedCopy(super.getIndividualCopyID());
        
    }

    @Override
    public PastTransaction getPastTransaction() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getRecord(super.getIndividualCopyID());
        
    }
}