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
public class PastTransaction {
    
    private String loanID;
    private Calendar dateBorrowed;
    private Calendar dateReturned;
    private Calendar dateToReturn;
    private double fineAmount;
    private int numOfExtend;
    private Displayable copy;
    
    
    
    public PastTransaction() {
        
    }
    
    public Calendar getDateBorrowed() {
        
        return this.dateBorrowed;
        
    }
    
    public void setDateBorrowed(Calendar dateBorrowed) {
        
        this.dateBorrowed = dateBorrowed;
        
    }
    
    public Calendar getDateReturned() {
        
        return this.dateReturned;
        
    }
    
    public void setDateReturned(Calendar dateReturned) {
        
        this.dateReturned = dateReturned;
        
    }
    
    public Calendar getDateToReturn() {
        
        return this.dateToReturn;
        
    }
    
    public void setDateToReturn(Calendar dateToReturn) {
        
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
    
    public Displayable getCopy() {
        
        return this.copy;
        
    }
    
    public void setCopy(Displayable copy) {
        
        this.copy = copy;
        
    }
    
    public String getLoanID() {
        
        return loanID;
        
    }
    
    public void setLoanID(String loanID) {
        
        this.loanID = loanID;
        
    }
    
}
