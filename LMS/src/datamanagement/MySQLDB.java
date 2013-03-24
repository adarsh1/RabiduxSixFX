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
public class MySQLDB extends Database{
    
    //resultSet used to store info retrieved from DB
    private ResultSet resultSet;
    //connnection to the MySQL database
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
    
    //initialize the connection to the database
    @Override
    public void initializeConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/rabidusDB","root","password");
    }
    
    //close the connection to the database
    @Override
    public void closeConnection() throws SQLException{
        connection.close();
    }
    
    public void queryItemInfo(String itemID) throws SQLException{
        
    }
    
    //fetch the title of an item
    @Override
    public String fechTitle() throws SQLException{
        return resultSet.getString("title");
    }
    
    //fetch the author of an item
    @Override
    public String fetchAuthor() throws SQLException{
        return resultSet.getString("author");
        
    }
    
    //fetch the year published
    @Override
    public String fetchPublishYear() throws SQLException{
        return resultSet.getString("publish_year");
    }
    
    //fech the ISBN of a book
    @Override
    public String fetchISBN() throws SQLException{
        return resultSet.getString("ISBN");
    }
    
    //fetch the genre of a book
    @Override
    public String fetchGenre() throws SQLException{
        return resultSet.getString("genre");
    }
    
    //check if an itemID exists in DB
    @Override
    public boolean isValidItemID(String itemID) throws SQLException{
        //form a query
        String query = "SELECT * FROM  catalogue_item WHERE item_id=?";
        PreparedStatement statement = connection.prepareStatement(query); 
        statement.setString(1, itemID);
        //execute the query
        resultSet = statement.executeQuery(query);
        //count the number of rows
        int numberOfRows = getNumberOfRows(resultSet);
        //if number of rows equals 0, return false
        return (numberOfRows != 0);
    }
    
    //get all the info of a particular type of item
    @Override
    public ResultSet getItemInfo(String itemID) throws SQLException{
        //form a query to determine the type of this item
        String query = "SELECT type FROM catalogue_item WHERE item_id=?";
        PreparedStatement statement = connection.prepareStatement(query); 
        statement.setString(1, itemID);
        //execute the query
        resultSet = statement.executeQuery(query);
        
        //if the item is of book type
        if (resultSet.getInt("type") == CatalogueItem.BOOK){
            //form a query to retrieve the info of this book
            query = "SELECT * FROM catalogue_item INNER JOIN book ON item_id = book_id WHERE item_id=?";
            statement = connection.prepareStatement(query); 
            statement.setString(1, itemID);
            //execute the query
            resultSet = statement.executeQuery(query);
        }
        return resultSet;
    }
    
    //get the info of a user of any type
    @Override
    public ResultSet getUserInfo(String userID) throws SQLException{
        //form a query to determine the type of this item
        String query = "SELECT * FROM user WHERE user_id=?";
        PreparedStatement statement = connection.prepareStatement(query); 
        statement.setString(1, userID);
        //execute the query
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
    
    //get all the current holdings of a given member
    @Override
    public ResultSet getCurrentHoldingItem(String memberID) throws SQLException{
        //form a query to determine the type of this item
        String query = "SELECT type FROM loan_record WHERE user_id=? AND time_returned IS NULL";
        PreparedStatement statement = connection.prepareStatement(query); 
        statement.setString(1, memberID);
        //execute the query
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
    
    //check if a combiantion of username and password exists in DB
    @Override
    public boolean isValidUser(String userID, String password) throws SQLException{
        //form a query
        String query = "SELECT * FROM  user WHERE account_name=? and password=?";
        PreparedStatement statement = connection.prepareStatement(query); 
        statement.setString(1, userID);
        statement.setString(2, password);
        //execute the query
        resultSet = statement.executeQuery(query);
        //count the number of rows
        int numberOfRows = getNumberOfRows(resultSet);
        //if number of rows equals 0, return false
        return (numberOfRows != 0);
    }
    
    //count the number of rows in a result set
    @Override
    public int getNumberOfRows(ResultSet resultSet) throws SQLException{
        int counter = 0;
        //iterate to see how many rows in the resultSet
        while (resultSet.next()) {
            ++counter;
        }
        return counter;
    }
    
    
}
