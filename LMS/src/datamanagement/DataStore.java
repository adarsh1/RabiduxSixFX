
package datamanagement;

import cataloguemanagement.*;
import java.sql.*;
import java.util.*;
import usermanagement.*;

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
    
    public User getUser(String accountName) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        User user = null;
        
        where.add("%");
        where.add(accountName);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String userType = resultSet.getString("user_type");
        
        if (Integer.parseInt(userType) == User.LIBRARIAN) {
            
            user = new Librarian();
            
            user.setUserID(resultSet.getString("user_id"));
            user.setAccountName(accountName);
            
            return user;
            
        } else if (Integer.parseInt(userType) == User.FACULTY) {
            
            user = new Faculty();
            
        } else {
            
            user = new Student();
            
        }
            
        user.setUserID(resultSet.getString("user_id"));
        user.setAccountName(accountName);
        ((Member)user).setFineAmount(resultSet.getDouble("fine"));
        
        database.closeConnection();
        
        return user;
        
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
    
    public boolean isValidUserPassword(String userID, String password) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        where.add(userID);
        where.add("%");
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        resultSet.next();
        
        if (resultSet.getString("password").compareTo(password) == 0) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
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
        ArrayList<String> where = new ArrayList<> ();
        
        database.initializeConnection();
        
        where.add(userID);
        where.add("%");
        
        ResultSet resultSet = database.selectRecord(Table.USER, where);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public boolean isValidUserName(String accountName) throws SQLException, ClassNotFoundException{
        
        boolean result;
        ArrayList<String> where = new ArrayList<> ();
        
        database.initializeConnection();
        
        where.add("%");
        where.add(accountName);
        
        
        ResultSet resultSet = database.selectRecord(Table.USER, where);
        
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

    public int getNumOfBorrowing(String userID) {
        
        throw new UnsupportedOperationException("Not yet implemented");
        
    }

    public int getNumOfReserving(String userID) {
        
        throw new UnsupportedOperationException("Not yet implemented");
        
    }

}
