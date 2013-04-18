/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.*;
import java.sql.SQLException;

/**
 *
 * @author Richard
 */
public interface Returnable extends Displayable {
    
    /**
     *
     * @param fine
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract void returnCopy(double fine) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException ;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract PastTransaction getPastTransaction () throws SQLException, ClassNotFoundException, CopyNotFoundException;
    
}
