/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Allen
 */
public class DatabaseConfig {
    
    public static final String DATABASE_TYPE = "Database";
    
    private String MySQL = "MySQL";
    
    public static final String TABLE_USER = "USER";
    public static final String TABLE_COPY = "COPY";
    public static final String TABLE_BOOK = "BOOK";
    public static final String TABLE_RECORD = "RECORD";
    
    private String MySQLTableUser = "user";
    private String MySQLTableCopy = "individual_copy";
    private String MySQLTableBook = "book";
    private String MySQLTableRecord = "loan_record";
    
    public static final String USER_USER_ID = "USER_ID";
    public static final String USER_USER_TYPE = "USER_TYPE";
    public static final String USER_USERNAME = "USERNAME";
    public static final String USER_PASSWORD = "PASSWORD";
    public static final String USER_FINE = "FINE";
    public static final String USER_IS_SUSPENDED = "IS_SUSPENDED";
    
    private String MySQLUserUserID = "user_id";
    private String MySQLUserUserType = "user_type";
    private String MySQLUserUsername = "username";
    private String MySQLUserPassword = "password";
    private String MySQLUserFine = "fine";
    private String MySQLUserIsSuspended = "is_suspended";
    
    public static final String COPY_COPY_ID = "COPY_ID";
    public static final String COPY_ITEM_ID = "ITEM_ID";
    public static final String COPY_RESERVED_BY = "RESERVED_BY";
    public static final String COPY_LOCATION = "LOCATION";
    
    private String MySQLCopyCopyID = "copy_id";
    private String MySQLCopyItemID = "item_id";
    private String MySQLCopyReservedBy = "reserved_by";
    private String MySQLCopyLocation = "location";
    
    public static final String BOOK_BOOK_ID = "BOOK_ID";
    public static final String BOOK_TITLE = "TITLE";
    public static final String BOOK_AUTHOR = "AUTHOR";
    public static final String BOOK_ISBN = "ISBN";
    public static final String BOOK_GENRE = "GENRE";
    public static final String BOOK_DATE = "DATE";
    public static final String BOOK_DESCRIPTION = "DESCRIPTION";
    
    private String MySQLBookBookID = "book_id";
    private String MySQLBookTitle = "title";
    private String MySQLBookAuthor = "author";
    private String MySQLBookISBN = "isbn";
    private String MySQLBookGenre = "genre";
    private String MySQLBookDate = "date";
    private String MySQLBookDescription = "description";
    
    public static final String LOAN_LOAN_ID = "LOAN_ID";
    public static final String LOAN_USER_ID = "USER_ID";
    public static final String LOAN_COPY_ID = "COPY_ID";
    public static final String LOAN_TIME_BORROWED = "TIME_BORROWED";
    public static final String LOAN_TIME_RETURNED = "TIME_RETURNED";
    public static final String LOAN_TIME_TO_RETURN = "TIME_TO_RETURN";
    public static final String LOAN_FINE_AMOUNT = "FINE_AMOUNT";
    public static final String LOAN_NUM_OF_EXTEND = "NUM_OF_EXTEND";
    
    private String MySQLLoanLoanID = "loan_id";
    private String MySQLLoanUserID = "user_id";
    private String MySQLLoanCopyID = "copy_id";
    private String MySQLLoanTimeBorrowed = "time_borrowed";
    private String MySQLLoanTimeReturned = "time_returned";
    private String MySQLLoanTimeToReturn = "time_to_return";
    private String MySQLLoanFineAmount = "fine_amount";
    private String MySQLLoanNumOfExtend = "num_of_extend";
    
    private Map<String, String> databaseConfigs = new HashMap();
    
    private DatabaseConfig() {
        
    }
    
    public static DatabaseConfig getInstance() {
        
        return DatabaseConfig.DatabaseConfigHolder.INSTANCE;
        
    }
    
    private static class DatabaseConfigHolder {

        private static final DatabaseConfig INSTANCE = new DatabaseConfig();
        
    }
    
    public void useMySQLDB(){
        
        databaseConfigs.put(DATABASE_TYPE, MySQL);
        
        databaseConfigs.put(TABLE_USER, MySQLTableUser);
        databaseConfigs.put(TABLE_COPY, MySQLTableCopy);
        databaseConfigs.put(TABLE_BOOK, MySQLTableBook );
        databaseConfigs.put(TABLE_RECORD, MySQLTableRecord);
        
        databaseConfigs.put(USER_USER_ID, MySQLUserUserID);
        databaseConfigs.put(USER_USER_TYPE, MySQLUserUserType);
        databaseConfigs.put(USER_USERNAME, MySQLUserUsername);
        databaseConfigs.put(USER_PASSWORD, MySQLUserPassword);
        databaseConfigs.put(USER_FINE, MySQLUserFine);
        databaseConfigs.put(USER_IS_SUSPENDED, MySQLUserIsSuspended);
        
        databaseConfigs.put(COPY_COPY_ID, MySQLCopyCopyID);
        databaseConfigs.put(COPY_ITEM_ID, MySQLCopyItemID);
        databaseConfigs.put(COPY_RESERVED_BY, MySQLCopyReservedBy);
        databaseConfigs.put(COPY_LOCATION, MySQLCopyLocation);
        
        databaseConfigs.put(BOOK_BOOK_ID, MySQLBookBookID);
        databaseConfigs.put(BOOK_TITLE, MySQLBookTitle);
        databaseConfigs.put(BOOK_AUTHOR, MySQLBookAuthor);
        databaseConfigs.put(BOOK_ISBN, MySQLBookISBN);
        databaseConfigs.put(BOOK_GENRE, MySQLBookGenre);
        databaseConfigs.put(BOOK_DATE, MySQLBookDate);
        databaseConfigs.put(BOOK_DESCRIPTION, MySQLBookDescription);
        
        databaseConfigs.put(LOAN_LOAN_ID, MySQLLoanLoanID);
        databaseConfigs.put(LOAN_USER_ID, MySQLLoanUserID);
        databaseConfigs.put(LOAN_COPY_ID, MySQLLoanCopyID);
        databaseConfigs.put(LOAN_TIME_BORROWED, MySQLLoanTimeBorrowed);
        databaseConfigs.put(LOAN_TIME_RETURNED, MySQLLoanTimeReturned);
        databaseConfigs.put(LOAN_TIME_TO_RETURN, MySQLLoanTimeToReturn);
        databaseConfigs.put(LOAN_FINE_AMOUNT, MySQLLoanFineAmount);
        databaseConfigs.put(LOAN_NUM_OF_EXTEND, MySQLLoanNumOfExtend);
        
    }
    
    public String getDatabaseType(){
        
        return databaseConfigs.get(DATABASE_TYPE);
        
    }
    
    public String getTableUser() {
        
        return databaseConfigs.get(TABLE_USER);
        
    }
    
    public String getTableCopy() {
        
        return databaseConfigs.get(TABLE_COPY);
        
    }
    
    public String getTableBook() {
        
        return databaseConfigs.get(TABLE_BOOK);
        
    }
    
    public String getTableRecord() {
        
        return databaseConfigs.get(TABLE_RECORD);
        
    }
    
    public String getUserUserID() {
        
        return databaseConfigs.get(USER_USER_ID);
        
    }
    
    public String getUserUserTYPE() {
        
        return databaseConfigs.get(USER_USER_TYPE);
        
    }
    
    public String getUserUsername() {
        
        return databaseConfigs.get(USER_USERNAME);
        
    }
    
    public String getUserPassword() {
        
        return databaseConfigs.get(USER_PASSWORD);
        
    }
    
    public String getUserFine() {
        
        return databaseConfigs.get(USER_FINE);
        
    }
    
    public String getUserIsSuspended() {
        
        return databaseConfigs.get(USER_IS_SUSPENDED);
        
    }

}
