/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import datamanagement.DataStore;
import exception.UserNotFoundException;
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
    
    public static User getUser(String accountName) throws SQLException, ClassNotFoundException, UserNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isValidUserName(accountName)) {
            
            throw new UserNotFoundException("User name does not exsit!");
            
        }
        
        return dataStore.getUser(accountName);
        
    }
    
    public boolean validate(String password) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isValidUserPassword(userID, password);
        
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
