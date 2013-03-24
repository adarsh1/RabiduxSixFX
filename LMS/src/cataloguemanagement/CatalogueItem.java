/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;
import datamanagement.*;
import java.sql.SQLException;

/**
 *
 * @author Allen
 */
public class CatalogueItem {
    
    //data field common to all catalogue items
    private String itemID;
    private String location;
    private String author;
    private String title;
    
    //final constant to indicate the type of this item
    public static final int BOOK = 0;
    
    public CatalogueItem(String itemID){
        this.itemID = itemID;
    }
    
    //check if the itemID is valid
    public static boolean isValidItem(String itemID) throws SQLException, ClassNotFoundException{
        DataStore dataStore = new DataStore();
        return dataStore.isValidItemID(itemID);
    }
    
    public static CatalogueItem createItemByID(String itemID) throws SQLException, ClassNotFoundException{
        DataStore dataStore = new DataStore();
        dataStore.updateItemInfo(itemID);
        //if this item is of book type
        if (dataStore.getType() == BOOK){
            //instantiate a new book object
            Book book = new Book(itemID);
            //set all mandatory fields
            book.setAuthor(dataStore.getAuthor());
            book.setGenre(dataStore.getGenre());
            book.setISBN(dataStore.getISBN());
            book.setLocation(dataStore.getLocation());
            book.setTitle(dataStore.getTitle());
            
            //return this object as a catalogue item type
            return (CatalogueItem)book;
        }        
        else{
            CatalogueItem catalogueItem = new CatalogueItem(itemID);
            catalogueItem.setAuthor(dataStore.getAuthor());
            catalogueItem.setLocation(dataStore.getLocation());
            catalogueItem.setTitle(dataStore.getTitle());
            return catalogueItem;
        }
        
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
