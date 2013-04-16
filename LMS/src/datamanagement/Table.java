/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

import java.util.*;

/**
 *
 * @author Haohang
 */
public enum Table {
    
    USER("user", new String[] {"user_id", "user_type", "username", "password", "fine", "is_suspended"} ), 
    COPY("individual_copy", new String[] {"copy_id", "item_id", "reserved_by", "location"}), 
    BOOK("book", new String[] {"book_id", "title", "author", "isbn", "genre", "date", "description"}), 
    RECORD("loan_record", new String[] {"loan_id", "user_id", "copy_id", "time_borrowed", "time_returned", "time_to_return", "fine_amount", "num_of_extend"});
    
    public static final String USER_USER_ID = "USER_ID";
    public static final String USER_USER_TYPE = "USER_TYPE";
    public static final String USER_USERNAME = "USERNAME";
    public static final String USER_PASSWORD = "PASSWORD";
    public static final String USER_FINE = "FINE";
    public static final String USER_IS_SUSPENDED = "IS_SUSPENDED";
    
    public static final String COPY_COPY_ID = "COPY_ID";
    public static final String COPY_ITEM_ID = "ITEM_ID";
    public static final String COPY_RESERVED_BY = "RESERVED_BY";
    public static final String COPY_LOCATION = "LOCATION";
    
    public static final String BOOK_BOOK_ID = "BOOK_ID";
    public static final String BOOK_TITLE = "TITLE";
    public static final String BOOK_AUTHOR = "AUTHOR";
    public static final String BOOK_ISBN = "ISBN";
    public static final String BOOK_GENRE = "GENRE";
    public static final String BOOK_DATE = "DATE";
    public static final String BOOK_DESCRIPTION = "DESCRIPTION";
    
    public static final String RECORD_LOAN_ID = "LOAN_ID";
    public static final String RECORD_USER_ID = "USER_ID";
    public static final String RECORD_COPY_ID = "COPY_ID";
    public static final String RECORD_TIME_BORROWED = "TIME_BORROWED";
    public static final String RECORD_TIME_RETURNED = "TIME_RETURNED";
    public static final String RECORD_TIME_TO_RETURN = "TIME_TO_RETURN";
    public static final String RECORD_FINE_AMOUNT = "FINE_AMOUNT";
    public static final String RECORD_NUM_OF_EXTEND = "NUM_OF_EXTEND";
    
    private String tableName;
    private HashMap<String, String> attributeMap;
    
    private Table(String tableName, String[] attributeName) {
        
        this.tableName = tableName;
        attributeMap = new HashMap<> ();
        
        if(tableName.compareTo("user") == 0) {
            
            attributeMap.put(USER_USER_ID, attributeName[0]);
            attributeMap.put(USER_USER_TYPE, attributeName[1]);
            attributeMap.put(USER_USERNAME, attributeName[2]);
            attributeMap.put(USER_PASSWORD, attributeName[3]);
            attributeMap.put(USER_FINE, attributeName[4]);
            attributeMap.put(USER_IS_SUSPENDED, attributeName[5]);
            
        } else if (tableName.compareTo("individual_copy") == 0) {
            
            attributeMap.put(COPY_COPY_ID, attributeName[0]);
            attributeMap.put(COPY_ITEM_ID, attributeName[1]);
            attributeMap.put(COPY_RESERVED_BY, attributeName[2]);
            attributeMap.put(COPY_LOCATION, attributeName[3]);
            
        } else if (tableName.compareTo("book") == 0) {
            
            attributeMap.put(BOOK_BOOK_ID, attributeName[0]);
            attributeMap.put(BOOK_TITLE, attributeName[1]);
            attributeMap.put(BOOK_AUTHOR, attributeName[2]);
            attributeMap.put(BOOK_ISBN, attributeName[3]);
            attributeMap.put(BOOK_GENRE, attributeName[4]);
            attributeMap.put(BOOK_DATE, attributeName[5]);
            attributeMap.put(BOOK_DESCRIPTION, attributeName[6]);
            
        } else if (tableName.compareTo("loan_record") == 0) {
            
            attributeMap.put(RECORD_LOAN_ID, attributeName[0]);
            attributeMap.put(RECORD_USER_ID, attributeName[1]);
            attributeMap.put(RECORD_COPY_ID, attributeName[2]);
            attributeMap.put(RECORD_TIME_BORROWED, attributeName[3]);
            attributeMap.put(RECORD_TIME_RETURNED, attributeName[4]);
            attributeMap.put(RECORD_TIME_TO_RETURN, attributeName[5]);
            attributeMap.put(RECORD_FINE_AMOUNT, attributeName[6]);
            attributeMap.put(RECORD_NUM_OF_EXTEND, attributeName[7]);
            
        }
        
    }
    
    public String getTableName() {
        
        return this.tableName;
        
    }
    
    public String getAttribute(String token) {
        
        return this.attributeMap.get(token);
        
    }
    
}
