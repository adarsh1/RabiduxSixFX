
package datamanagement;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Allen
 */
public abstract class Database {
    //initialize the connection to the database
    public abstract void initializeConnection () throws SQLException,ClassNotFoundException;
    
    //close the connection to the database
    public abstract void closeConnection() throws SQLException;
    
    //fetch the title of an item
    public abstract String fechTitle() throws SQLException;
    
    //fetch the author of an item
    public abstract String fetchAuthor() throws SQLException;
    
    //fetch the year published
    public abstract String fetchPublishYear() throws SQLException;
    
    //fech the ISBN of a book
    public abstract String fetchISBN() throws SQLException;
    
    //fetch the genre of a book
    public abstract String fetchGenre() throws SQLException;
    
    //check if an itemID exists in DB
    public abstract boolean isValidItemID(String itemID) throws SQLException;
    
    //get all the info of a particular type of item
    public abstract ResultSet getItemInfo(String itemID) throws SQLException;
}
