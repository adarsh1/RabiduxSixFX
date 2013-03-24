
package datamanagement;

import java.sql.SQLException;

/**
 *
 * @author Allen
 */
public class DataStore {
        
    private Database database;
    public DataStore(){
        database = new MySQLDB();
    }
    
    public boolean isValidItemID(String itemID) throws SQLException{
        return database.isValidItemID(itemID);
    }
}
