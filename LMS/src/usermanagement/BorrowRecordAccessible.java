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
     */
    public abstract ArrayList<PastTransaction> getPastTransactions () throws SQLException, ClassNotFoundException, UserNotFoundException ;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract ArrayList<ReservedCopy> getReservedCopies() throws SQLException, ClassNotFoundException, UserNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract ArrayList<CurrentHolding> getCurrentHoldingItems() throws SQLException, ClassNotFoundException, UserNotFoundException;
    
}
