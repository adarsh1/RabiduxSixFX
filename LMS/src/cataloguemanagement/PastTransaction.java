/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import datamanagement.*;
import usermanagement.*;
import java.sql.*;
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
    private Member member;
    
    
    
    /**
     *
     */
    public PastTransaction() {
        
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
    public Calendar getDateReturned() {
        
        return this.dateReturned;
        
    }
    
    /**
     *
     * @param dateReturned
     */
    public void setDateReturned(Calendar dateReturned) {
        
        this.dateReturned = dateReturned;
        
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
    public Displayable getCopy() {
        
        return this.copy;
        
    }
    
    /**
     *
     * @param copy
     */
    public void setCopy(Displayable copy) {
        
        this.copy = copy;
        
    }
    
    /**
     *
     * @return
     */
    public Member getMember() {
        
        return this.member;
        
    }
    
    /**
     *
     * @param member
     */
    public void setMember(Member member) {
        
        this.member = member;
        
    }
    
    /**
     *
     * @return
     */
    public String getLoanID() {
        
        return loanID;
        
    }
    
    /**
     *
     * @param loanID
     */
    public void setLoanID(String loanID) {
        
        this.loanID = loanID;
        
    }
    
}
