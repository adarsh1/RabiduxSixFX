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
    
    public abstract void addNewCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException ;
    public abstract void updateCopy(HashMap<String, Object> details) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException;
    public abstract HashMap<String, Object> getCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException;
    public abstract void deleteCopy(String copyID) throws SQLException, ClassNotFoundException, CopyNotFoundException;
    
}
