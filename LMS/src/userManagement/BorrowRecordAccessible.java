/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import cataloguemanagement.CurrentHolding;
import cataloguemanagement.ResevedItem;
import cataloguemanagement.TransactionHistory;
import java.util.ArrayList;

/**
 *
 * @author Allen
 */
public interface BorrowRecordAccessible {
    public abstract ArrayList<TransactionHistory> getTransactionHistoryItems(String memberID);
    public abstract ArrayList<ResevedItem> getReservedItems(String memberID);
    public abstract ArrayList<CurrentHolding> getCurrentHoldingItems(String memberID);
}
