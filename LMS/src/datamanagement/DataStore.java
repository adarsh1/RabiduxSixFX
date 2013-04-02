
package datamanagement;

import usermanagement.*;
import cataloguemanagement.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Allen
 * @edit Adarsh
 */
public class DataStore {
    public static final String WILDCARD_CHAR = "%";
    public static final String NULL_VARCHAR = "NULLVARCHAR";
    public static final String NULL_DATETIME = "NULLDATETIME";
        
    private Database database;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
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
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String itemID = resultSet.getString(Table.COPY.getAttribute("ITEM_ID"));
        
        if (new DataStore().isValidBookID(itemID)) {
            
            catalogueItem = new Book();
            
            catalogueItem.setIndividualCopyID(copyID);
            catalogueItem.setType(CatalogueItem.BOOK);
            catalogueItem.setItemID(itemID);
            catalogueItem.setLocation(resultSet.getString(Table.COPY.getAttribute("LOCATION")));
            
            where.clear();
            where.add(itemID);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            
            resultSet = database.selectRecord(Table.BOOK, where);
            resultSet.next();
            
            catalogueItem.setTitle(resultSet.getString(Table.BOOK.getAttribute("TITLE")));
            catalogueItem.setAuthor(resultSet.getString(Table.BOOK.getAttribute("AUTHOR")));
            
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(resultSet.getTimestamp(Table.BOOK.getAttribute("DATE")));
            
            catalogueItem.setPublishDate(calendar);
            catalogueItem.setDescription(resultSet.getString(Table.BOOK.getAttribute("DESCRIPTION")));
            ((Book)catalogueItem).setISBN(resultSet.getString(Table.BOOK.getAttribute("ISBN")));
            ((Book)catalogueItem).setGenre(resultSet.getString(Table.BOOK.getAttribute("GENRE")));
            
            
        }
        
        database.closeConnection();
        
        return catalogueItem;
        
    }
    
    public User getUser(String username) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        User user;
        
        where.add(WILDCARD_CHAR);
        where.add(username);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String userType = resultSet.getString(Table.USER.getAttribute("USER_TYPE"));
        
        if (Integer.parseInt(userType) == User.LIBRARIAN) {
            
            user = new Librarian();
            
            user.setUserID(resultSet.getString(Table.USER.getAttribute("USER_ID")));
            user.setUsername(username);
            
            database.closeConnection();
            
            return user;
            
        } else if (Integer.parseInt(userType) == User.FACULTY) {
            
            user = new Faculty();
            
        } else {
            
            user = new Student();
            
        }
            
        user.setUserID(resultSet.getString(Table.USER.getAttribute("USER_ID")));
        user.setUsername(username);
        ((Member)user).setFineAmount(resultSet.getDouble(Table.USER.getAttribute("FINE")));
        
        database.closeConnection();
        
        return user;
        
    }
    
    public ArrayList<ReservableCopyGroup> getCopyGroups(String searchCriteria, String keyword) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<ReservableCopyGroup> result = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        where.add(WILDCARD_CHAR);
        
        if (searchCriteria.compareTo("TITLE") == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        if (searchCriteria.compareTo("AUTHOR") == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        if (searchCriteria.compareTo("ISBN") == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        if (searchCriteria.compareTo("GENRE") == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.BOOK, where);
        
        while (resultSet.next()) {
            
            ReservableCopyGroup reservableCopyGroup = new ReservableCopyGroup();
            
            reservableCopyGroup.setItemID(resultSet.getString(Table.BOOK.getAttribute("BOOK_ID")));
            
            result.add(reservableCopyGroup);
            
        }
        
        for (int i = 0; i < result.size(); i++) {
            
            where.clear();
            
            where.add(WILDCARD_CHAR);
            where.add(result.get(i).getItemID());
            where.add(WILDCARD_CHAR);
            
            resultSet = database.selectRecord(Table.COPY, where);
            
            result.get(i).setCopiesAvailable(database.getNumOfRows(resultSet));
            
            while(resultSet.next()) {
                
                String copyID = resultSet.getString(Table.COPY.getAttribute("COPY_ID"));
                result.get(i).addCopy(Book.getBook(copyID));
                
            }
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public boolean isCopyAvailable(String copyID) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        database.initializeConnection();
        
        condition.add(WILDCARD_CHAR);
        condition.add(WILDCARD_CHAR);
        condition.add(copyID);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, condition, 1);
        
        if (resultSet.next() && resultSet.getString(Table.RECORD.getAttribute("TIME_RETURNED")) == null) {
            
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
        
        condition.add(WILDCARD_CHAR);
        condition.add(WILDCARD_CHAR);
        condition.add(copyID);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, condition, 1);
        
        
        if (resultSet.next() && resultSet.getTimestamp(Table.RECORD.getAttribute("TIME_TO_RETURN")).compareTo(new java.util.Date()) < 0) {
            
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
        condition.add(WILDCARD_CHAR);
        condition.add(WILDCARD_CHAR);
        
        ResultSet resultSet = database.selectRecord(Table.COPY, condition);
        resultSet.next();
        
        if (resultSet.getString(Table.COPY.getAttribute("RESERVED_BY")).compareTo("1000000000") == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    public boolean isUserSuspended(String userID) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        resultSet.next();
        
        if (resultSet.getBoolean(Table.USER.getAttribute("IS_SUSPENDED"))) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        return result;
        
    }
    
    public boolean isValidUserPassword(String username, String password) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        where.add(WILDCARD_CHAR);
        where.add(username);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        resultSet.next();
        
        if (resultSet.getString(Table.USER.getAttribute("PASSWORD")).compareTo(password) == 0) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public boolean isValidBookID(String bookID) throws SQLException, ClassNotFoundException{
        
        boolean result;
        ArrayList<String> where = new ArrayList<> ();
        
        database.initializeConnection();
        
        where.add(bookID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        ResultSet resultSet = database.selectRecord(Table.BOOK, where);
        
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
        where.add(WILDCARD_CHAR);
        
        ResultSet resultSet = database.selectRecord(Table.USER, where);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public boolean isValidUsername(String username) throws SQLException, ClassNotFoundException{
        
        boolean result;
        ArrayList<String> where = new ArrayList<> ();
        
        database.initializeConnection();
        
        where.add(WILDCARD_CHAR);
        where.add(username);
        
        
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
        ArrayList<String> where = new ArrayList<> ();
        
        database.initializeConnection();
        
        where.add(loanID);
        ResultSet resultSet = database.selectRecord(Table.USER, where);
        
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
        ArrayList<String> where = new ArrayList<> ();
        
        database.initializeConnection();
        
        where.add(copyID);
        ResultSet resultSet = database.selectRecord(Table.USER, where);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }

    public int getNumOfBorrowing(String userID) throws SQLException, ClassNotFoundException {
        
        int result = 0;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        where.add(WILDCARD_CHAR);
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        while (resultSet.next()) {
            
            if (resultSet.getString(Table.RECORD.getAttribute("TIME_RETURNED")) == null) {
                
                result ++;
                
            } 
            
        }
        
        database.closeConnection();
        
        return result;
    }

    public int getNumOfReserving(String userID) throws SQLException, ClassNotFoundException {
        
        int result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(userID);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        result = database.getNumOfRows(resultSet);
        
        database.closeConnection();
        
        return result;
        
    }

    public TransactionHistoryItem getRecord(String loanID) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public TransactionHistoryItem borrow(String individualCopyID, String userID) throws SQLException, ClassNotFoundException {
        
        ArrayList<String> values = new ArrayList<> ();
        Calendar today = new GregorianCalendar();
        Calendar due = new GregorianCalendar();
        String loanID = database.getNewID(Table.RECORD);
        TransactionHistoryItem transactionHistoryItem = new TransactionHistoryItem();
        
        due.add(Calendar.DAY_OF_YEAR, 30);
        
        values.add(loanID);
        values.add(userID);
        values.add(individualCopyID);
        values.add(new java.sql.Timestamp(today.getTimeInMillis()).toString());
        values.add(new java.sql.Timestamp(due.getTimeInMillis()).toString());
        values.add("0");
        values.add("0");
        
        database.initializeConnection();
        
        database.insertRecord(Table.RECORD, values);
        
        transactionHistoryItem.setLoanID(loanID);
        transactionHistoryItem.setDateBorrowed(today);
        transactionHistoryItem.setDateToReturn(due);
        transactionHistoryItem.setDateReturned(null);
        transactionHistoryItem.setFineAmount(0.00);
        transactionHistoryItem.setNumOfExtend(0);
        
        database.closeConnection();
        
        return transactionHistoryItem;
    }

    public TransactionHistoryItem extend(String loanID, int extend_time) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        TransactionHistoryItem transactionHistoryItem = new TransactionHistoryItem();
        Calendar timeBorrowed = new GregorianCalendar();
        Calendar timeToReturn = new GregorianCalendar();
        int numOfExtend;
        
        where.add(loanID);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        resultSet.next();
        
        timeBorrowed.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute("TIME_BORROWED")));
        
        timeToReturn.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute("TIME_TO_RETURN")));
        timeToReturn.add(Calendar.DAY_OF_YEAR, extend_time);
        
        numOfExtend = Integer.parseInt(resultSet.getString(Table.RECORD.getAttribute("NUM_OF_EXTEND")));
        numOfExtend ++;
        
        set.add(new java.sql.Timestamp(timeBorrowed.getTimeInMillis()).toString());
        set.add(NULL_DATETIME);
        set.add(new java.sql.Timestamp(timeToReturn.getTimeInMillis()).toString());
        set.add(resultSet.getString(Table.RECORD.getAttribute("FINE_AMOUNT")));
        set.add(Integer.toString(numOfExtend));
        
        database.updateRecord(Table.RECORD, set, where);
        
        transactionHistoryItem.setLoanID(loanID);
        transactionHistoryItem.setDateBorrowed(timeBorrowed);
        transactionHistoryItem.setDateReturned(null);
        transactionHistoryItem.setDateToReturn(timeToReturn);
        transactionHistoryItem.setFineAmount(Double.parseDouble(resultSet.getString(Table.RECORD.getAttribute("FINE_AMOUNT"))));
        transactionHistoryItem.setItem(CatalogueItem.getCatalogueItem(resultSet.getString(Table.RECORD.getAttribute("COPY_ID"))));
        
        database.closeConnection();
        
        return transactionHistoryItem;
    }

    public void reserve(String userID) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void cancelReservation(String userID) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void returnBook(String copyID, String userID) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
