
package updatecatalogue;

import cataloguemanagement.*;
import datamanagement.Table;
import exception.CopyNotFoundException;
import exception.InvalidItemTypeException;
import exception.ItemNotFoundException;
import exception.NullResultException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import usermanagement.Librarian;

/**
 *
 * @author Richard
 */
public class UpdateMgr {
    
    private Librarian currentLibrarian;
    
    /**
     *
     * @param currentLibrarian
     */
    public UpdateMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    /**
     *
     */
    public UpdateMgr(){
        //empty constructor
    }
    
    /**
     *
     * @param title
     * @param author
     * @param publishDate
     * @param description
     * @param ISBN
     * @param genre
     * @throws ItemNotFoundException
     */
    public void addNewBook(String title, String author, Calendar publishDate, String description, String ISBN, String genre) throws ItemNotFoundException, SQLException, ClassNotFoundException, InvalidItemTypeException{
        
        ItemUpdatable itemUpdatable = new Book();
        HashMap<String, Object> hashMap = new HashMap<> ();
        
        hashMap.put(Table.BOOK_TITLE, title);
        hashMap.put(Table.BOOK_AUTHOR, author);
        hashMap.put(Table.BOOK_DATE, publishDate);
        hashMap.put(Table.BOOK_DESCRIPTION, description);
        hashMap.put(Table.BOOK_ISBN, ISBN);
        hashMap.put(Table.BOOK_GENRE, genre);
        
        itemUpdatable.addNewItem(hashMap);
        
//        UpdatableBook updatableBook = new UpdatableBook();
//        updatableBook.updateBook(genre, title, author, description, publishDate, ISBN, genre);
        
    }
    
    /**
     *
     * @param itemID
     * @param title
     * @param author
     * @param publishDate
     * @param description
     * @param ISBN
     * @param genre
     * @throws ItemNotFoundException
     */
    public void updateBook(String itemID, String title, String author, Calendar publishDate, String description, String ISBN, String genre) throws ItemNotFoundException, SQLException, ClassNotFoundException, InvalidItemTypeException{
        
        ItemUpdatable itemUpdatable = new Book();
        HashMap<String, Object> hashMap = new HashMap<> ();
        
        hashMap.put(Table.BOOK_BOOK_ID, itemID);
        hashMap.put(Table.BOOK_TITLE, title);
        hashMap.put(Table.BOOK_AUTHOR, author);
        hashMap.put(Table.BOOK_DATE, publishDate);
        hashMap.put(Table.BOOK_DESCRIPTION, description);
        hashMap.put(Table.BOOK_ISBN, ISBN);
        hashMap.put(Table.BOOK_GENRE, genre);
        
        itemUpdatable.updateItem(hashMap);
        
//        UpdatableBook updatableBook = new UpdatableBook();     
//        updatableBook.updateBook(itemID, title, author, description, publishDate, ISBN, genre);
    }
    
    /**
     *
     * @param itemID
     * @return
     * @throws ItemNotFoundException
     */
    public HashMap getItemInfo(String itemID) throws ItemNotFoundException, SQLException, ClassNotFoundException, NullResultException, InvalidItemTypeException{
        
        ItemUpdatable itemUpdatable = new Book();
        HashMap<String, Object> hashMap;
        
        hashMap = itemUpdatable.getItem(itemID);
        
        return hashMap;
        
//        UpdatableBook updatableBook = new UpdatableBook(); 
//        return updatableBook.getBookDetails(itemID);
    }
    
    /**
     *
     * @param itemID
     * @throws ItemNotFoundException
     */
    public void deleteBook(String itemID) throws ItemNotFoundException, SQLException, ClassNotFoundException, InvalidItemTypeException{
        
        ItemUpdatable itemUpdatable = new Book();
        
        itemUpdatable.deleteItem(itemID);
        
//        UpdatableBook updatableBook = new UpdatableBook(); 
//        updatableBook.deleteBook(itemID);
    }
    
    /**
     *
     * @param location
     */
    public void addNewCopy(String itemID, String location) throws SQLException, ClassNotFoundException{
        
        CopyUpdatable copyUpdatable = new Book();
        HashMap<String, Object> hashMap = new HashMap<> ();
        
        hashMap.put(Table.COPY_ITEM_ID, itemID);
        hashMap.put(Table.COPY_LOCATION, location);
        
        copyUpdatable.addNewCopy(hashMap);
        
//        UpdatableCopy updatableCopy = new UpdatableCopy();
//        updatableCopy.addNewCopy(location);
    }
        
    /**
     *
     * @param copyID
     * @param location
     * @throws ItemNotFoundException
     */
    public void updateCopy(String copyID, String location) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException{
        
        CopyUpdatable copyUpdatable = new Book();
        HashMap<String, Object> hashMap = new HashMap<> ();
        
        hashMap.put(Table.COPY_COPY_ID, copyID);
        hashMap.put(Table.COPY_LOCATION, location);
        
        copyUpdatable.updateCopy(hashMap);
        
//        UpdatableCopy updatableCopy = new UpdatableCopy();
//        updatableCopy.updateCopy(copyID, location);
    }
    
    /**
     *
     * @param copyID
     * @return
     * @throws ItemNotFoundException
     */
    public HashMap getCopyDetails(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException{
        
        CopyUpdatable copyUpdatable = new Book();
        HashMap<String, Object> hashMap;
        
        hashMap = copyUpdatable.getCopy(copyID);
        
        return hashMap;
        
//        UpdatableCopy updatableCopy = new UpdatableCopy();
//        return updatableCopy.getCopyDetails(copyID);
    }
    
    /**
     *
     * @param copyID
     * @throws ItemNotFoundException
     */
    public void deleteCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException{
        
        CopyUpdatable copyUpdatable = new Book();
        
        copyUpdatable.deleteCopy(copyID);
        
//        UpdatableCopy updatableCopy = new UpdatableCopy();
//        updatableCopy.deleteCopy(copyID);

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

}
