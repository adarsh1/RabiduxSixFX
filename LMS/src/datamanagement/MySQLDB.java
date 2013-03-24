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
    public void initializeConnection () throws SQLException, ClassNotFoundException{
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
    
    public int getNumberOfRows(ResultSet resultSet) throws SQLException{
        int counter = 0;
        //iterate to see how many rows in the resultSet
        while (resultSet.next()) {
            ++counter;
        }
        return counter;
    }
}
