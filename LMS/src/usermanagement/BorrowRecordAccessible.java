/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedCopy;
import cataloguemanagement.PastTransaction;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Allen
 */
public interface BorrowRecordAccessible {
    
    public abstract ArrayList<PastTransaction> getPastTransactions (String userID) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<ReservedCopy> getReservedCopies(String userID) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<CurrentHolding> getCurrentHoldingItems(String userID) throws SQLException, ClassNotFoundException;
    
}
