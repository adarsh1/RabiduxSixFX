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
    
    private String tableName;
    private HashMap<String, String> attributeMap;
    
    private Table(String tableName, String[] attributeName) {
        
        this.tableName = tableName;
        attributeMap = new HashMap<> ();
        
        if(tableName.compareTo("user") == 0) {
            
            attributeMap.put("USER_ID", attributeName[0]);
            attributeMap.put("USER_TYPE", attributeName[1]);
            attributeMap.put("USERNAME", attributeName[2]);
            attributeMap.put("PASSWORD", attributeName[3]);
            attributeMap.put("FINE", attributeName[4]);
            attributeMap.put("IS_SUSPENDED", attributeName[5]);
            
        } else if (tableName.compareTo("individual_copy") == 0) {
            
            attributeMap.put("COPY_ID", attributeName[0]);
            attributeMap.put("ITEM_ID", attributeName[1]);
            attributeMap.put("RESERVED_BY", attributeName[2]);
            attributeMap.put("LOCATION", attributeName[3]);
            
        } else if (tableName.compareTo("book") == 0) {
            
            attributeMap.put("BOOK_ID", attributeName[0]);
            attributeMap.put("TITLE", attributeName[1]);
            attributeMap.put("AUTHOR", attributeName[2]);
            attributeMap.put("ISBN", attributeName[3]);
            attributeMap.put("GENRE", attributeName[4]);
            attributeMap.put("DATE", attributeName[5]);
            attributeMap.put("DESCRIPTION", attributeName[6]);
            
        } else if (tableName.compareTo("loan_record") == 0) {
            
            attributeMap.put("LOAN_ID", attributeName[0]);
            attributeMap.put("USER_ID", attributeName[1]);
            attributeMap.put("COPY_ID", attributeName[2]);
            attributeMap.put("TIME_BORROWED", attributeName[3]);
            attributeMap.put("TIME_RETURNED", attributeName[4]);
            attributeMap.put("TIME_TO_RETURN", attributeName[5]);
            attributeMap.put("FINE_AMOUNT", attributeName[6]);
            attributeMap.put("NUM_OF_EXTEND", attributeName[7]);
            
        }
        
    }
    
    public String getTableName() {
        
        return this.tableName;
        
    }
    
    public String getAttribute(String token) {
        
        return this.attributeMap.get(token);
        
    }
    
}
