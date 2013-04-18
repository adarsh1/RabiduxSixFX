/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.*;
import java.sql.*;

/**
 *
 * @author Richard
 */
public interface Borrowable extends Displayable {
   
    /**
     *
     * @param userID
     * @param loanDuration
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws CopyBorrowedException 
     * @throws CopyNotFoundException
     * @throws UserNotFoundException
     * @throws CopyReservedException
     * @throws NullResultException  
     */
    public abstract PastTransaction borrow (String userID, int loanDuration) throws SQLException, ClassNotFoundException, CopyBorrowedException, CopyNotFoundException, UserNotFoundException, NullResultException, CopyReservedException;
   
    
}
