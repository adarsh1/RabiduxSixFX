
package datamanagement;

import cataloguemanagement.CatalogueItem;
import java.sql.*;
import userManagement.User;

/**
 *
 * @author Allen
 */
public class DataStore {
        
    private Database database;
    
    //catalogue item fields that may be retrieved from databasee
    private String location;
    private String author;
    private String title;
    private String ISBN;
    private String publishYear;
    private String genre;
    private int itemType;
    
    //user fields that may be retrieved from database
    private String accountName;
    private int numberOfItemsBorrowed;
    private double fineAmount;
    private int userType;
    
    public DataStore(){
        database = new MySQLDB();
    }
    
    //check if the item id exists in the database
    public boolean isValidItemID(String itemID) throws SQLException, ClassNotFoundException{
        //initialize DB connection
        database.initializeConnection();
        boolean result = database.isValidItemID(itemID);
        //close connection
        database.closeConnection();
        return result;
    }
    
    public void updateItemInfo(String itemID) throws SQLException, ClassNotFoundException{
        //initialize DB connection
        database.initializeConnection();
        //retrieve the result from DB
        ResultSet resultSet = database.getItemInfo(itemID);
        //update all relevant fields
        title = resultSet.getString("title");
        author = resultSet.getString("author");
        location = resultSet.getString("location");
        publishYear = resultSet.getString("publish_year");        
        itemType = resultSet.getInt("itemType");
        
        //if it's of book itemType
        if (getItemType() == CatalogueItem.BOOK){
            //update ISBN and genre as well
            ISBN = resultSet.getString("ISBN");
            genre = resultSet.getString("genre");
        }
        //close connection
        database.closeConnection();        
    }
    
    public void updateUserInfo(String userID) throws SQLException, ClassNotFoundException{
        //initialize DB connection
        database.initializeConnection();
        //retrive the user info from DB
        ResultSet resultSet = database.getUserInfo(userID);
        //update all relevant fields from the user table
        accountName = resultSet.getString("account_name");
        fineAmount = resultSet.getDouble("fine_amount");
        
        //if it's a member
        if (resultSet.getInt("type") == User.STUDENT || resultSet.getInt("type") == User.FACULTY){
            //retrieve the number of borrowings from DB
            resultSet = database.getCurrentHoldingItem(userID);
            numberOfItemsBorrowed = database.getNumberOfRows(resultSet);
        }
        else{   //if it's a librarian's ID
            //nothing for now
        }        
    }
    
    public boolean isValidUser(String userID, String password) throws SQLException, ClassNotFoundException{
        //initialize DB connection
        database.initializeConnection();
        boolean result = database.isValidUser(userID, password);
        //close connection
        database.closeConnection();   
        return result;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @return the publishYear
     */
    public String getPublishYear() {
        return publishYear;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the itemType
     */
    public int getItemType() {
        return itemType;
    }

    /**
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @return the numberOfItemsBorrowed
     */
    public int getNumberOfItemsBorrowed() {
        return numberOfItemsBorrowed;
    }

    /**
     * @return the fineAmount
     */
    public double getFineAmount() {
        return fineAmount;
    }

    /**
     * @return the userType
     */
    public int getUserType() {
        return userType;
    }
}
