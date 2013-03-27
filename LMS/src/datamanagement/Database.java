
package datamanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Allen
 */
public abstract class Database {
    
    public static enum Table {
        USER, RECORD, COPY, ITEM
    }
    
    //initialize the connection to the database
    public abstract void initializeConnection () throws SQLException,ClassNotFoundException;
    
    //close the connection to the database
    public abstract void closeConnection() throws SQLException;
    
    public abstract void insertRecord(Table table, ArrayList<String> value) throws SQLException;
    
    public abstract void updateRecord (Table table, ArrayList<String> set, ArrayList<String> where) throws SQLException;
    
    public abstract void deleteRecord (Table table, ArrayList<String> where) throws SQLException;
    
    public abstract ResultSet selectRecord (Table table, ArrayList<String> where) throws SQLException;
    
}
