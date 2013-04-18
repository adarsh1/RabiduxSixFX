
package updatecatalogue;

import cataloguemanagement.UpdatableBook;
import cataloguemanagement.UpdatableCopy;
import datamanagement.Table;
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
    
    public void addNewBook(String title, String author, Calendar publishDate, String description, String ISBN, String genre){
        UpdatableBook updatableBook = new UpdatableBook();
        updatableBook.updateBook(genre, title, author, description, publishDate, ISBN, genre);
    }
    
    public void updateBook(String itemID, String title, String author, Calendar publishDate, String description, String ISBN, String genre){
        UpdatableBook updatableBook = new UpdatableBook();     
        updatableBook.updateBook(itemID, title, author, description, publishDate, ISBN, genre);
    }
    
    public HashMap getItemInfo(String itemID){
        UpdatableBook updatableBook = new UpdatableBook(); 
        return updatableBook.getBookDetails(itemID);
    }
    
    public void deleteBook(String itemID){
        UpdatableBook updatableBook = new UpdatableBook(); 
        updatableBook.deleteBook(itemID);
    }
    
    public void addNewCopy(String location){
        UpdatableCopy updatableCopy = new UpdatableCopy();
        updatableCopy.addNewCopy(location);
    }
        
    public void updateCopy(String copyID, String location){
        UpdatableCopy updatableCopy = new UpdatableCopy();
        updatableCopy.updateCopy(copyID, location);
    }
    
    public HashMap getCopyDetails(String copyID){
        UpdatableCopy updatableCopy = new UpdatableCopy();
        return updatableCopy.getCopyDetails(copyID);
    }
    
    public void deleteCopy(String copyID){
        UpdatableCopy updatableCopy = new UpdatableCopy();
        updatableCopy.deleteCopy(copyID);
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
