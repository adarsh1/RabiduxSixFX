
package updatecatalogue;

import datamanagement.Table;
import exception.ItemExistException;
import java.util.Calendar;
import java.util.HashMap;
import usermanagement.Librarian;

/**
 *
 * @author Richard
 */
public class UpdateMgr {
    
    private Librarian currentLibrarian;
    
    public UpdateMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    public UpdateMgr(){
        //empty constructor
    }
    
    public void addNewBook(String title, String author, Calendar publishDate, String description, String ISBN, String genre) throws ItemExistException{
        HashMap<String, Object> newBook = new HashMap();
        setBookDetails(newBook, title, author, description, publishDate, ISBN, genre);
        
        //newBook.addNewItem();
    }
    
    public void updateBook(String itemID, String title, String author, Calendar publishDate, String description, String ISBN, String genre){
        HashMap<String, Object> newBook = new HashMap();
        newBook.put(Table.BOOK_BOOK_ID,itemID);
        setBookDetails(newBook, title, author, description, publishDate, ISBN, genre);        
    }
    
    public HashMap getItemInfo(String itemID){
        return new HashMap();
    }

    /**
     * @return the currentLibrarian
     */
    public Librarian getCurrentLibrarian() {
        return currentLibrarian;
    }

    /**
     * @param currentLibrarian the currentLibrarian to set
     */
    public void setCurrentLibrarian(Librarian currentLibrarian) {
        this.currentLibrarian = currentLibrarian;
    }

    private void setBookDetails(HashMap<String, Object> newBook, String title, String author, String description, Calendar publishDate, String ISBN, String genre) {
        newBook.put(Table.BOOK_TITLE,title);
        newBook.put(Table.BOOK_AUTHOR,author);
        newBook.put(Table.BOOK_DESCRIPTION, description);
        newBook.put(Table.BOOK_DATE,publishDate);
        newBook.put(Table.BOOK_ISBN, ISBN);
        newBook.put(Table.BOOK_GENRE, genre);
        
        //bookToUpdate.updateItem();
    }
}
