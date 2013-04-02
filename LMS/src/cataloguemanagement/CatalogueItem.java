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
public class CatalogueItem implements Displayable {
    
    //data field common to all catalogue items
    private String itemID;
    private String location;
    private String author;
    private String title;
    private int type;
    private String individualCopyID;
    private Calendar publishDate;
    private String description;
    
    //final constant to indicate the type of this item
    public static final int BOOK = 0;
    

    public CatalogueItem(){
        
    }
    
    public static CatalogueItem getCatalogueItem (String copyID) throws SQLException, ClassNotFoundException {
        
        DataStore datastore = new DataStore();
        return datastore.getCopy(copyID);
        
    }
    
    public static Boolean isValidCopy(String copyID) throws SQLException, ClassNotFoundException{
        
        DataStore dataStore = new DataStore();
        return dataStore.isValidCopyID(copyID);
        
    }
    
    public Boolean isAvailable() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        return dataStore.isCopyAvailable(individualCopyID);
        
    }
    
    public Boolean isOverdue() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        return dataStore.isCopyOverdue(individualCopyID);
        
    }
    
    public Boolean isReserved() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        return dataStore.isCopyReserved(individualCopyID);
        
    }
    
    public String getItemID() {
        
        return itemID;
        
    }

    public void setItemID(String itemID) {
        
        this.itemID = itemID;
        
    }

    public String getLocation() {
        
        return location;
        
    }

    public void setLocation(String location) {
        
        this.location = location;
        
    }

    public String getAuthor() {
        
        return author;
        
    }

    public void setAuthor(String author) {
        
        this.author = author;
        
    }

    public String getTitle() {
        
        return title;
        
    }

    public void setTitle(String title) {
        
        this.title = title;
        
    }
    
    public int getType() {
        
        return type;
        
    }
    
    public void setType(int type) {
        
        this.type = type;
        
    }
    
    public Calendar getPublishDate() {
        
        return this.publishDate;
        
    }
    
    public void setPublishDate(Calendar date) {
        
        this.publishDate = date;
        
    }
    
    public String getIndividualCopyID() {
        
        return this.individualCopyID;
        
    }
    
    public void setIndividualCopyID(String copyID) {
        
        this.individualCopyID = copyID;
        
    }
    
    public String getDescription() {
        
        return this.description;
        
    }
    
    public void setDescription(String description) {
        
        this.description = description;
        
    }

    @Override
    public String getTitleDisplay() {
        
        return getTitle();
        
    }

    @Override
    public String getDescriptionDisplay() {
        
        return getDescription();
        
    }

    @Override
    public String getAuthorDisplay() {
        
        return getAuthor();
        
    }

    @Override
    public String getPublishYearDisplay() {
        
        Calendar calendar = getPublishDate();
        return Integer.toString(calendar.get(Calendar.YEAR)) + "-" + Integer.toString(calendar.get(Calendar.MONTH)) + "-" + Integer.toString(calendar.get(Calendar.DATE));
        
    }

    @Override
    public String getItemIDDisplay() {
        
        return getItemID();
        
    }
    
}
