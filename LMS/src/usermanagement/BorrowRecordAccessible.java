/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import cataloguemanagement.CurrentHoldings;
import cataloguemanagement.ReservedCopy;
import cataloguemanagement.PastTransaction;
import java.util.ArrayList;

/**
 *
 * @author Allen
 */
public interface BorrowRecordAccessible {
    public abstract ArrayList<PastTransaction> getTransactionHistoryItems(String memberID);
    public abstract ArrayList<ReservedCopy> getReservedItems(String memberID);
    public abstract ArrayList<CurrentHoldings> getCurrentHoldingItems(String memberID);
}
