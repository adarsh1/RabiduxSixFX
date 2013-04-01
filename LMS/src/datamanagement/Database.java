
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
    
    public String getNewID (Table table) throws SQLException, ClassNotFoundException {
        
        String newID = new String();
        initializeConnection();
        
        ResultSet resultSet = selectRecord(Table.RECORD, 1);
        
        if (resultSet.next()) {
            
            newID = resultSet.getString(1);
            newID = Long.toString(Long.parseLong(newID) + 1);
            
        } else {
            
            switch(table) {
                
                case USER : newID = "1000000001";
                            break;
                case COPY : newID = "2000000001";
                            break;
                case BOOK : newID = "3000000001";
                            break;
                case RECORD: newID = "4000000001";
                            break;
                
            }
            
        }
        
        
        return newID;
        
    }
}
