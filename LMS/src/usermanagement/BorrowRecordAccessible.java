/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import cataloguemanagement.*;
import exception.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Allen
 */
public interface BorrowRecordAccessible {
    
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException 
     * @throws InvalidUserTypeException  
     */
    public abstract ArrayList<PastTransaction> getPastTransactions () throws SQLException, ClassNotFoundException, UserNotFoundException, CopyNotFoundException, ItemNotFoundException, InvalidUserTypeException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException 
     * @throws CopyNotFoundException 
     * @throws ItemNotFoundException  
     */
    public abstract ArrayList<ReservedCopy> getReservedCopies() throws SQLException, ClassNotFoundException, UserNotFoundException, CopyNotFoundException, ItemNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserNotFoundException 
     * @throws CopyNotFoundException
     * @throws ItemNotFoundException  
     */
    public abstract ArrayList<CurrentHolding> getCurrentHoldingItems() throws SQLException, ClassNotFoundException, UserNotFoundException, CopyNotFoundException, ItemNotFoundException;
    
}
