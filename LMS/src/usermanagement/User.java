/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import datamanagement.*;
import exception.*;
import java.sql.SQLException;

/**
 *
 * @author Allen
 */
public class User {
    
    private String userID;
    private String username;
    private int usertype;
    
    //constant field to indicate the type of this user
    public static final int LIBRARIAN = 0;  
    public static final int STUDENT = 1;
    public static final int FACULTY = 2;
    
    public User(){
        
    }
    
    public static User getUser(String username, String password) throws SQLException, ClassNotFoundException, UserNotFoundException, IncorrectPasswordException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isValidUsername(username)) {
            
            throw new UserNotFoundException("User name does not exsit!");
            
        }
        
        if (!dataStore.isValidUserPassword(username, password)) {
            
            throw new IncorrectPasswordException("Password is not correct!");
            
        }
        
        return dataStore.getUser(username);
        
    }
    
    public boolean isSuspended() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isUserSuspended(userID);
        
    }
    
    public String getUserID() {
        
        return userID;
        
    }

    public void setUserID(String userID) {
        
        this.userID = userID;
        
    }

    public String getUsername() {
        
        return username;
        
    }
    
    public void setUsername(String username) {
        
        this.username = username;
        
    }
    
    public int getUsertype() {
        
        return usertype;
        
    }
    
    public void setUsertype(int usertype) {
        
        this.usertype = usertype;
        
    }
    
    
}
