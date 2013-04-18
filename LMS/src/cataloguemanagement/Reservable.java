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
public interface Reservable extends Displayable {
    
    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws NullResultException
     * @throws CopyNotBorrowedException
     * @throws CopyReservedException 
     * @throws CopyBorrowedException
     * @throws UserNotFoundException  
     */
    public abstract void reserve(String userID) throws SQLException, ClassNotFoundException, CopyNotFoundException, CopyNotBorrowedException, NullResultException, CopyReservedException, UserNotFoundException, CopyBorrowedException ;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws NullResultException  
     */
    public abstract boolean isReserved () throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException ;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException  
     */
    
    public abstract boolean isBorrowed () throws SQLException, ClassNotFoundException, CopyNotFoundException ;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException
     * @throws ItemNotFoundException  
     */
    public abstract ReservedCopy getReservedCopy () throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyNotFoundException 
     * @throws InvalidUserTypeException
     * @throws UserNotFoundException 
     * @throws ItemNotFoundException  
     */
    public abstract PastTransaction getPastTransaction () throws SQLException, ClassNotFoundException, CopyNotFoundException, ItemNotFoundException, UserNotFoundException, InvalidUserTypeException;
    
}
