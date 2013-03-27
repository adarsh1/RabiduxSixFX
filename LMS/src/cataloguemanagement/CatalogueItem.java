/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.DataStore;
import java.sql.SQLException;
import java.util.*;

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
    private int type;
    private String individualCopyID;
    private Date publishDate;
    
    //final constant to indicate the type of this item
    public static final int BOOK = 0;
    

    public CatalogueItem(String copyID){
        
        this.individualCopyID = copyID;
        
    }
    
    public static CatalogueItem getCatalogueItem (String copyID) throws SQLException, ClassNotFoundException {
        
        DataStore datastore = new DataStore();
        return datastore.getCopy(copyID);
        
    }
    
    //check if the itemID is valid
    public static boolean isValidItem(String itemID) throws SQLException, ClassNotFoundException{
        DataStore dataStore = new DataStore();
        return dataStore.isValidItemID(itemID);
    }
    
    /*
    public static CatalogueItem createItemByID(String itemID) throws SQLException, ClassNotFoundException{
        DataStore dataStore = new DataStore();
        dataStore.updateItemInfo(itemID);
        //if this item is of book type
        if (dataStore.getItemType() == BOOK){
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
            //if it belongs to no specific type
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
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public Date getPublishDate() {
        return this.publishDate;
    }
    
    public void setPublishDate(Date date) {
        this.publishDate = date;
    }
    
    public String getIndividualCopyID() {
        return this.individualCopyID;
    }
    
    public void setIndividualCopyID(String copyID) {
        this.individualCopyID = copyID;
    }
    
}
