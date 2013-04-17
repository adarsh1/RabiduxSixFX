
package datamanagement;

import cataloguemanagement.*;
import factory.DatabaseFactory;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import usermanagement.*;
import exception.*;

/**
 *
 * @author Allen
 * @edit Adarsh
 */
public class DataStore {
    public static final String WILDCARD_CHAR = "%";
    public static final String NULL_VARCHAR = "NULLVARCHAR";
    public static final String NULL_DATETIME = "NULLDATETIME";
    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private Database database;
    
    public DataStore(){
        DatabaseFactory instance = DatabaseFactory.getInstance();
        database = instance.createDatabase();
    }
    
    public void insertItem(CatalogueCopy catalogueItem) throws SQLException, ClassNotFoundException {
        
        ArrayList<String> itemValues = new ArrayList<> ();
        
        
        database.initializeConnection();
        
        
        database.closeConnection();
       
    }
    
    public CatalogueCopy getCopy(String copyID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        CatalogueCopy catalogueItem = null;
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String itemID = resultSet.getString(Table.COPY.getAttribute(Table.COPY_ITEM_ID));
        
        if (new DataStore().isValidBookID(itemID)) {
            
            catalogueItem = new Book();
            
            catalogueItem.setIndividualCopyID(copyID);
            catalogueItem.setType(CatalogueCopy.BOOK);
            catalogueItem.setItemID(itemID);
            catalogueItem.setLocation(resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
            
            where.clear();
            where.add(itemID);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            
            resultSet = database.selectRecord(Table.BOOK, where);
            resultSet.next();
            
            catalogueItem.setTitle(resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_TITLE)));
            catalogueItem.setAuthor(resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_AUTHOR)));
            
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(resultSet.getTimestamp(Table.BOOK.getAttribute(Table.BOOK_DATE)));
            
            catalogueItem.setPublishDate(calendar);
            catalogueItem.setDescription(resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_DESCRIPTION)));
            ((Book)catalogueItem).setISBN(resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_ISBN)));
            ((Book)catalogueItem).setGenre(resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_GENRE)));
            
            
        } else {
            
//            throw new ItemNotFoundException("Item ID is not valid");
            
        }
        
        database.closeConnection();
        
        return catalogueItem;
        
    }
    
    public User getUser(String username, String password) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        User user = null;
        
        if (!isValidUsername(username)) {
            
//            throw new UserNotFoundException("Username is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(username);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String userType = resultSet.getString(Table.USER.getAttribute(Table.USER_USER_TYPE));
        
        if (Integer.parseInt(userType) == User.LIBRARIAN) {
            
            user = new Librarian();
            
            user.setUserID(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_ID)));
            user.setUsername(username);
            
            database.closeConnection();
            
            return user;
            
        } else if (Integer.parseInt(userType) == User.FACULTY) {
            
            user = new Faculty();
            
        } else if (Integer.parseInt(userType) == User.STUDENT) {
            
            user = new Student();
            
        } else {
            
//            throw new InvalidUserTypeException("The user type is invalid");
            
        }
            
        user.setUserID(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_ID)));
        user.setUsername(username);
        ((Member)user).setFineAmount(resultSet.getDouble(Table.USER.getAttribute(Table.USER_FINE)));
        
        database.closeConnection();
        
        return user;
        
    }
    
    public User getUser(String userID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        User user = null;
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        resultSet.next();
        
        // retrive itemID to determine the type of catalogue item
        String userType = resultSet.getString(Table.USER.getAttribute(Table.USER_USER_TYPE));
        
        if (Integer.parseInt(userType) == User.LIBRARIAN) {
            
            user = new Librarian();
            
            user.setUserID(userID);
            user.setUsername(resultSet.getString(Table.USER.getAttribute(Table.USER_USERNAME)));
            
            database.closeConnection();
            
            return user;
            
        } else if (Integer.parseInt(userType) == User.FACULTY) {
            
            user = new Faculty();
            
        } else if (Integer.parseInt(userType) == User.STUDENT) {
            
            user = new Student();
            
        } else {
            
//            throw new InvalidUserTypeException("The user type is invalid");
            
        }
            
        user.setUserID(userID);
        user.setUsername(resultSet.getString(Table.USER.getAttribute(Table.USER_USERNAME)));
        ((Member)user).setFineAmount(resultSet.getDouble(Table.USER.getAttribute(Table.USER_FINE)));
        
        database.closeConnection();
        
        return user;
        
    }
    
    public ReservableCopyGroup getCopyGroup(String itemID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ReservableCopyGroup result = new ReservableCopyGroup ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (isValidBookID(itemID)) { 

            result.setItemID(itemID);

            database.initializeConnection();

            where.add(WILDCARD_CHAR);
            where.add(itemID);
            where.add(WILDCARD_CHAR);

            resultSet = database.selectRecord(Table.COPY, where);

            result.setCopiesAvailable(database.getNumOfRows(resultSet));
            
            /***
             * 
             *  No exception should be thrown here
             *  Reason be it's possible for an item to have no copy
             * 
            ***/
            
            while(resultSet.next()) {

                String copyID = resultSet.getString(Table.COPY.getAttribute(Table.COPY_COPY_ID));
                result.addCopy(Book.getBook(copyID));

            }
            
        } else {
            
//            throw new ItemNotFoundException("Item ID is invalid");
            
        }
        database.closeConnection();
        
        return result;
        
    }
    
    public ArrayList<ReservableCopyGroup> getCopyGroups(String searchCriteria, String keyword) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<ReservableCopyGroup> result = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (keyword == null || keyword.compareTo("") == 0) {
            
//            throw InvalidKeywordException("The search keyword cannot be empty");
            
        }
        
        where.add(WILDCARD_CHAR);
        
        if (searchCriteria.compareTo(Table.BOOK_TITLE) == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        if (searchCriteria.compareTo(Table.BOOK_AUTHOR) == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        if (searchCriteria.compareTo(Table.BOOK_ISBN) == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        if (searchCriteria.compareTo(Table.BOOK_GENRE) == 0) { 
            
            where.add(WILDCARD_CHAR + keyword + WILDCARD_CHAR); 
            
        } else {
            
            where.add(WILDCARD_CHAR);
            
        }
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.BOOK, where);
        
        while (resultSet.next()) {
            
            ReservableCopyGroup reservableCopyGroup = new ReservableCopyGroup();
            
            reservableCopyGroup.setItemID(resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_BOOK_ID)));
            
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
                
                String copyID = resultSet.getString(Table.COPY.getAttribute(Table.COPY_COPY_ID));
                result.get(i).addCopy(Book.getBook(copyID));
                
            }
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    public boolean isCopyBorrowed(String copyID) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        database.initializeConnection();
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(NULL_DATETIME);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, where);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
//        if (resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)) == null) {
//            
//            result = true;
//            
//        } else {
//            
//            result = false;
//            
//        }
        
        database.closeConnection();
        
        return result;
    }
    
    public boolean isCopyOverdue(String copyID) throws SQLException, ClassNotFoundException {
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        database.initializeConnection();
        
        condition.add(WILDCARD_CHAR);
        condition.add(WILDCARD_CHAR);
        condition.add(copyID);
        condition.add(NULL_DATETIME);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, condition, 1);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        if (resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)).compareTo(new java.util.Date()) < 0) {
            
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
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        database.initializeConnection();
        
        condition.add(copyID);
        condition.add(WILDCARD_CHAR);
        condition.add(WILDCARD_CHAR);
        
        ResultSet resultSet = database.selectRecord(Table.COPY, condition);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)) == null) {
            
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
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        if (resultSet.getBoolean(Table.USER.getAttribute(Table.USER_IS_SUSPENDED))) {
            
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
        
        if (!isValidUsername(username)) {
            
//            throw new UserNotFoundException("Username is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(username);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.USER.getAttribute(Table.USER_PASSWORD)).compareTo(password) == 0) {
            
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
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, where);
        
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
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        ResultSet resultSet = database.selectRecord(Table.COPY, where);
        
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
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(userID);
        where.add(WILDCARD_CHAR);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
//        while (resultSet.next()) {
//            
//            if (resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)) == null) {
//                
//                result ++;
//                
//            } 
//            
//        }
        
        result = database.getNumOfRows(resultSet);
        
        database.closeConnection();
        
        return result;
    }

    public int getNumOfReserving(String userID) throws SQLException, ClassNotFoundException {
        
        int result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(userID);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        result = database.getNumOfRows(resultSet);
        
        database.closeConnection();
        
        return result;
        
    }

    public ArrayList<PastTransaction> getRecords(String userID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<PastTransaction> result = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar timeBorrowed = new GregorianCalendar();
        Calendar timeReturned = new GregorianCalendar();
        Calendar timeToReturn = new GregorianCalendar();
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(userID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        while(resultSet.next()) {
            
            PastTransaction pastTransaction = new PastTransaction();
            
            pastTransaction.setLoanID(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_LOAN_ID)));
            
            timeBorrowed.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_BORROWED)));
            pastTransaction.setDateBorrowed(timeBorrowed);
            
            if (resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)) != null) {
                
                timeReturned.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)));
                pastTransaction.setDateReturned(timeReturned);
                
            } else {
                
                pastTransaction.setDateReturned(null);
                
            }
            
            timeToReturn.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)));
            pastTransaction.setDateToReturn(timeToReturn);
            
            pastTransaction.setFineAmount(Double.parseDouble(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_FINE_AMOUNT))));
            pastTransaction.setNumOfExtend(Integer.parseInt(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_NUM_OF_EXTEND))));
            
            pastTransaction.setCopy(CatalogueCopy.getCatalogueCopy(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_COPY_ID))));
            pastTransaction.setMember((Member)User.getUser(userID));
            
            result.add(pastTransaction);
        }
        
        database.closeConnection();
        return result;
        
    }

    public PastTransaction borrow(String copyID, String userID, int loanDuration) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> values = new ArrayList<> ();
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar today = new GregorianCalendar();
        Calendar due = new GregorianCalendar();
        String loanID = database.getNewID(Table.RECORD);
        PastTransaction transactionHistoryItem = new PastTransaction();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        due.add(Calendar.DAY_OF_YEAR, loanDuration);
        
        values.add(loanID);
        values.add(userID);
        values.add(copyID);
        values.add(new java.sql.Timestamp(today.getTimeInMillis()).toString());
        values.add(new java.sql.Timestamp(due.getTimeInMillis()).toString());
        values.add("0");
        values.add("0");
        
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)) != null && resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)).compareTo(userID) != 0) {
            
//            throw new BookReservedException();
            
        }
        
        set.add(NULL_VARCHAR);
        set.add(resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
        
        where.clear();
        where.add(copyID);
        
        database.updateRecord(Table.COPY, set, where);
        
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

    public PastTransaction extend(String copyID, String loanID, int extend_time) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        PastTransaction transactionHistoryItem = new PastTransaction();
        Calendar timeBorrowed = new GregorianCalendar();
        Calendar timeToReturn = new GregorianCalendar();
        int numOfExtend;
        
        if (!isValidLoanID(loanID)) {
            
//            throw new RecordNotFoundException();
            
        }
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException();
            
        }
        
        where.add(loanID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        timeBorrowed.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_BORROWED)));
        
        timeToReturn.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)));
        timeToReturn.add(Calendar.DAY_OF_YEAR, extend_time);
        
        numOfExtend = Integer.parseInt(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_NUM_OF_EXTEND)));
        numOfExtend ++;
        
        set.add(new java.sql.Timestamp(timeBorrowed.getTimeInMillis()).toString());
        set.add(NULL_DATETIME);
        set.add(new java.sql.Timestamp(timeToReturn.getTimeInMillis()).toString());
        set.add(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_FINE_AMOUNT)));
        set.add(Integer.toString(numOfExtend));
        
        where.clear();
        where.add(loanID);
        
        database.updateRecord(Table.RECORD, set, where);
        
        transactionHistoryItem.setLoanID(loanID);
        transactionHistoryItem.setDateBorrowed(timeBorrowed);
        transactionHistoryItem.setDateReturned(null);
        transactionHistoryItem.setDateToReturn(timeToReturn);
        transactionHistoryItem.setFineAmount(Double.parseDouble(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_FINE_AMOUNT))));
        transactionHistoryItem.setCopy(CatalogueCopy.getCatalogueCopy(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_COPY_ID))));
        
        database.closeConnection();
        
        return transactionHistoryItem;
    }

    public void reserve(String copyID, String userID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        set.add(userID);
        set.add(resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
        
        where.clear();
        where.add(copyID);
        
        database.updateRecord(Table.COPY, set, where);
        
        database.closeConnection();
        
    }

    public void cancelReservation(String copyID, String userID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        set.add(NULL_VARCHAR);
        set.add(resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
        
        where.clear();
        where.add(copyID);
        
        database.updateRecord(Table.COPY, set, where);
        
        database.closeConnection();
        
    }

    public void returnBook(String copyID, double fine) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar today = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where, 1);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        where.clear();
        where.add(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_LOAN_ID)));
        
        set.add(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_TIME_BORROWED)));
        set.add(new java.sql.Timestamp(today.getTimeInMillis()).toString());
        set.add(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)));
        set.add(Double.toString(fine));
        set.add(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_NUM_OF_EXTEND)));
        
        database.updateRecord(Table.RECORD, set, where);
        
        where.clear();
        where.add(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_USER_ID)));
        where.add(WILDCARD_CHAR);
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        set.clear();
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_TYPE)));
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USERNAME)));
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_PASSWORD)));
        
        double userFine = resultSet.getDouble(Table.USER.getAttribute(Table.USER_FINE));
        String isSuspended = resultSet.getString(Table.USER.getAttribute(Table.USER_IS_SUSPENDED));
        
        userFine += fine;
        if (userFine > 0.00) {
            
            isSuspended = "1";
            
        }
        
        set.add(Double.toString(userFine));
        set.add(isSuspended);
        
        where.clear();
        where.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_ID)));
        
        database.updateRecord(Table.USER, set, where);
        
        database.closeConnection();
        
    }

    public ArrayList<ReservedCopy> getReservedCopies(String userID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        ArrayList<ReservedCopy> result = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(userID);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        
        while(resultSet.next()) {
            
            ReservedCopy reservedCopy = new ReservedCopy();
            String copyID = resultSet.getString(Table.COPY.getAttribute(Table.COPY_COPY_ID));
            
            reservedCopy.setCopyID(copyID);
            reservedCopy.setCopy((ReservationCancellable)CatalogueCopy.getCatalogueCopy(copyID));
            reservedCopy.setDateAvailable(null);
            
            result.add(reservedCopy);
        }
        
        for (int i = 0; i < result.size(); i++) {
            
            Calendar dateAvailable = new GregorianCalendar();
            
            where.clear();
            
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            where.add(result.get(i).getCopyID());
            where.add(NULL_DATETIME);
            
            resultSet = database.selectRecord(Table.RECORD, where, 1);
            
            while(resultSet.next()) {
                
                dateAvailable.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)));
                result.get(i).setDateAvailable(dateAvailable);
                
            }
            
        }
        
        database.closeConnection();
        
        return result;
        
    }

    public ArrayList<CurrentHolding> getCurrentHoldings(String userID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        ArrayList<CurrentHolding> result = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(userID);
        where.add(WILDCARD_CHAR);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        while(resultSet.next()) {
            
            if (resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)) != null) {
                
                continue;
                
            }
            
            Calendar dateBorrowed = new GregorianCalendar();
            Calendar dateToReturn = new GregorianCalendar();
            CurrentHolding currentHolding = new CurrentHolding();
            
            currentHolding.setLoanID(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_LOAN_ID)));
            
            dateBorrowed.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_BORROWED)));
            currentHolding.setDateBorrowed(dateBorrowed);
            
            dateToReturn.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)));
            currentHolding.setDateToReturn(dateToReturn);
            
            currentHolding.setFine(resultSet.getDouble(Table.RECORD.getAttribute(Table.RECORD_FINE_AMOUNT)));
            currentHolding.setNumOfExtend(Integer.parseInt(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_NUM_OF_EXTEND))));
            
            String copyID = resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_COPY_ID));
            currentHolding.setCopy((Extendable)CatalogueCopy.getCatalogueCopy(copyID));
            
            result.add(currentHolding);
        }
        
        database.closeConnection();
        
        return result;
        
    }

    public ReservedCopy getReservedCopy(String copyID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        ReservedCopy result = new ReservedCopy ();
        Calendar dateAvailable = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        result.setCopyID(copyID);
        result.setCopy((ReservationCancellable)CatalogueCopy.getCatalogueCopy(copyID));
        result.setDateAvailable(null);
            
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(NULL_DATETIME);
            
        resultSet = database.selectRecord(Table.RECORD, where, 1);
            
        if(resultSet.next()) {
                
            dateAvailable.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)));
            result.setDateAvailable(dateAvailable);
                
        }
        
        database.closeConnection();
        
        return result;
        
    }

    public PastTransaction getRecord(String copyID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        PastTransaction result = new PastTransaction ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar timeBorrowed = new GregorianCalendar();
        Calendar timeReturned = new GregorianCalendar();
        Calendar timeToReturn = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
//            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        if(resultSet.next()) {
            
            result.setLoanID(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_LOAN_ID)));
            
            timeBorrowed.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_BORROWED)));
            result.setDateBorrowed(timeBorrowed);
            
            if (resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)) != null) {
                
                timeReturned.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)));
                result.setDateReturned(timeReturned);
                
            } else {
                
                result.setDateReturned(null);
                
            }
            
            timeToReturn.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)));
            result.setDateToReturn(timeToReturn);
            
            result.setFineAmount(Double.parseDouble(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_FINE_AMOUNT))));
            result.setNumOfExtend(Integer.parseInt(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_NUM_OF_EXTEND))));
            
            result.setCopy(CatalogueCopy.getCatalogueCopy(copyID));
            result.setMember((Member)User.getUser(resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_USER_ID))));
            
        }
        
        database.closeConnection();
        
        return result;
        
    }

    public void resetFine(String userID) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
//            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
//            throw new NullResultException();
            
        }
        
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_TYPE)));
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USERNAME)));
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_PASSWORD)));
        set.add("0");
        set.add("0");
        
        where.clear();
        where.add(userID);
        
        database.updateRecord(Table.USER, set, where);
        
        database.closeConnection();
        
    }

}
