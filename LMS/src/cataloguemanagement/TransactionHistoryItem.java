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
public class TransactionHistoryItem {
    
    private Date dateBorrowed;
    private Date dateReturned;
    private Date dateToReturn;
    private double fineAmount;
    private int numOfExtend;
    private Displayable item;
    
    public final static int MAX_EXTEND = 3;
    
    public TransactionHistoryItem() {
        
        
        
    }
    
    public static TransactionHistoryItem getTransactionHistoryItem (String loanID) {
        
        DataStore dataStore = new DataStore();
        return dataStore.getRecord(loanID);
        
    }
    
    public Date getDateBorrowed() {
        
        return this.dateBorrowed;
        
    }
    
    public void setDateBorrowed(Date dateBorrowed) {
        
        this.dateBorrowed = dateBorrowed;
        
    }
    
    public Date getDateReturned() {
        
        return this.dateReturned;
        
    }
    
    public void setDateReturned(Date dateReturned) {
        
        this.dateReturned = dateReturned;
        
    }
    
    public Date getDateToReturn() {
        
        return this.dateToReturn;
        
    }
    
    public void setDateToReturn(Date dateToReturn) {
        
        this.dateToReturn = dateToReturn;
        
    }
    
    public double getFineAmount() {
        
        return this.fineAmount;
        
    }
    
    public void setFineAmount(double fineAmount) {
        
        this.fineAmount = fineAmount;
        
    }
    
    public int getNumOfExtend() {
        
        return this.numOfExtend;
        
    }
    
    public void setNumOfExtend(int numOfExtend) {
        
        this.numOfExtend = numOfExtend;
        
    }
    
    public Displayable getItem() {
        
        return this.item;
        
    }
    
    public void setItem(Displayable item) {
        
        this.item = item;
        
    }
    
}
