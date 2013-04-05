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
        
        return itemID;
        
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

    public String getTitle() {
        
        return copies.get(0).getTitle();
        
    }

    public String getAuthor() {
        
        return copies.get(0).getAuthor();
    
    }

}
