/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.*;

/**
 *
 * @author Richard
 */
public class CurrentHolding {
    
    private String loanID;
    private Calendar dateBorrowed;
    private Calendar dateToReturn;
    private double fine;
    private int numOfExtend;
    private Extendable copy;
    
    /**
     *
     */
    public CurrentHolding() {
        
    }
    
    /**
     *
     * @return
     */
    public String getLoanID() {
        
        return this.loanID;
        
    }
    
    /**
     *
     * @param loanID
     */
    public void setLoanID(String loanID) {
        
        this.loanID = loanID;
        
    }
    
    /**
     *
     * @return
     */
    public Calendar getDateBorrowed() {
        
        return this.dateBorrowed;
        
    }
    
    /**
     *
     * @param dateBorrowed
     */
    public void setDateBorrowed(Calendar dateBorrowed) {
        
        this.dateBorrowed = dateBorrowed;
        
    }
    
    /**
     *
     * @return
     */
    public Calendar getDateToReturn() {
        
        return this.dateToReturn;
        
    }
    
    /**
     *
     * @param dateToReturn
     */
    public void setDateToReturn(Calendar dateToReturn) {
        
        this.dateToReturn = dateToReturn;
        
    }
    
    /**
     *
     * @return
     */
    public double getFine() {
        
        return this.fine;
        
    }
    
    /**
     *
     * @param fine
     */
    public void setFine(double fine) {
        
        this.fine = fine;
        
    }
    
    /**
     *
     * @return
     */
    public int getNumOfExtend() {
        
        return this.numOfExtend;
        
    }
    
    /**
     *
     * @param numOfExtend
     */
    public void setNumOfExtend(int numOfExtend) {
        
        this.numOfExtend = numOfExtend;
        
    }
    
    /**
     *
     * @return
     */
    public Extendable getCopy(){
        
       return copy;
       
    }
   
    /**
     *
     * @param copy
     */
    public void setCopy(Extendable copy){
        
       this.copy = copy;
       
    }
    
}
