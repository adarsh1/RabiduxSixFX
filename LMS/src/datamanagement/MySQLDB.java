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

/**
 *
 * @author Allen
 */
public class MySQLDB extends Database{
    
    private Connection connection;
    private String host;
    private String databaseName;
    private String user;
    private String password;
    
    /**
     *
     * @param host
     * @param databaseName
     * @param user
     * @param password
     */
    public MySQLDB (String host,String databaseName, String user, String password) {
        
        super();
        this.host = host;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;        
    }
    
    //initialize the connection to the database
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void initializeConnection() throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        //setConnection(DriverManager.getConnection("jdbc:mysql://localhost/rabidusDB","root","password"));
        setConnection(DriverManager.getConnection( host + ":3306/" + databaseName, user, password));
        
    }
    
    //close the connection to the database
    /**
     *
     * @throws SQLException
     */
    @Override
    public void closeConnection() throws SQLException{
        getConnection().close();
    }
    
    /**
     *
     * @param table
     * @param values
     * @throws SQLException
     */
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
                
        statement = getConnection().prepareStatement(queryStr);
        
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
    
    /**
     *
     * @param table
     * @param set
     * @param where
     * @throws SQLException
     */
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
        
        statement = getConnection().prepareStatement(queryStr);
        
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
    
    /**
     *
     * @param table
     * @param where
     * @throws SQLException
     */
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
        
        statement = getConnection().prepareStatement(queryStr);
        
        for (int i = 0; i < where.size(); i++) {
            
            statement.setString(i + 1, where.get(i));
            
        }
        
        statement.executeUpdate();
        
    }
    
    /**
     *
     * @param table
     * @param where
     * @return
     * @throws SQLException
     */
    @Override
    public ResultSet selectRecord (Table table, ArrayList<String> where) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = new String();
        
        switch (table) {
            
            case USER : queryStr += "SELECT * FROM user WHERE user_id LIKE ? AND username LIKE ?";
                        break;
            case RECORD: queryStr += "SELECT * FROM loan_record WHERE loan_id LIKE ? AND user_id LIKE ? AND copy_id LIKE ? AND time_returned LIKE ?";
                         break;
            case COPY: queryStr += "SELECT * FROM individual_copy WHERE copy_id LIKE ? AND item_id LIKE ? AND reserved_by LIKE ?";
                       break;
            case BOOK: queryStr += "SELECT * FROM book WHERE book_id LIKE ? AND title LIKE ? AND author LIKE ? AND isbn LIKE ? AND genre LIKE ?";
                       break;
        }
        
        if (table == Table.RECORD && where.get(3).compareTo(DataStore.WILDCARD_CHAR) == 0) {
            
            queryStr = queryStr.replace(" AND time_returned LIKE ?", " ");
            where.remove(3);
            
        } else if (table == Table.RECORD && where.get(3).compareTo(DataStore.NULL_DATETIME) == 0) {
            
            queryStr = queryStr.replace(" AND time_returned LIKE ?", " AND time_returned IS NULL");
            where.remove(3);
            
        }
        
        if (table == Table.COPY && where.get(2).compareTo(DataStore.WILDCARD_CHAR) == 0) {
            
            queryStr = queryStr.replace(" AND reserved_by LIKE ?", " ");
            where.remove(2);
            
        } else if (table == Table.COPY && where.get(2).compareTo(DataStore.NULL_VARCHAR) == 0) {
            
            queryStr = queryStr.replace(" AND reserved_by LIKE ?", " AND reserved_by IS NULL");
            where.remove(2);
            
        }
        
        statement = getConnection().prepareStatement(queryStr);
        
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
    
    /**
     *
     * @param table
     * @param top
     * @return
     * @throws SQLException
     */
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
        
        statement = getConnection().prepareStatement(queryStr);
        
        resultSet = statement.executeQuery();
        
        return resultSet;
        
    }
    
    /**
     *
     * @param table
     * @param where
     * @param top
     * @return
     * @throws SQLException
     */
    @Override
    public ResultSet selectRecord (Table table, ArrayList<String> where, int top) throws SQLException {
        
        ResultSet resultSet;
        PreparedStatement statement;
        String queryStr = null;
        
        switch (table) {
            
            case USER : queryStr = "SELECT * FROM user WHERE user_id LIKE ? AND username LIKE ? ORDER BY user_id DESC";
                        break;
            case RECORD: queryStr = "SELECT * FROM loan_record WHERE loan_id LIKE ? AND user_id LIKE ? AND copy_id LIKE ? AND time_returned LIKE ? ORDER BY loan_id DESC";
                         break;
            case COPY: queryStr = "SELECT * FROM individual_copy WHERE copy_id LIKE ? AND item_id LIKE ? AND reserved_by LIKE ? ORDER BY copy_id DESC";
                       break;
            case BOOK: queryStr = "SELECT * FROM book WHERE book_id LIKE ? ORDER BY book_id DESC";
                       break;
        }
        
        queryStr += " LIMIT " + Integer.toString(top);
        
        if (table == Table.RECORD && where.get(3).compareTo(DataStore.WILDCARD_CHAR) == 0) {
            
            queryStr = queryStr.replace(" AND time_returned LIKE ? ", " ");
            where.remove(3);
            
        } else if (table == Table.RECORD && where.get(3).compareTo(DataStore.NULL_DATETIME) == 0) {
            
            queryStr = queryStr.replace(" AND time_returned LIKE ? ", " AND time_returned IS NULL ");
            where.remove(3);
            
        }
        
        if (table == Table.COPY && where.get(2).compareTo(DataStore.WILDCARD_CHAR) == 0) {
            
            queryStr = queryStr.replace(" AND reserved_by LIKE ? ", " ");
            where.remove(2);
            
        } else if (table == Table.COPY && where.get(2).compareTo(DataStore.NULL_VARCHAR) == 0) {
            
            queryStr = queryStr.replace(" AND reserved_by LIKE ? ", " AND reserved_by IS NULL ");
            where.remove(2);
            
        }
        
        statement = getConnection().prepareStatement(queryStr);
        
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

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the databaseName
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * @param databaseName the databaseName to set
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
