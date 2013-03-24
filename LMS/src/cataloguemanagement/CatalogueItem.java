/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;
import datamanagement.*;
import java.sql.SQLException;

/**
 *
 * @author Allen
 */
public class CatalogueItem {
    
    //data field common to all catalogue items
    private String itemID;
    private String location;
    private String author;
    private String title;
    
    //final constant to indicate the type of this item
    public final int BOOK = 1;
    
    //check if the itemID is valid
    public static boolean isValidItem(String itemID) throws SQLException{
        DataStore dataStore = new DataStore();
        return dataStore.isValidItemID(itemID);
    }
    
}
