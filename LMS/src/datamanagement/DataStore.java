
package datamanagement;

import cataloguemanagement.*;
import java.sql.*;
import java.util.*;
import userManagement.User;

/**
 *
 * @author Allen
 */
public class DataStore {
        
    private Database database;
    
    public DataStore(){
        database = new MySQLDB();
    }
    
    public void insertItem(CatalogueItem catalogueItem) throws SQLException, ClassNotFoundException {
        
        ArrayList<String> itemValues = new ArrayList<> ();
        
        itemValues.add(database.getNewID(Database.Table.ITEM)); // itemID
        itemValues.add(catalogueItem.getTitle());               // book title
        itemValues.add(catalogueItem.getAuthor());              // book author
        
        if (catalogueItem.getType() == catalogueItem.BOOK) {
            
            itemValues.add(((Book)catalogueItem).getISBN());    // ISBN
            itemValues.add(((Book)catalogueItem).getGenre());   // Genre
            
        }
        
        itemValues.add(null);
        
        
        database.initializeConnection();
        
        database.insertRecord(Database.Table.ITEM, itemValues);
        
        database.closeConnection();
       
    }
    
    
    //check if the item id exists in the database
    public Boolean isValidItemID(String itemID) throws SQLException, ClassNotFoundException{
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(itemID);
        ResultSet resultSet = database.selectRecord(Database.Table.ITEM, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public Boolean isValidUserID(String userID) throws SQLException, ClassNotFoundException{
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(userID);
        ResultSet resultSet = database.selectRecord(Database.Table.USER, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public Boolean isValidLoanID(String loanID) throws SQLException, ClassNotFoundException{
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(loanID);
        ResultSet resultSet = database.selectRecord(Database.Table.USER, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public Boolean isValidCopyID(String copyID) throws SQLException, ClassNotFoundException{
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(copyID);
        ResultSet resultSet = database.selectRecord(Database.Table.USER, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }

}
