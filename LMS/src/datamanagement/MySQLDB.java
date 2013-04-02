/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

/**
 *
 * @author Allen
 */

import java.sql.*;
import java.util.*;

public class MySQLDB extends Database{
    
    private Connection connection;
    
    public MySQLDB () {
        
        super();
        
    }
    
    //initialize the connection to the database
    @Override
    public void initializeConnection() throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/rabidusDB","root","password");
        
    }
    
    //close the connection to the database
    @Override
    public void closeConnection() throws SQLException{
        connection.close();
    }
    
    @Override
    public void insertRecord (Table table, ArrayList<String> values) throws SQLException {
        
        String queryStr = new String();
        PreparedStatement statement;
        
        switch (table) {
            
            case USER : queryStr += "INSERT INTO user (user_id, user_type, username, password, fine, is_suspended) VALUES (?,?,?,?,?,?)";
                        break;
            case RECORD: queryStr += "INSERT INTO loan_record (loan_id, user_id, copy_id, time_borrowed, time_to_return, fine_amount, num_of_extend) VALUES (?,?,?,?,?,?,?)";
                         break;
            case COPY: queryStr += "INSERT INTO individual_copy (copy_id, item_id, reserved_by, location) VALUES (?,?,?,?)";
                       break;
            case BOOK: queryStr += "INSERT INTO book (book_id, title, author, isbn, genre, date, description) VALUES (?,?,?,?,?,?,?)";
                       break;
        }
                
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < values.size(); i++) {
            
            if (values.get(i).compareTo(DataStore.NULL_VARCHAR) == 0) {
                
                statement.setNull(i + 1, Types.VARCHAR);
                
            } else if (values.get(i).compareTo(DataStore.NULL_DATETIME) == 0) {
                
                statement.setNull(i + 1, Types.TIMESTAMP);
                
            } else {
            
                statement.setString(i + 1, values.get(i));
                
            }
        }
        
        statement.executeUpdate();
        
    }
    
    @Override
    public void updateRecord (Table table, ArrayList<String> set, ArrayList<String> where) throws SQLException {
        
        String queryStr = new String();
        PreparedStatement statement;
        
        switch (table) {
            
            case USER : queryStr += "UPDATE user SET user_type=?, username=?, password=?, fine=?, is_suspended=? WHERE user_id=?";
                        break;
            case RECORD: queryStr += "UPDATE loan_record SET time_borrowed=?, time_returned=?, time_to_return=?, fine_amount=?, num_of_extend=? WHERE loan_id=?";
                         break;
            case COPY: queryStr += "UPDATE individual_copy SET reserved_by=?, location=? WHERE copy_id=?";
                       break;
            case BOOK: queryStr += "UPDATE book SET title=?, author=?, isbn=?, genre=?, date=?, description=? WHERE book_id=?";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < set.size(); i++) {
            
            if (set.get(i).compareTo(DataStore.NULL_VARCHAR) == 0) {
                
                statement.setNull(i + 1, Types.VARCHAR);
                
            } else if (set.get(i).compareTo(DataStore.NULL_DATETIME) == 0) {
                
                statement.setNull(i + 1, Types.TIMESTAMP);
                
            } else {
            
                statement.setString(i + 1, set.get(i));
            
            }
            
        }
        
        for (int i = 0; i < where.size(); i++) {
            
            statement.setString(i + 1 + set.size(), where.get(i));
            
        }
        
        statement.executeUpdate();
        
    }
    
    @Override
    public void deleteRecord (Table table, ArrayList<String> where) throws SQLException{
        
        String queryStr = new String();
        PreparedStatement statement;
        
        switch (table) {
            
            case USER : queryStr += "DELETE FROM user WHERE user_id=?";
                        break;
            case RECORD: queryStr += "DELETE FROM loan_record WHERE loan_id=?";
                         break;
            case COPY: queryStr += "DELETE FROM individual_copy WHERE copy_id=?";
                       break;
            case BOOK: queryStr += "DELETE FROM book WHERE book_id=?";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++) {
            
            statement.setString(i + 1, where.get(i));
            
        }
        
        statement.executeUpdate();
        
    }
    
    @Override
    public ResultSet selectRecord (Table table, ArrayList<String> where) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = new String();
        
        switch (table) {
            
            case USER : queryStr += "SELECT * FROM user WHERE user_id LIKE ? AND username LIKE ?";
                        break;
            case RECORD: queryStr += "SELECT * FROM loan_record WHERE loan_id LIKE ? AND user_id LIKE ? AND copy_id LIKE ?";
                         break;
            case COPY: queryStr += "SELECT * FROM individual_copy WHERE copy_id LIKE ? AND item_id LIKE ? AND reserved_by LIKE ?";
                       break;
            case BOOK: queryStr += "SELECT * FROM book WHERE book_id LIKE ? AND title LIKE ? AND author LIKE ? AND isbn LIKE ? AND genre LIKE ?";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++ ) {
            
            if (where.get(i).compareTo(DataStore.NULL_VARCHAR) == 0) {
                
                statement.setNull(i + 1, Types.VARCHAR);
                
            } else if (where.get(i).compareTo(DataStore.NULL_DATETIME) == 0) {
                
                statement.setNull(i + 1, Types.TIMESTAMP);
                
            } else {
            
                statement.setString(i + 1, where.get(i));
            
            }
            
        }
        
        resultSet = statement.executeQuery();
        
        return resultSet;
    }
    
    @Override
    public ResultSet selectRecord (Table table, int top) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = null;
        
        switch (table) {
            
            case USER : queryStr = "SELECT * FROM user ORDER BY user_id DESC";
                        break;
            case RECORD: queryStr = "SELECT * FROM loan_record ORDER BY loan_id DESC";
                         break;
            case COPY: queryStr = "SELECT * FROM individual_copy ORDER BY copy_id DESC";
                       break;
            case BOOK: queryStr = "SELECT * FROM book ORDER BY book_id DESC";
                       break;
        }
        
        queryStr += " LIMIT " + Integer.toString(top);
        
        statement = connection.prepareStatement(queryStr);
        
        resultSet = statement.executeQuery();
        
        return resultSet;
        
    }
    
    @Override
    public ResultSet selectRecord (Table table, ArrayList<String> where, int top) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = null;
        
        switch (table) {
            
            case USER : queryStr = "SELECT * FROM user WHERE user_id LIKE ? AND username LIKE ? ORDER BY user_id DESC";
                        break;
            case RECORD: queryStr = "SELECT * FROM loan_record WHERE loan_id LIKE ? AND user_id LIKE ? AND copy_id LIKE ? ORDER BY loan_id DESC";
                         break;
            case COPY: queryStr = "SELECT * FROM individual_copy WHERE copy_id LIKE ? AND item_id LIKE ? AND reserved_by LIKE ? ORDER BY copy_id DESC";
                       break;
            case BOOK: queryStr = "SELECT * FROM book WHERE book_id LIKE ? ORDER BY book_id DESC";
                       break;
        }
        
        queryStr += " LIMIT " + Integer.toString(top);
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++ ) {
            
            if (where.get(i).compareTo(DataStore.NULL_VARCHAR) == 0) {
                
                statement.setNull(i + 1, Types.VARCHAR);
                
            } else if (where.get(i).compareTo(DataStore.NULL_DATETIME) == 0) {
                
                statement.setNull(i + 1, Types.TIMESTAMP);
                
            } else {
            
                statement.setString(i + 1, where.get(i));
            
            }
            
        }
        
        resultSet = statement.executeQuery();
        
        return resultSet;
        
    }
    
}
