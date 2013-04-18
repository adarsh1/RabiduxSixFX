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
    /**
     *
     */
    public static final int LIBRARIAN = 0;  
    /**
     *
     */
    public static final int STUDENT = 1;
    /**
     *
     */
    public static final int FACULTY = 2;   

    
    /**
     *
     */
    public User(){
        
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws IncorrectPasswordException
     */
    
    public static User getUserByName(String username) throws SQLException, ClassNotFoundException, UserNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isValidUsername(username)) {
            
            throw new UserNotFoundException("User name does not exsit!");
            
        }
        
        return dataStore.getUserByName(username);
        
    }
    
    public static User getUser(String username, String password) throws SQLException, ClassNotFoundException, UserNotFoundException, IncorrectPasswordException {
        
        DataStore dataStore = new DataStore();
        
        if (!dataStore.isValidUsername(username)) {
            
            throw new UserNotFoundException("User name does not exsit!");
            
        }
        
        if (!dataStore.isValidUserPassword(username, password)) {
            
            throw new IncorrectPasswordException("Password is not correct!");
            
        }
        
        return dataStore.getUserByName(username);
        
    }
    
        /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static User getUser(String userID) throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        
        return dataStore.getUser(userID);
        
    }
    
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean isSuspended() throws SQLException, ClassNotFoundException {
        
        DataStore dataStore = new DataStore();
        return dataStore.isUserSuspended(userID);
        
    }
    
    /**
     *
     * @return
     */
    public String getUserID() {
        
        return userID;
        
    }

    /**
     *
     * @param userID
     */
    public void setUserID(String userID) {
        
        this.userID = userID;
        
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        
        return username;
        
    }
    
    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        
        this.username = username;
        
    }
    
    /**
     *
     * @return
     */
    public int getUsertype() {
        
        return usertype;
        
    }
    
    /**
     *
     * @param usertype
     */
    public void setUsertype(int usertype) {
        
        this.usertype = usertype;
        
    }
    
    
}
