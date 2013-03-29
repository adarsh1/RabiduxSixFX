/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.*;
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
        
        
        
    }
    
    public static ReservableCopyGroup getReservableCopyGroup (String searchCriteria, String keyword) {
        
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
    
}
