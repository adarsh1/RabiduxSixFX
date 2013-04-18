/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.ItemNotFoundException;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Allen
 */
public class UpdatableBook {
    
    /**
     *
     */
    public UpdatableBook(){
        
    }
    
    /**
     *
     * @param title
     * @param author
     * @param description
     * @param publishDate
     * @param ISBN
     * @param genre
     */
    public void addNewBook(String title, String author, String description, Calendar publishDate, String ISBN, String genre){
        
    }
    
    /**
     *
     * @param itemID
     * @param title
     * @param author
     * @param description
     * @param publishDate
     * @param ISBN
     * @param genre
     * @throws ItemNotFoundException
     */
    public void updateBook(String itemID, String title, String author, String description, Calendar publishDate, String ISBN, String genre) throws ItemNotFoundException{
        
    }
    
    /**
     *
     * @param itemID
     * @return
     * @throws ItemNotFoundException
     */
    public HashMap getBookDetails(String itemID) throws ItemNotFoundException{
        return new HashMap();
    }
    
    /**
     *
     * @param itemID
     * @throws ItemNotFoundException
     */
    public void deleteBook(String itemID) throws ItemNotFoundException{
        
    }
}
