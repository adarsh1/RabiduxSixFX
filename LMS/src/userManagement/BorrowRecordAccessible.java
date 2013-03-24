/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import java.util.ArrayList;

/**
 *
 * @author Allen
 */
public interface BorrowRecordAccessible {
    public abstract ArrayList<TransactionHistoryItem> getTransactionHistoryItems(String memberID);
    public abstract ArrayList<ReservedItem> getReservedItems(String memberID);
    public abstract ArrayList<CurrentHoldingItem> getCurrentHoldingItems(String memberID);
}
