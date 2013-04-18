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
public abstract class CatalogueCopy implements Displayable {
    
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
    /**
     *
     */
    public static final int BOOK = 0;
    

    /**
     *
     */
    public CatalogueCopy(){
        
    }
    
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static CatalogueCopy getCatalogueCopy (String copyID) throws SQLException, ClassNotFoundException {
        
        DataStore datastore = new DataStore();
        return datastore.getCopy(copyID);
        
    }
    
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Boolean isValidCopy(String copyID) throws SQLException, ClassNotFoundException{
        
        DataStore dataStore = new DataStore();
        return dataStore.isValidCopyID(copyID);
        
    }
    
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Boolean isOverdue() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        return dataStore.isCopyOverdue(individualCopyID);
        
    }
    
    @Override
    public String getItemID() {
        
        return itemID;
        
    }

    /**
     *
     * @param itemID
     */
    public void setItemID(String itemID) {
        
        this.itemID = itemID;
        
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        
        return location;
        
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        
        this.location = location;
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getAuthor() {
        
        return author;
        
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        
        this.author = author;
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        
        return title;
        
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        
        this.title = title;
        
    }
    
    /**
     *
     * @return
     */
    public int getType() {
        
        return type;
        
    }
    
    /**
     *
     * @param type
     */
    public void setType(int type) {
        
        this.type = type;
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public Calendar getPublishDate() {
        
        return this.publishDate;
        
    }
    
    /**
     *
     * @param date
     */
    public void setPublishDate(Calendar date) {
        
        this.publishDate = date;
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getIndividualCopyID() {
        
        return this.individualCopyID;
        
    }
    
    /**
     *
     * @param copyID
     */
    public void setIndividualCopyID(String copyID) {
        
        this.individualCopyID = copyID;
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getDescription() {
        
        return this.description;
        
    }
    
    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        
        this.description = description;
        
    }

    /**
     *
     * @return
     */
    @Override
    public String getISBN() {
        
        return null;
        
    }

    /**
     *
     * @return
     */
    @Override
    public String getGenre() {
        
        return null;
        
    }
    
}
