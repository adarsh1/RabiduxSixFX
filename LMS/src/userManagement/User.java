/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import datamanagement.DataStore;
import java.sql.SQLException;

/**
 *
 * @author Allen
 */
public class User {
    
    private String userID;
    private String accountName;
    private int usertype;
    
    //constant field to indicate the type of this user
    public static final int LIBRARIAN = 0;  
    public static final int STUDENT = 1;
    public static final int FACULTY = 2;
    
    public User(){
        
    }
    
    public static User getUser(String userID) {
        
        DataStore dataStore = new DataStore();
        return dataStore.getUser();
        
    }
    
    public static boolean isValidUser(String userID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        return dataStore.isValidUserID(userID);
        
    }
    
    public boolean isSuspended() {
        
        DataStore dataStore = new DataStore();
        return dataStore.isUserSuspended();
        
    }
    
    public String getUserID() {
        
        return userID;
        
    }

    public void setUserID(String userID) {
        
        this.userID = userID;
        
    }


    public String getAccountName() {
        
        return accountName;
        
    }

    
    public void setAccountName(String accountName) {
        
        this.accountName = accountName;
        
    }
    
    public int getUsertype() {
        
        return usertype;
        
    }
    
    public void setUsertype(int usertype) {
        
        this.usertype = usertype;
        
    }
    
    
}
