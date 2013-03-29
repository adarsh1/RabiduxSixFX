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
    private ArrayList<Reservable> items;
    
    public ReservableCopyGroup(String itemID) {
        
        
        
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
    
}
