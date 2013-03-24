/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import cataloguemanagement.Book;
import java.util.ArrayList;

/**
 *
 * @author mmin001
 */
public class Member extends User implements BorrowRecordAccessible{
    private int maxBorrowing;
    private int numberOfItemsBorrowed;
    private double fine;
    
    public Member(String userID){
        super(userID);
    }
    
   //all eligible methods may still require info about fine
    public boolean isEligibleToBorrowOrReserve(){
        if(numberOfItemsBorrowed <maxBorrowing ){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isEligibleToExtend(){
        return true;        
    }
    

    /**
     * @return the maxBorrowing
     */
    public int getMaxBorrowing() {
        return maxBorrowing;
    }

    /**
     * @param maxBorrowing the maxBorrowing to set
     */
    public void setMaxBorrowing(int maxBorrowing) {
        this.maxBorrowing = maxBorrowing;
    }

    /**
     * @return the fine
     */
    public double getFine() {
        return fine;
    }

    /**
     * @param fine the fine to set
     */
    public void setFine(double fine) {
        this.fine = fine;
    }

    /**
     * @return the numberOfItemsBorrowed
     */
    public int getNumberOfItemsBorrowed() {
        return numberOfItemsBorrowed;
    }

    /**
     * @param numberOfItemsBorrowed the numberOfItemsBorrowed to set
     */
    public void setNumberOfItemsBorrowed(int numberOfItemsBorrowed) {
        this.numberOfItemsBorrowed = numberOfItemsBorrowed;
    }
        
    }
