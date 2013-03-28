/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedItem;
import cataloguemanagement.TransactionHistoryItem;
import datamanagement.DataStore;
import java.util.ArrayList;

/**
 *
 * @author mmin001
 */
public class Member extends User implements BorrowRecordAccessible{
    
    private int maxHolding;
    private double fineAmount;
    
    private static final int STUDENT_MAX_HOLDING = 2;
    private static final int FACULTY_MAX_HOLDING = 3;
    
    public Member(String userID){
        
        super();
        
    }
    
   //all eligible methods may still require info about fine
    public boolean isEligibleToBorrowOrReserve(){
        
        boolean result;
        
        if ( getNumOfBorrowedItem() + getNumOfReservedItem() < maxHolding ) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        return result;
        
    }
    
    private int getNumOfBorrowedItem() {
        
        DataStore dataStore = new DataStore();
        return dataStore.getNumOfBorrowing(super.getUserID());
        
    }
    
    private int getNumOfReservedItem() {
        
        DataStore dataStore = new DataStore();
        return dataStore.getNumOfReserving(super.getUserID());
        
    }

    public int getMaxHolding() {
        
        return maxHolding;
        
    }

    public void setMaxHolding(int maxHolding) {
        
        this.maxHolding = maxHolding;
        
    }

    public double getFineAmount() {
        
        return this.fineAmount;
        
    }
    
    public void setFineAmount(double fineAmount) {
        
        this.fineAmount = fineAmount;
        
    }

    @Override
     public  ArrayList<TransactionHistoryItem> getTransactionHistoryItems(String memberID){
     return new ArrayList<TransactionHistoryItem>();
     }
    @Override
    public ArrayList<ReservedItem> getReservedItems(String memberID){
     return new ArrayList<ReservedItem>();
     }
    @Override
    public ArrayList<CurrentHolding> getCurrentHoldingItems(String memberID){
     return new ArrayList<CurrentHolding>();
     }   

    

    
    
}
