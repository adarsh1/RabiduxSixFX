/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastore;

/**
 *
 * @author Allen
 */

import java.sql.*;
public class SimpleJDBC {
    public static void main (String[] args) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sbcc_2013","root","password")) {
            System.out.println("Database Connected");
                                 
            String query = "insert into admin (account, password) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, "Java");
            statement.setString(2, "Java");
            
            int resultSet = statement.executeUpdate();
            
            if (resultSet==1){
                System.out.println(resultSet);
            }
        }
    }
}
