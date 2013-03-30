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

public class Book extends CatalogueItem implements Borrowable,Extendable,Reservable,ReservationCancellable,Returnable,Updatable {
    
    private String ISBN;
    private String genre;
    
    public Book () {
        
        super();
        
    }
    
    public static Book getBook(String copyID) throws SQLException, ClassNotFoundException {
        
        return (Book) CatalogueItem.getCatalogueItem(copyID);
        
    }
    
    public static Boolean isValidBook(String itemID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isValidBookID(itemID);
        
    }
    
    public String getISBN() {
        
        return ISBN;
        
    }

    public void setISBN(String ISBN) {
        
        this.ISBN = ISBN;
        
    }

    public String getGenre() {
        
        return genre;
        
    }

    public void setGenre(String genre) {
        
        this.genre = genre;
        
    }

    @Override
    public void borrow(String userID) {
        
        DataStore dataStore = new DataStore();
        dataStore.borrow(super.getIndividualCopyID(), userID);
        
    }

    @Override
    public String getTitleDisplay() {
        
        return super.getTitle();
        
    }

    @Override
    public String getDescriptionDisplay() {
        
        return super.getDescription();
        
    }

    @Override
    public String getAuthorDisplay() {
        
        return super.getAuthor();
        
    }

    @Override
    public String getPublishYearDisplay() {
        
        Calendar calendar = super.getPublishDate();
        return Integer.toString(calendar.get(Calendar.YEAR)) + "-" + Integer.toString(calendar.get(Calendar.MONTH)) + "-" + Integer.toString(calendar.get(Calendar.DATE));
        
    }
    
    @Override
    public String getItemIDDisplay(){
        return super.getItemID();
    }

    @Override
    public void extend(String loanID) {
        
        DataStore dataStore = new DataStore();
        dataStore.extend(loanID);
        
    }

    @Override
    public void reserve(String userID) {
        
        DataStore dataStore = new DataStore();
        dataStore.reserve(userID);
        
    }

    @Override
    public void cancelReservation(String userID) {
        
        DataStore dataStore = new DataStore();
        dataStore.cancelReservation(userID);
        
    }

    @Override
    public void returnBook(String copyID, String userID) {
        
        DataStore dataStore = new DataStore();
        dataStore.returnBook(copyID, userID);
        
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}