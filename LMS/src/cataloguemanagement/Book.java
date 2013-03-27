/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.DataStore;
import java.sql.SQLException;
import userManagement.Member;

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
    public Boolean borrow(String memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTitleDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescriptionDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthorDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getImageName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPublishYearDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean extend(String memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean reverse(String memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean cancelReservation(String memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean returnBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}