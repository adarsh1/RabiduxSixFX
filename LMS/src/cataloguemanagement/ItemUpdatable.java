/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.*;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Haohang
 */
public interface ItemUpdatable {
    
    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InvalidItemTypeException
     */
    public abstract void addNewItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, InvalidItemTypeException;
    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws InvalidItemTypeException
     */
    public abstract void updateItem(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, ItemNotFoundException, InvalidItemTypeException;
    /**
     *
     * @param itemID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws NullResultException
     * @throws InvalidItemTypeException
     */
    public abstract HashMap<String, Object> getItem(String itemID) throws SQLException, ClassNotFoundException, ItemNotFoundException, NullResultException, InvalidItemTypeException;
    /**
     *
     * @param itemID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ItemNotFoundException
     * @throws InvalidItemTypeException
     */
    public abstract void deleteItem(String itemID) throws SQLException, ClassNotFoundException, ItemNotFoundException, InvalidItemTypeException;
    
}
