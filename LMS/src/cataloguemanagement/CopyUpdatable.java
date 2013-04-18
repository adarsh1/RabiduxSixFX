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
public interface CopyUpdatable{
    
    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract void addNewCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException ;
    /**
     *
     * @param details
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws NullResultException
     */
    public abstract void updateCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException;
    /**
     *
     * @param copyID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws NullResultException
     */
    public abstract HashMap<String, Object> getCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException;
    /**
     *
     * @param copyID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     */
    public abstract void deleteCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException;
    
}
