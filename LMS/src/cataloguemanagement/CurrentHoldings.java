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
public class CurrentHoldings {
    
    private String loanID;
    private Calendar dateBorrowed;
    private Calendar dateToReturn;
    private double fine;
    private int numOfExtend;
    private Extendable copy;
    
    public CurrentHoldings() {
        
    }
    
    public String getLoanID() {
        
        return this.loanID;
        
    }
    
    public void setLoanID(String loanID) {
        
        this.loanID = loanID;
        
    }
    
    public Calendar getDateBorrowed() {
        
        return this.dateBorrowed;
        
    }
    
    public void setDateBorrowed(Calendar dateBorrowed) {
        
        this.dateBorrowed = dateBorrowed;
        
    }
    
    public Calendar getDateToReturn() {
        
        return this.dateToReturn;
        
    }
    
    public void setDateToReturn(Calendar dateToReturn) {
        
        this.dateToReturn = dateToReturn;
        
    }
    
    public double getFine() {
        
        return this.fine;
        
    }
    
    public void setFine(double fine) {
        
        this.fine = fine;
        
    }
    
    public int getNumOfExtend() {
        
        return this.numOfExtend;
        
    }
    
    public void setNumOfExtend(int numOfExtend) {
        
        this.numOfExtend = numOfExtend;
        
    }
    
    public Extendable getCopy(){
        
       return copy;
       
    }
   
    public void setCopy(Extendable copy){
        
       this.copy = copy;
       
    }
    
}
