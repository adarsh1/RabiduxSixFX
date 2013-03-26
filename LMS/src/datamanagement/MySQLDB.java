/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

/**
 *
 * @author Allen
 */

import cataloguemanagement.CatalogueItem;
import java.sql.*;
import java.util.*;

public class MySQLDB extends Database{
    
    private ResultSet resultSet;
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
    public void insertRecord (Table table, ArrayList<String> value) throws SQLException {
        
        String queryStr = new String();
        PreparedStatement statement;
        
        switch (table) {
            
            case USER : queryStr += "INSERT INTO user (user_id, user_type, account_name, password, fine, is_suspended) VALUES (?,?,?,?,?,?)";
                        break;
            case RECORD: queryStr += "INSERT INTO loan_record (loan_id, user_id, book_id, time_borrowed, time_returned, time_to_return, fine_amount) VALUES (?,?,?,?,?,?,?)";
                         break;
            case COPY: queryStr += "INSERT INTO individual_copy (copy_id, item_id, reserved_by, location) VALUES (?,?,?,?)";
                       break;
            case ITEM: queryStr += "INSERT INTO catalogue_item (item_id, title, author, isbn, genre, date, description) VALUES (?,?,?,?,?,?,?)";
                       break;
        }
                
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < value.size(); i++) {
            
            statement.setString(i + 1, value.get(i));
            
        }
        
    }
    
    @Override
    public void updateRecord (Table table, ArrayList<String> set, ArrayList<String> where) throws SQLException {
        
        String queryStr = new String();
        PreparedStatement statement;
        
        switch (table) {
            
            case USER : queryStr += "UPDATE user SET user_type=?, account_name=?, password=?, fine=?, is_suspended=? WHERE user_id=?";
                        break;
            case RECORD: queryStr += "UPDATE loan_record SET time_borrowed=?, time_returned=?, time_to_return=?, fine_amount=? WHERE user_id=? AND book_id=?";
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
            case RECORD: queryStr += "DELETE WHERE user_id=? AND book_id=?";
                         break;
            case COPY: queryStr += "DELETE WHERE copy_id=?";
                       break;
            case ITEM: queryStr += "DELETE WHERE item_id=?";
                       break;
        }
        
        statement = connection.prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++) {
            
            statement.setString(i + 1, where.get(i));
            
        }
        
    }
    
    @Override
    public ResultSet selectRecord (Table table) throws SQLException {
        
        
        return resultSet;
    }
    
}
