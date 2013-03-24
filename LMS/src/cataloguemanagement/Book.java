/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import userManagement.Member;

/**
 *
 * @author mmin001
 */
public class Book extends CatalogueItem{
    
    private String ISBN;
    private String genre;
    
    public Book(String itemID){
        super(itemID);
    }   

    //below method need to access database
    public boolean isAvailabe(){
        return true;
    }
    
    public boolean isOverdue(){
        return true;
    }
    
    public boolean isReserved(){
        return true;
    }
    
    public void reserve(Member member){
    }
    
    public void borrow(Member member){
    }
    
    public void extend(Member member){
        
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}