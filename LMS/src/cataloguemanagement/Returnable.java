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
     * @throws CopyNotFoundException 
     * @throws NullResultException
     * @throws CopyNotBorrowedException  
     */
    public abstract void returnCopy(double fine) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException, CopyNotBorrowedException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws InvalidUserTypeException
     * @throws ItemNotFoundException
     * @throws UserNotFoundException  
     */
    public abstract PastTransaction getPastTransaction () throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException, UserNotFoundException, InvalidUserTypeException;
    
}
