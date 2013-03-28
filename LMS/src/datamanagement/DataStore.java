
package datamanagement;

import cataloguemanagement.*;
import java.sql.*;
import java.text.DateFormat;
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
        
        
        database.initializeConnection();
        
        
        database.closeConnection();
       
    }
    
    public CatalogueItem getCopy(String copyID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        CatalogueItem catalogueItem = null;
        
        where.add(copyID);
        where.add("%");
        where.add("%");
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Database.Table.COPY, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String itemID = resultSet.getString("item_id");
        
        if (isValidBookID(itemID)) {
            
            catalogueItem = new Book();
            
            catalogueItem.setIndividualCopyID(copyID);
            catalogueItem.setType(CatalogueItem.BOOK);
            catalogueItem.setItemID(itemID);
            catalogueItem.setLocation(resultSet.getString("location"));
            
            where.clear();
            where.add(itemID);
            
            resultSet = database.selectRecord(Database.Table.ITEM, where);
            resultSet.next();
            
            catalogueItem.setTitle(resultSet.getString("title"));
            catalogueItem.setAuthor(resultSet.getString("author"));
            catalogueItem.setPublishDate(resultSet.getTimestamp("date"));
            ((Book)catalogueItem).setISBN(resultSet.getString("isbn"));
            ((Book)catalogueItem).setGenre(resultSet.getString("genre"));
            
        }
        
        database.closeConnection();
        
        return catalogueItem;
        
    }
    
    public Boolean isCopyAvailable(String copyID) throws SQLException, ClassNotFoundException {
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add("%");
        condition.add("%");
        condition.add(copyID);
        
        ResultSet resultSet = database.selectRecord(Database.Table.RECORD, condition, 1);
        resultSet.next();
        
        if (resultSet.getString("time_returned").compareTo("") == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public Boolean isCopyOverdue(String copyID) throws SQLException, ClassNotFoundException {
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add("%");
        condition.add("%");
        condition.add(copyID);
        
        ResultSet resultSet = database.selectRecord(Database.Table.RECORD, condition, 1);
        resultSet.next();
        
        if (resultSet.getTimestamp("time_to_return").compareTo(new java.util.Date()) < 0) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public Boolean isCopyReserved(String copyID) throws SQLException, ClassNotFoundException {
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(copyID);
        condition.add("%");
        condition.add("%");
        
        ResultSet resultSet = database.selectRecord(Database.Table.RECORD, condition);
        resultSet.next();
        
        if (resultSet.getString("reserved_by").compareTo("") == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    //check if the item id exists in the database
    public Boolean isValidBookID(String bookID) throws SQLException, ClassNotFoundException{
        
        Boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(bookID);
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
