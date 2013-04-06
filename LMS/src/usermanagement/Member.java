/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedCopy;
import cataloguemanagement.PastTransaction;
import datamanagement.DataStore;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mmin001
 */
public abstract class Member extends User implements BorrowRecordAccessible{
    
    private int maxHolding;
    private double fineAmount;
    
    //maximal number of holdings for student and staff
    public static final int STUDENT_MAX_HOLDING = 2;
    public static final int FACULTY_MAX_HOLDING = 3;
    
    //loan duration for student and faculty
    public static final int STUDENT_LOAN_DURATION = 7;
    public static final int FACULTY_LOAN_DURATION = 14;
    
    public Member(){
        
        super();
        
    }
    
   //all eligible methods may still require info about fine
    public boolean isEligibleToBorrowOrReserve() throws SQLException, ClassNotFoundException{
        
        boolean result;
        
        if ( getNumOfBorrowedItem() + getNumOfReservedItem() < maxHolding ) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        return result;
        
    }
    
    private int getNumOfBorrowedItem() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getNumOfBorrowing(super.getUserID());
        
    }
    
    private int getNumOfReservedItem() throws SQLException, ClassNotFoundException {
        
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
    
    public abstract int getLoanDuration();

    @Override
    public ArrayList<PastTransaction> getPastTransactions () throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getRecords(super.getUserID());
        
    }
    
    @Override
    public ArrayList<ReservedCopy> getReservedCopies() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getReservedCopies(super.getUserID());
     
     }
    
    @Override
    public ArrayList<CurrentHolding> getCurrentHoldingItems() throws SQLException, ClassNotFoundException{
        
        DataStore dataStore = new DataStore();
        return dataStore.getCurrentHoldings(super.getUserID());
     
     }   
    
    

    

    
    
}
