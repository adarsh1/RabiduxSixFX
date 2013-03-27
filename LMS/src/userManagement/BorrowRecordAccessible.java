/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ReservedItem;
import cataloguemanagement.TransactionHistoryItem;
import java.util.ArrayList;

/**
 *
 * @author Allen
 */
public interface BorrowRecordAccessible {
    public abstract ArrayList<TransactionHistoryItem> getTransactionHistoryItems(String memberID);
    public abstract ArrayList<ReservedItem> getReservedItems(String memberID);
    public abstract ArrayList<CurrentHolding> getCurrentHoldingItems(String memberID);
}
