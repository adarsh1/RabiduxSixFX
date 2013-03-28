
package datamanagement;

import cataloguemanagement.*;
import java.sql.*;
import java.util.*;

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
        
        resultSet = database.selectRecord(Table.COPY, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String itemID = resultSet.getString("item_id");
        
        if (new DataStore().isValidBookID(itemID)) {
            
            catalogueItem = new Book();
            
            catalogueItem.setIndividualCopyID(copyID);
            catalogueItem.setType(CatalogueItem.BOOK);
            catalogueItem.setItemID(itemID);
            catalogueItem.setLocation(resultSet.getString("location"));
            
            where.clear();
            where.add(itemID);
            
            resultSet = database.selectRecord(Table.BOOK, where);
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
    
    public User getUser() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public boolean isCopyAvailable(String copyID) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add("%");
        condition.add("%");
        condition.add(copyID);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, condition, 1);
        
        if (resultSet.next() && resultSet.getString("time_returned") == null) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public boolean isCopyOverdue(String copyID) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add("%");
        condition.add("%");
        condition.add(copyID);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, condition, 1);
        
        
        if (resultSet.next() && resultSet.getTimestamp("time_to_return").compareTo(new java.util.Date()) < 0) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public boolean isCopyReserved(String copyID) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(copyID);
        condition.add("%");
        condition.add("%");
        
        ResultSet resultSet = database.selectRecord(Table.COPY, condition);
        resultSet.next();
        
        if (resultSet.getString("reserved_by").compareTo("1000000000") == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public boolean isUserSuspended() {
        
        throw new UnsupportedOperationException("Not yet implemented");
        
    }
    
    //check if the item id exists in the database
    public boolean isValidBookID(String bookID) throws SQLException, ClassNotFoundException{
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(bookID);
        ResultSet resultSet = database.selectRecord(Table.BOOK, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public boolean isValidUserID(String userID) throws SQLException, ClassNotFoundException{
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(userID);
        ResultSet resultSet = database.selectRecord(Table.USER, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public boolean isValidLoanID(String loanID) throws SQLException, ClassNotFoundException{
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(loanID);
        ResultSet resultSet = database.selectRecord(Table.USER, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public boolean isValidCopyID(String copyID) throws SQLException, ClassNotFoundException{
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(copyID);
        ResultSet resultSet = database.selectRecord(Table.USER, condition);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }

    

}
