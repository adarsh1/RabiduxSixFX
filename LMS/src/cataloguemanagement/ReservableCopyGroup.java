/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.*;
import exception.CopyNotFoundException;
import exception.InvalidKeywordException;
import exception.ItemNotFoundException;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Richard
 */
public class ReservableCopyGroup {
    
    private int copiesAvailable;
    private String itemID;
    private ArrayList<Reservable> copies;
    
    /**
     *
     */
    public ReservableCopyGroup() {
        
        copies = new ArrayList<> ();
        
    }
    
    /**
     *
     * @param itemID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ReservableCopyGroup getReservableCopyGroup (String itemID) throws SQLException, ClassNotFoundException, ItemNotFoundException, CopyNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getCopyGroup(itemID);
        
    }
    
    /**
     *
     * @param searchCriteria
     * @param keyword
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ArrayList<ReservableCopyGroup> getReservableCopyGroups (String searchCriteria, String keyword) throws SQLException, ClassNotFoundException, InvalidKeywordException, CopyNotFoundException, ItemNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getCopyGroups(searchCriteria, keyword);
        
    }
    
    /**
     *
     * @return
     */
    public int getCopiesAvailable() {
        
        return this.copiesAvailable;
        
    }
    
    /**
     *
     * @param copiesAvailable
     */
    public void setCopiesAvailable(int copiesAvailable) {
        
        this.copiesAvailable = copiesAvailable;
        
    }
    
    /**
     *
     * @return
     */
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
    public ArrayList<Reservable> getCopies() {
        
        return this.copies;
        
    }
    
    /**
     *
     * @param copy
     */
    public void addCopy(Reservable copy) {
        
        copies.add(copy);
        
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        
        return copies.get(0).getTitle();
        
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        
        return copies.get(0).getAuthor();
    
    }
    
    /**
     *
     * @return
     */
    public String getDescription() {
        
        return copies.get(0).getDescription();
        
    }
    
    /**
     *
     * @return
     */
    public Calendar getPublishDate() {
        
        return copies.get(0).getPublishDate();
        
    }
    
    /**
     *
     * @return
     */
    public String getISBN() {
        
        return copies.get(0).getISBN();
        
    }
    
    /**
     *
     * @return
     */
    public String getGenre() {
        
        return copies.get(0).getGenre();
        
    }

}
