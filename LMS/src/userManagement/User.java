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
    
    //constant field to indicate the type of this user
    public static final int LIBRARIAN = 0;  
    public static final int STUDENT = 1;
    public static final int FACULTY = 2;    
    public static final int STUDENT_MAX_BORROWING = 2;
    public static final int FACULTY_MAX_BORROWING = 3;
    
    
    public User(String userID){
        this.userID = userID;
    }
    /*
    //validate the user
    public static boolean isValidUser(String userID, String password) throws SQLException, ClassNotFoundException{
        DataStore dataStore = new DataStore();
        return dataStore.isValidUser(userID,password);
    }
    
    public static User getUser(String userID) throws SQLException, ClassNotFoundException{
        DataStore dataStore = new DataStore();
        dataStore.updateUserInfo(userID);
        //if it'a student's ID
        if (dataStore.getUserType() == User.STUDENT){
            Student student = new Student(userID);
            //set all mandatory fields
            student.setAccountName(dataStore.getAccountName());
            student.setNumberOfItemsBorrowed(dataStore.getNumberOfItemsBorrowed());
            student.setFine(dataStore.getFineAmount());            
            //return this object as user type
            return (User)student;
        }
        
        //if it's a faculty's ID
        else if (dataStore.getUserType() == User.FACULTY){
            Faculty faculty = new Faculty(userID);
            //set all mandatory fields
            faculty.setAccountName(dataStore.getAccountName());
            faculty.setNumberOfItemsBorrowed(dataStore.getNumberOfItemsBorrowed());
            faculty.setFine(dataStore.getFineAmount());            
            //return this object as user type
            return (User)faculty;
        }
        
        //if it's a librarian
        else{
            Librarian librarian = new Librarian(userID);
            //set all mandatory fields
            librarian.setAccountName(dataStore.getAccountName());            
            //return this object as user type
            return (User)librarian;
        }        
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    
}
