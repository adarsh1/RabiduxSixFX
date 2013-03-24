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
    private String bookID;
    private String ISBN;
    private String title;
    private String author;
    private String genre;
    private String location;
    
    public Book(String bkID){
        bookID=bkID;
    }
    
    public boolean isValidBook(String bkID){
        //need to require database here
        return true;
    }
    
    //all get and set methods
    public String getBookID(){
        return bookID;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String tl){
        title=tl;
    }
    
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String atr){
        author=atr;
    }
    
    public String getLocation(){
        return location;
    }
    public void setLocation(String lct){
        location=lct;
    }
    
    public String getGenre(){
        return genre;
    }
    public void setGenre(String gne){
        genre=gne;
    }
   //end
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
}