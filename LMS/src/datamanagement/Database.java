
package datamanagement;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Allen
 */
public abstract class Database {
    
    public Database() {
        
    }
    
    //initialize the connection to the database
    public abstract void initializeConnection () throws SQLException,ClassNotFoundException;
    
    //close the connection to the database
    public abstract void closeConnection() throws SQLException;
    
    public abstract void insertRecord(Table table, ArrayList<String> values) throws SQLException;
    
    public abstract void updateRecord (Table table, ArrayList<String> set, ArrayList<String> where) throws SQLException;
    
    public abstract void deleteRecord (Table table, ArrayList<String> where) throws SQLException;
    
    public abstract ResultSet selectRecord (Table table, ArrayList<String> where) throws SQLException;
    
    public abstract ResultSet selectRecord (Table table, int top) throws SQLException;
    
    public abstract ResultSet selectRecord (Table table, ArrayList<String> where, int top) throws SQLException;
    
    public int getNumOfRows (ResultSet resultSet) throws SQLException {
        
        int numOfRows;
        
        resultSet.last();
        numOfRows = resultSet.getRow();
        resultSet.beforeFirst();
        
        return numOfRows;
    }
    
    public String getNewID (Table table) throws SQLException {
        
        ResultSet resultSet = selectRecord(table, 1);
        
        resultSet.next();
        String newID = resultSet.getString(1);
        
        newID = Integer.toString(Integer.parseInt(newID) + 1);
        
        return newID;
        
    }
}
