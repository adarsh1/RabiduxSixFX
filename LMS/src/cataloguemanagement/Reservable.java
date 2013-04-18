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
     */
    public abstract void reserve(String userID) throws SQLException, ClassNotFoundException, CopyNotFoundException, CopyNotBorrowedException, NullResultException, CopyReservedException, UserNotFoundException, CopyBorrowedException ;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract boolean isReserved () throws SQLException, ClassNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract boolean isBorrowed () throws SQLException, ClassNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract ReservedCopy getReservedCopy () throws SQLException, ClassNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract PastTransaction getPastTransaction () throws SQLException, ClassNotFoundException;
    
}
