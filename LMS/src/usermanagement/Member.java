/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedCopy;
import cataloguemanagement.PastTransaction;
import datamanagement.DataStore;
import exception.NullResultException;
import exception.UserNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mmin001
 */
public abstract class Member extends User implements BorrowRecordAccessible{
    
    private int maxHolding;
    private int maxReserve;
    private double fineAmount;
    
    //maximal number of holdings for student and staff
    /**
     *
     */
    public static final int STUDENT_MAX_HOLDING = 2;
    /**
     *
     */
    public static final int STUDENT_MAX_RESERVE = 2;
    /**
     *
     */
    public static final int FACULTY_MAX_HOLDING = 3;
    /**
     *
     */
    public static final int FACULTY_MAX_RESERVE = 3;
    //loan duration for student and faculty
    /**
     *
     */
    public static final int STUDENT_LOAN_DURATION = 7;
    /**
     *
     */
    public static final int FACULTY_LOAN_DURATION = 14;
    
    /**
     *
     */
    public Member(){
        
        super();
        
    }
    
   //all eligible methods may still require info about fine
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean isEligibleToBorrow() throws SQLException, ClassNotFoundException, UserNotFoundException{
        
        boolean result;
        
        if ( getNumOfBorrowedItem() < maxHolding ) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        return result;
        
    }
    
    public boolean isEligibleToReserve() throws SQLException, ClassNotFoundException, UserNotFoundException{
        
        boolean result;
        
        if ( getNumOfReservedItem() < maxReserve ) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        return result;
        
    }
    
    
    private int getNumOfBorrowedItem() throws SQLException, ClassNotFoundException, UserNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getNumOfBorrowing(super.getUserID());
        
    }
    
    private int getNumOfReservedItem() throws SQLException, ClassNotFoundException, UserNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getNumOfReserving(super.getUserID());
        
    }

    /**
     *
     * @return
     */
    public int getMaxHolding() {
        
        return maxHolding;
        
    }

    /**
     *
     * @param maxHolding
     */
    public void setMaxHolding(int maxHolding) {
        
        this.maxHolding = maxHolding;
        
    }
/**
     *
     * @param maxReserve
     */
    public void setMaxReserve(int maxReserve) {
        
        this.maxReserve = maxReserve;
        
    }
    /**
     *
     * @return
     */
    public double getFineAmount() {
        
        return this.fineAmount;
        
    }
    
    /**
     *
     * @param fineAmount
     */
    public void setFineAmount(double fineAmount) {
        
        this.fineAmount = fineAmount;
        
    }
    
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void resetFine() throws SQLException, ClassNotFoundException, UserNotFoundException, NullResultException {
        
        DataStore dataStore = new DataStore();
        dataStore.resetFine(super.getUserID());
        
    }
    
    /**
     *
     * @return
     */
    public abstract int getLoanDuration();

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ArrayList<PastTransaction> getPastTransactions () throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        ArrayList<PastTransaction> A = dataStore.getRecords(super.getUserID());
        return A;
    }
    
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ArrayList<ReservedCopy> getReservedCopies() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.getReservedCopies(super.getUserID());
     
     }
    
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ArrayList<CurrentHolding> getCurrentHoldingItems() throws SQLException, ClassNotFoundException{
        
        DataStore dataStore = new DataStore();
        return dataStore.getCurrentHoldings(super.getUserID());
     
     }   
    
    

    

    
    
}
