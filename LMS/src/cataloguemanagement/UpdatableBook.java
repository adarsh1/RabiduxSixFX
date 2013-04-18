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
    
    public UpdatableBook(){
        
    }
    
    public void addNewBook(String title, String author, String description, Calendar publishDate, String ISBN, String genre){
        
    }
    
    public void updateBook(String itemID, String title, String author, String description, Calendar publishDate, String ISBN, String genre) throws ItemNotFoundException{
        
    }
    
    public HashMap getBookDetails(String itemID) throws ItemNotFoundException{
        return new HashMap();
    }
    
    public void deleteBook(String itemID) throws ItemNotFoundException{
        
    }
}
