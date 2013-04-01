/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.*;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Richard
 */
public class ReservableCopyGroup {
    
    private int copiesAvailable;
    private String itemID;
    private String itemTitle;
    private String itemAuthor;
    private ArrayList<Reservable> copies;
    
    public ReservableCopyGroup() {
        
        copies = new ArrayList<> ();
        
    }
    
    public static ArrayList<ReservableCopyGroup> getReservableCopyGroups (String searchCriteria, String keyword) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getCopyGroups(searchCriteria, keyword);
        
    }
    
    public int getCopiesAvailable() {
        
        return this.copiesAvailable;
        
    }
    
    public void setCopiesAvailable(int copiesAvailable) {
        
        this.copiesAvailable = copiesAvailable;
        
    }
    
    public String getItemID() {
        
        return this.itemID;
        
    }
    
    public void setItemID(String itemID) {
        
        this.itemID = itemID;
        
    }
    
    public ArrayList<Reservable> getCopies() {
        
        return this.copies;
        
    }
    
    public void addCopy(Reservable copy) {
        
        copies.add(copy);
        
    }

    /**
     * @return the itemTitle
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * @param itemTitle the itemTitle to set
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    /**
     * @return the itemAuthor
     */
    public String getItemAuthor() {
        return itemAuthor;
    }

    /**
     * @param itemAuthor the itemAuthor to set
     */
    public void setItemAuthor(String itemAuthor) {
        this.itemAuthor = itemAuthor;
    }
}
