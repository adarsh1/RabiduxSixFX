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
    
    public static void main (String[] args) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sbcc_2013","root","password")) {
            System.out.println("Database Connected");
                           
            String query  = "select * from admin";
            Statement statement = connection.createStatement();
            //String query = "insert into admin (account, password) values (?,?)";
            //PreparedStatement statement = connection.prepareStatement(query);
            
            //statement.setString(1, "Java");
            //statement.setString(2, "Java");
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){
                System.out.println(resultSet.getString("passwor"));
            }
        }
    }
    
    public MySQLDB () {
        
    }
    
    //initialize the connection to the database
    @Override
    public void initializeConnection() throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/rabidusDB","root","root");
        
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
            
            case USER : queryStr += "INSERT INTO user (user_id, user_type, account_name, password, fine, is_suspended) VALUES (?,?,?,?,?,?)";
                        break;
            case RECORD: queryStr += "INSERT INTO loan_record (loan_id, user_id, copy_id, time_borrowed, time_returned, time_to_return, fine_amount) VALUES (?,?,?,?,?,?,?)";
                         break;
            case COPY: queryStr += "INSERT INTO individual_copy (copy_id, item_id, reserved_by, location) VALUES (?,?,?,?)";
                       break;
            case ITEM: queryStr += "INSERT INTO catalogue_item (item_id, title, author, isbn, genre, date, description) VALUES (?,?,?,?,?,?,?)";
                       break;
        }
                
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < values.size(); i++) {
            
            statement.setString(i + 1, values.get(i));
            
        }
        
    }
    
    @Override
    public void updateRecord (Table table, ArrayList<String> set, ArrayList<String> where) throws SQLException {
        
        String queryStr = new String();
        PreparedStatement statement;
        
        switch (table) {
            
            case USER : queryStr += "UPDATE user SET user_type=?, account_name=?, password=?, fine=?, is_suspended=? WHERE user_id=?";
                        break;
            case RECORD: queryStr += "UPDATE loan_record SET time_borrowed=?, time_returned=?, time_to_return=?, fine_amount=? WHERE loan_id=?";
                         break;
            case COPY: queryStr += "UPDATE individual_copy SET reserved_by=?, location=? WHERE copy_id=?";
                       break;
            case ITEM: queryStr += "UPDATE catalogue_item SET title=?, author=?, isbn=?, genre=?, date=?, description=? WHERE item_id=?";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < set.size(); i++) {
            
            statement.setString(i + 1, set.get(i));
            
        }
        
        for (int i = 0; i < where.size(); i++) {
            
            statement.setString(i + 1 + set.size(), where.get(i));
            
        }
        
    }
    
    @Override
    public void deleteRecord (Table table, ArrayList<String> where) throws SQLException{
        
        String queryStr = new String();
        PreparedStatement statement;
        
        switch (table) {
            
            case USER : queryStr += "DELETE user WHERE user_id=?";
                        break;
            case RECORD: queryStr += "DELETE loan_record WHERE loan_id=?";
                         break;
            case COPY: queryStr += "DELETE individual_copy WHERE copy_id=?";
                       break;
            case ITEM: queryStr += "DELETE catalogue_item WHERE item_id=?";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++) {
            
            statement.setString(i + 1, where.get(i));
            
        }
        
    }
    
    @Override
    public ResultSet selectRecord (Table table, ArrayList<String> where) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = new String();
        
        switch (table) {
            
            case USER : queryStr += "SELECT * FROM user WHERE user_id LIKE ?";
                        break;
            case RECORD: queryStr += "SELECT * FROM loan_record WHERE loan_id LIKE ? AND user_id LIKE ? AND copy_id LIKE ?";
                         break;
            case COPY: queryStr += "SELECT * FROM individual_copy WHERE copy_id LIKE ? AND item_id LIKE ? AND reserved_by LIKE ?";
                       break;
            case ITEM: queryStr += "SELECT * FROM catalogue_item WHERE item_id LIKE ?";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++ ) {
            
            statement.setString(i + 1, where.get(i));
            
        }
        
        resultSet = statement.executeQuery();
        
        return resultSet;
    }
    
    @Override
    public ResultSet selectRecord (Table table, int top) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = "SELECT TOP " + Integer.toString(top);
        
        switch (table) {
            
            case USER : queryStr += " * FROM user ORDER BY user_id DESC";
                        break;
            case RECORD: queryStr += " * FROM loan_record ORDER BY loan_id DESC";
                         break;
            case COPY: queryStr += " * FROM individual_copy ORDER BY copy_id DESC";
                       break;
            case ITEM: queryStr += " * FROM catalogue_item ORDER BY item_id DESC";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        resultSet = statement.executeQuery();
        
        return resultSet;
        
    }
    
    @Override
    public ResultSet selectRecord (Table table, ArrayList<String> where, int top) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = "SELECT TOP " + Integer.toString(top);
        
        switch (table) {
            
            case USER : queryStr += " * FROM user WHERE user_id LIKE ? ORDER BY user_id DESC";
                        break;
            case RECORD: queryStr += " * FROM loan_record WHERE loan_id LIKE ? AND user_id LIKE ? AND copy_id LIKE ? ORDER BY loan_id DESC";
                         break;
            case COPY: queryStr += " * FROM individual_copy WHERE copy_id LIKE ? AND item_id LIKE ? AND reserved_by LIKE ? ORDER BY copy_id DESC";
                       break;
            case ITEM: queryStr += " * FROM catalogue_item WHERE item_id LIKE ? ORDER BY item_id DESC";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++ ) {
            
            statement.setString(i + 1, where.get(i));
            
        }
        
        resultSet = statement.executeQuery();
        
        return resultSet;
        
    }
    
}
