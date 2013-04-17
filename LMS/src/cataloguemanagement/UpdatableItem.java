/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.CopyOnLoanException;
import java.util.Calendar;

/**
 *
 * @author Richard
 */
public interface UpdatableItem {
    public abstract void addNewItem();  
    public abstract void updateItem(); 
    public abstract void deleteItem() throws CopyOnLoanException;
    
}
