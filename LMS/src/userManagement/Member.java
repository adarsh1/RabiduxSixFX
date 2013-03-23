/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import catalogue.Book;
import java.util.ArrayList;

/**
 *
 * @author mmin001
 */
public abstract class Member {
    private String memberID;
    private int maxBorrowing;
    private int itemBorrowed;
    private double fine;
    private String status;
    
    public Member(String memID){
        memberID=memID;
    }
    
   //all eligible methods may still require info about fine
    public boolean isEligibleToBorrowOrReserve(){
        if(itemBorrowed<maxBorrowing){
            return true;
        }else return false;
    }
    
    public boolean isEligibleToExtend(){
        return true;
        
    }
    
    abstract public ArrayList<Book> getBorrowed();

    
    
    abstract public ArrayList<Book> getReserved();
        
    
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String st){
        status=st;
    }
}
