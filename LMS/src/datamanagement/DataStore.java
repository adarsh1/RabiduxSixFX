
package datamanagement;

import cataloguemanagement.CatalogueItem;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Allen
 */
public class DataStore {
        
    private Database database;
    
    //fields that may be retrieved from databasee
    private String location;
    private String author;
    private String title;
    private String ISBN;
    private String publishYear;
    private String genre;
    private int type;
    
    public DataStore(){
        database = new MySQLDB();
    }
    
    //check if the item id exists in the database
    public boolean isValidItemID(String itemID) throws SQLException, ClassNotFoundException{
        //initialize DB connection
        database.initializeConnection();
        boolean result = database.isValidItemID(itemID);
        //close connection
        database.closeConnection();
        return result;
    }
    
    public void updateItemInfo(String itemID) throws SQLException, ClassNotFoundException{
        //initialize DB connection
        database.initializeConnection();
        //retrieve the result from DB
        ResultSet resultSet = database.getItemInfo(itemID);
        //update all relevant fields
        title = resultSet.getString("title");
        author = resultSet.getString("author");
        location = resultSet.getString("location");
        publishYear = resultSet.getString("publish_year");        
        type = resultSet.getInt("type");
        
        //if it's of book type
        if (getType() == CatalogueItem.BOOK){
            //update ISBN and genre as well
            ISBN = resultSet.getString("ISBN");
            genre = resultSet.getString("genre");
        }
        //close connection
        database.closeConnection();
        
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @return the publishYear
     */
    public String getPublishYear() {
        return publishYear;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }
}
