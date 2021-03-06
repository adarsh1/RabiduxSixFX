
package datamanagement;

import cataloguemanagement.*;
import exception.*;
import factory.DatabaseFactory;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import usermanagement.*;

/**
 *
 * @author Allen
 */
public class DataStore {
    /**
     *
     */
    public static final String WILDCARD_CHAR = "%";
    /**
     *
     */
    public static final String NULL_VARCHAR = "NULLVARCHAR";
    /**
     *
     */
    public static final String NULL_DATETIME = "NULLDATETIME";
    /**
     *
     */
    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private Database database;
    
    /**
     *
     */
    public DataStore(){
        DatabaseFactory instance = DatabaseFactory.getInstance();
        database = instance.createDatabase();
    }
     
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException  
     */
    public CatalogueCopy getCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        CatalogueCopy catalogueItem = null;
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
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
            
            database.closeConnection();
            throw new ItemNotFoundException("Item ID is not valid");
            
        }
        
        database.closeConnection();
        
        return catalogueItem;
        
    }
    
    /**
     *
     * @param username
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws InvalidUserTypeException  
     */
    public User getUserByName(String username) throws SQLException, ClassNotFoundException, UserNotFoundException, InvalidUserTypeException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        User user = null;
        
        if (!isValidUsername(username)) {
            
            throw new UserNotFoundException("Username is not valid");
            
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
            
            database.closeConnection();            
            throw new InvalidUserTypeException("The user type is invalid");
            
        }
            
        user.setUserID(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_ID)));
        user.setUsername(username);
        ((Member)user).setFineAmount(resultSet.getDouble(Table.USER.getAttribute(Table.USER_FINE)));
        
        database.closeConnection();
        
        return user;
        
    }
    
    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws InvalidUserTypeException  
     */
    public User getUser(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException, InvalidUserTypeException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        User user = null;
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
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
            
            database.closeConnection();            
            throw new InvalidUserTypeException("The user type is invalid");
            
        }
            
        user.setUserID(userID);
        user.setUsername(resultSet.getString(Table.USER.getAttribute(Table.USER_USERNAME)));
        ((Member)user).setFineAmount(resultSet.getDouble(Table.USER.getAttribute(Table.USER_FINE)));
        
        database.closeConnection();
        
        return user;
        
    }
    
    /**
     *
     * @param itemID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException 
     * @throws CopyNotFoundException  
     */
    public ReservableCopyGroup getCopyGroup(String itemID) throws SQLException, ClassNotFoundException, ItemNotFoundException, CopyNotFoundException {
        
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
            
            database.closeConnection();
            
        } else {
            
            throw new ItemNotFoundException("Item ID is invalid");
            
        }
        
        return result;
        
    }
    
    /**
     *
     * @param searchCriteria
     * @param keyword
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InvalidKeywordException 
     * @throws ItemNotFoundException
     * @throws CopyNotFoundException  
     */
    public ArrayList<ReservableCopyGroup> getCopyGroups(String searchCriteria, String keyword) throws SQLException, ClassNotFoundException, InvalidKeywordException, CopyNotFoundException, ItemNotFoundException {
        
        ResultSet resultSet;
        ArrayList<ReservableCopyGroup> result = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (keyword == null || keyword.compareTo("") == 0) {
            
            throw new InvalidKeywordException("The search keyword cannot be empty");
            
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
    
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException  
     */
    public boolean isCopyBorrowed(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException {
        
        boolean result;
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
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
                
        database.closeConnection();
        
        return result;
    }
    
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws NullResultException  
     */
    public boolean isCopyOverdue(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        database.initializeConnection();
        
        condition.add(WILDCARD_CHAR);
        condition.add(WILDCARD_CHAR);
        condition.add(copyID);
        condition.add(NULL_DATETIME);
        
        ResultSet resultSet = database.selectRecord(Table.RECORD, condition, 1);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        if (resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_TO_RETURN)).compareTo(new java.util.Date()) < 0) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws NullResultException  
     */
    public boolean isCopyReserved(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        boolean result;
        ArrayList<String> condition = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        database.initializeConnection();
        
        condition.add(copyID);
        condition.add(WILDCARD_CHAR);
        condition.add(WILDCARD_CHAR);
        
        ResultSet resultSet = database.selectRecord(Table.COPY, condition);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)) == null) {
            
            result = false;
            
        } else {
            
            result = true;
            
        }
        
        database.closeConnection();
        
        return result;
    }
    
    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws NullResultException  
     */
    public boolean isUserSuspended(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException, NullResultException {
        
        boolean result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        if (resultSet.getBoolean(Table.USER.getAttribute(Table.USER_IS_SUSPENDED))) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        return result;
        
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NullResultException 
     * @throws UserNotFoundException  
     */
    public boolean isValidUserPassword(String username, String password) throws SQLException, ClassNotFoundException, NullResultException, UserNotFoundException {
        
        boolean result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidUsername(username)) {
            
            throw new UserNotFoundException("Username is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(username);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.USER.getAttribute(Table.USER_PASSWORD)).compareTo(password) == 0) {
            
            result = true;
            
        } else {
            
            result = false;
            
        }
        
        database.closeConnection();
        
        return result;
        
    }
    
    /**
     *
     * @param bookID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *
     * @param username
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *
     * @param loanID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException  
     */
    public int getNumOfBorrowing(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException {
        
        int result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(userID);
        where.add(WILDCARD_CHAR);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        result = database.getNumOfRows(resultSet);
        
        database.closeConnection();
        
        return result;
    }

    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException  
     */
    public int getNumOfReserving(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException {
        
        int result;
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
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

    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException
     * @throws InvalidUserTypeException  
     */
    public ArrayList<PastTransaction> getRecords(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException, CopyNotFoundException, ItemNotFoundException, InvalidUserTypeException {
        
        ResultSet resultSet;
        ArrayList<PastTransaction> result = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar timeBorrowed = new GregorianCalendar();
        Calendar timeReturned = new GregorianCalendar();
        Calendar timeToReturn = new GregorianCalendar();
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
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

    /**
     *
     * @param copyID
     * @param userID
     * @param loanDuration
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws UserNotFoundException 
     * @throws NullResultException 
     * @throws CopyReservedException  
     */
    public PastTransaction borrow(String copyID, String userID, int loanDuration) throws SQLException, ClassNotFoundException, CopyNotFoundException, UserNotFoundException, NullResultException, CopyReservedException {
        
        ResultSet resultSet;
        ArrayList<String> values = new ArrayList<> ();
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar today = new GregorianCalendar();
        Calendar due = new GregorianCalendar();
        String loanID = database.getNewID(Table.RECORD);
        PastTransaction transactionHistoryItem = new PastTransaction();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
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
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)) != null && resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)).compareTo(userID) != 0) {
            
            database.closeConnection();
            throw new CopyReservedException();
            
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

    /**
     *
     * @param copyID
     * @param loanID
     * @param extend_time
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws RecordNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException
     * @throws NullResultException  
     */
    public PastTransaction extend(String copyID, String loanID, int extend_time) throws SQLException, ClassNotFoundException, RecordNotFoundException, CopyNotFoundException, NullResultException, ItemNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        PastTransaction transactionHistoryItem = new PastTransaction();
        Calendar timeBorrowed = new GregorianCalendar();
        Calendar timeToReturn = new GregorianCalendar();
        int numOfExtend;
        
        if (!isValidLoanID(loanID)) {
            
            throw new RecordNotFoundException();
            
        }
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException();
            
        }
        
        where.add(loanID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
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

    /**
     *
     * @param copyID
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws UserNotFoundException
     * @throws NullResultException
     * @throws CopyBorrowedException  
     */
    public void reserve(String copyID, String userID) throws SQLException, ClassNotFoundException, CopyNotFoundException, UserNotFoundException, NullResultException, CopyBorrowedException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.RECORD.getAttribute(Table.RECORD_USER_ID)).compareTo(userID) == 0) {
            
            database.closeConnection();
            throw new CopyBorrowedException("The copy has borrowed by the user");
            
        }
        
        where.clear();
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        resultSet = database.selectRecord(Table.COPY, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        set.add(userID);
        set.add(resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
        
        where.clear();
        where.add(copyID);
        
        database.updateRecord(Table.COPY, set, where);
        
        database.closeConnection();
        
    }

    /**
     *
     * @param copyID
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws UserNotFoundException
     * @throws NullResultException  
     */
    public void cancelReservation(String copyID, String userID) throws SQLException, ClassNotFoundException, CopyNotFoundException, UserNotFoundException, NullResultException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        set.add(NULL_VARCHAR);
        set.add(resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
        
        where.clear();
        where.add(copyID);
        
        database.updateRecord(Table.COPY, set, where);
        
        database.closeConnection();
        
    }

    /**
     *
     * @param copyID
     * @param fine
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws NullResultException  
     */
    public void returnBook(String copyID, double fine) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar today = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where, 1);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
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
            
            database.closeConnection();
            throw new NullResultException();
            
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

    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException  
     */
    public ArrayList<ReservedCopy> getReservedCopies(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException, CopyNotFoundException, ItemNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        ArrayList<ReservedCopy> result = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
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

    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException 
     * @throws ItemNotFoundException
     * @throws CopyNotFoundException  
     */
    public ArrayList<CurrentHolding> getCurrentHoldings(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException, CopyNotFoundException, ItemNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        ArrayList<CurrentHolding> result = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
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

    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException  
     */
    public ReservedCopy getReservedCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        ReservedCopy result = new ReservedCopy ();
        Calendar dateAvailable = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
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

    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws UserNotFoundException
     * @throws ItemNotFoundException 
     * @throws InvalidUserTypeException  
     */
    public PastTransaction getRecord(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException, UserNotFoundException, InvalidUserTypeException {
        
        ResultSet resultSet;
        PastTransaction result = new PastTransaction ();
        ArrayList<String> where = new ArrayList<> ();
        Calendar timeBorrowed = new GregorianCalendar();
        Calendar timeReturned = new GregorianCalendar();
        Calendar timeToReturn = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException("Copy ID does not exsit");
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where, 1);
        
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

    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException 
     * @throws NullResultException  
     */
    public void resetFine(String userID) throws SQLException, ClassNotFoundException, UserNotFoundException, NullResultException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidUserID(userID)) {
            
            throw new UserNotFoundException("User ID is not valid");
            
        }
        
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
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

    /**
     *
     * @param details
     * @param itemType
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InvalidItemTypeException
     */
    public void addItem(HashMap<String, Object> details, int itemType) throws SQLException, ClassNotFoundException, InvalidItemTypeException {
        
        ArrayList<String> values = new ArrayList<> ();
        String itemID;
        
        if (itemType == CatalogueCopy.BOOK) {
            
            itemID = database.getNewID(Table.BOOK);
            
            values.add(itemID);
            values.add((String)details.get(Table.BOOK_TITLE));
            values.add((String)details.get(Table.BOOK_AUTHOR));
            values.add((String)details.get(Table.BOOK_ISBN));
            values.add((String)details.get(Table.BOOK_GENRE));
            values.add(SDF.format(((Calendar)details.get(Table.BOOK_DATE)).getTime()));
            values.add((String)details.get(Table.BOOK_DESCRIPTION));
            
            database.initializeConnection();
            
            database.insertRecord(Table.BOOK, values);
            
            database.closeConnection();
            
        } else {
            
            throw new InvalidItemTypeException();
            
        }
        
    }

    /**
     *
     * @param details
     * @param itemType
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws InvalidItemTypeException
     */
    public void updateItem(HashMap<String, Object> details, int itemType) throws SQLException, ClassNotFoundException, ItemNotFoundException, InvalidItemTypeException {
        
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        if (itemType == CatalogueCopy.BOOK) {
            
            if (!isValidBookID((String)details.get(Table.BOOK_BOOK_ID))) {
                
                throw new ItemNotFoundException();
                
            }
            
            where.add((String)details.get(Table.BOOK_BOOK_ID));
            
            set.add((String)details.get(Table.BOOK_TITLE));
            set.add((String)details.get(Table.BOOK_AUTHOR));
            set.add((String)details.get(Table.BOOK_ISBN));
            set.add((String)details.get(Table.BOOK_GENRE));
            set.add(SDF.format(((Calendar)details.get(Table.BOOK_DATE)).getTime()));
            set.add((String)details.get(Table.BOOK_DESCRIPTION));
            
            database.initializeConnection();
            
            database.updateRecord(Table.BOOK, set, where);
            
            database.closeConnection();
            
        } else {
            
            throw new InvalidItemTypeException();
            
        }
        
    }

    /**
     *
     * @param itemID
     * @param itemType
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws NullResultException
     * @throws InvalidItemTypeException
     */
    public HashMap<String, Object> getItemInfo(String itemID, int itemType) throws SQLException, ClassNotFoundException, ItemNotFoundException, NullResultException, InvalidItemTypeException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        HashMap<String, Object> details = new HashMap<> ();
        Calendar publishDate = new GregorianCalendar();
        
        if (itemType == CatalogueCopy.BOOK) {
            
            if (!isValidBookID(itemID)) {
                
                throw new ItemNotFoundException();
                
            }
            
            where.add(itemID);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            
            database.initializeConnection();
            
            resultSet = database.selectRecord(Table.BOOK, where);
            
            if (!resultSet.next()) {
                
                database.closeConnection();
                throw new NullResultException();
                
            }
            
            details.put(Table.BOOK_BOOK_ID, itemID);
            details.put(Table.BOOK_TITLE, resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_TITLE)));
            details.put(Table.BOOK_AUTHOR, resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_AUTHOR)));
            
            publishDate.setTime(resultSet.getTimestamp(Table.BOOK.getAttribute(Table.BOOK_DATE)));
            
            details.put(Table.BOOK_DATE, publishDate);
            details.put(Table.BOOK_DESCRIPTION, resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_DESCRIPTION)));
            details.put(Table.BOOK_ISBN, resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_ISBN)));
            details.put(Table.BOOK_GENRE, resultSet.getString(Table.BOOK.getAttribute(Table.BOOK_GENRE)));
            
            database.closeConnection();
            
        } else {
            
            throw new InvalidItemTypeException();
            
        }
        
        return details;
        
    }

    /**
     *
     * @param itemID
     * @param itemType
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws InvalidItemTypeException
     */
    public void deleteItem(String itemID, int itemType) throws SQLException, ClassNotFoundException, ItemNotFoundException, InvalidItemTypeException {
        
        ArrayList<String> where = new ArrayList<> ();
        
        if (itemType == CatalogueCopy.BOOK) {
            
            if (!isValidBookID(itemID)) {
                
                throw new ItemNotFoundException();
                
            }
            
            where.add(itemID);
            
            database.initializeConnection();
            
            database.deleteRecord(Table.BOOK, where);
            
            database.closeConnection();
            
        } else {
            
            throw new InvalidItemTypeException();
            
        }
        
    }

    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void addCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException {
        
        ArrayList<String> values = new ArrayList<> ();
        String copyID = database.getNewID(Table.COPY);
        
        values.add(copyID);
        values.add((String)details.get(Table.COPY_ITEM_ID));
        values.add(NULL_VARCHAR);
        values.add((String)details.get(Table.COPY_LOCATION));

        database.initializeConnection();

        database.insertRecord(Table.COPY, values);

        database.closeConnection();
        
    }

    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws NullResultException
     */
    public void updateCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        ResultSet resultSet;
        
        if (!isValidCopyID((String)details.get(Table.COPY_COPY_ID))) {
            
            throw new CopyNotFoundException();
            
        }
        
        where.add((String)details.get(Table.COPY_COPY_ID));
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.COPY, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        if (resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)) == null) {
            
            set.add(NULL_VARCHAR);
            
        } else {
            
            set.add(resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)));
            
        }
        
        set.add((String)details.get(Table.COPY_LOCATION));

        where.clear();
        where.add((String)details.get(Table.COPY_COPY_ID));

        database.updateRecord(Table.COPY, set, where);

        database.closeConnection();
        
    }

    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws NullResultException
     */
    public HashMap<String, Object> getCopyInfo(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException {
        
        ResultSet resultSet;
        ArrayList<String> where = new ArrayList<> ();
        HashMap<String, Object> details = new HashMap<> ();
        Calendar publishDate = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException();
            
        }
        
        where.add(copyID);
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);

        database.initializeConnection();

        resultSet = database.selectRecord(Table.COPY, where);

        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();

        }

        details.put(Table.COPY_COPY_ID, copyID);
        details.put(Table.COPY_ITEM_ID, resultSet.getString(Table.COPY.getAttribute(Table.COPY_ITEM_ID)));
        details.put(Table.COPY_LOCATION, resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
        details.put(Table.COPY_RESERVED_BY, resultSet.getString(Table.COPY.getAttribute(Table.COPY_RESERVED_BY)));
        
        database.closeConnection();
        
        return details;
        
    }

    /**
     *
     * @param copyID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     */
    public void deleteCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException {
        
        ArrayList<String> where = new ArrayList<> ();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException();
            
        }
        
        where.add(copyID);

        database.initializeConnection();

        database.deleteRecord(Table.COPY, where);

        database.closeConnection();
        
    }

    /**
     *
     * @param copyID
     * @param gracePeriod
     * @throws CopyNotFoundException
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NullResultException
     */
    public void refreshReserve(String copyID, int gracePeriod) throws CopyNotFoundException, SQLException, ClassNotFoundException, NullResultException {
        
        ArrayList<String> where = new ArrayList<> ();
        ResultSet resultSet;
        Calendar today = new GregorianCalendar();
        Calendar returnDate = new GregorianCalendar();
        
        if (!isValidCopyID(copyID)) {
            
            throw new CopyNotFoundException();
            
        }
        
        where.add(WILDCARD_CHAR);
        where.add(WILDCARD_CHAR);
        where.add(copyID);
        where.add(NULL_DATETIME);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.RECORD, where);
        
        if (database.getNumOfRows(resultSet) != 0) {
            
            return ; 
            
        }
        
        where.add(WILDCARD_CHAR);
        
        resultSet = database.selectRecord(Table.RECORD, where, 1);
        
        if (database.getNumOfRows(resultSet) == 0) {
            
            return ; 
            
        }
        
        resultSet.next();
        returnDate.setTime(resultSet.getTimestamp(Table.RECORD.getAttribute(Table.RECORD_TIME_RETURNED)));
        returnDate.add(Calendar.DAY_OF_YEAR, gracePeriod);
        
        if (today.compareTo(returnDate) > 0) {
            
            ArrayList<String> set = new ArrayList<> ();
            
            where.clear();
            where.add(copyID);
            where.add(WILDCARD_CHAR);
            where.add(WILDCARD_CHAR);
            
            resultSet = database.selectRecord(Table.COPY, where);
            
            if (!resultSet.next()) {
                
                database.closeConnection();
                throw new NullResultException();
                
            }
            
            set.add(NULL_VARCHAR);
            set.add(resultSet.getString(Table.COPY.getAttribute(Table.COPY_LOCATION)));
            
            where.clear();
            where.add(copyID);
            
            database.updateRecord(Table.COPY, set, where);
            
        }
        
        database.closeConnection();
        
    }

    public void suspendUser(String userID) throws SQLException, ClassNotFoundException, NullResultException {
        
        ResultSet resultSet;
        ArrayList<String> set = new ArrayList<> ();
        ArrayList<String> where = new ArrayList<> ();
        
        where.add(userID);
        where.add(WILDCARD_CHAR);
        
        database.initializeConnection();
        
        resultSet = database.selectRecord(Table.USER, where);
        
        if (!resultSet.next()) {
            
            database.closeConnection();
            throw new NullResultException();
            
        }
        
        set.clear();
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_TYPE)));
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USERNAME)));
        set.add(resultSet.getString(Table.USER.getAttribute(Table.USER_PASSWORD)));
        set.add(Double.toString(resultSet.getDouble(Table.USER.getAttribute(Table.USER_FINE))));
        set.add("1");
        
        where.clear();
        where.add(resultSet.getString(Table.USER.getAttribute(Table.USER_USER_ID)));
        
        database.updateRecord(Table.USER, set, where);
        
        database.closeConnection();
        
    }

}
