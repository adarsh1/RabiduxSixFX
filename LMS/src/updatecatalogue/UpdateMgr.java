
package updatecatalogue;

import cataloguemanagement.Book;
import cataloguemanagement.UpdatableCopy;
import cataloguemanagement.UpdatableItem;
import exception.ItemExistException;
import java.util.Calendar;
import usermanagement.Librarian;

/**
 *
 * @author Richard
 */
public class UpdateMgr {
    
    private Librarian currentLibrarian;
    private UpdatableItem updatableItem;
    private UpdatableCopy updatableCopy;    
    
    public UpdateMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    public UpdateMgr(){
        //empty constructor
    }
    
    public void addNewBook(String title, String author, Calendar publishDate, String Description, String ISBN, String genre) throws ItemExistException{
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setDescription(Description);
        newBook.setPublishDate(publishDate);
        newBook.setISBN(ISBN);
        newBook.setGenre(genre);
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

    /**
     * @return the updatableItem
     */
    public UpdatableItem getUpdatableItem() {
        return updatableItem;
    }

    /**
     * @param updatableItem the updatableItem to set
     */
    public void setUpdatableItem(UpdatableItem updatableItem) {
        this.updatableItem = updatableItem;
    }

    /**
     * @return the updatableCopy
     */
    public UpdatableCopy getUpdatableCopy() {
        return updatableCopy;
    }

    /**
     * @param updatableCopy the updatableCopy to set
     */
    public void setUpdatableCopy(UpdatableCopy updatableCopy) {
        this.updatableCopy = updatableCopy;
    }
}
