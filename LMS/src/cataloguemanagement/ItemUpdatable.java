/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Haohang
 */
public interface ItemUpdatable {
    
    public abstract void addNewItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException ;
    public abstract void updateItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException ;
    public abstract HashMap<String, Object> getItem(String itemID) throws SQLException, ClassNotFoundException ;
    public abstract void deleteItem(String itemID) throws SQLException, ClassNotFoundException ;
    
}
