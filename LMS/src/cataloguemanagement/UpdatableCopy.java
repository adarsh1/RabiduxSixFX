/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.CopyOnLoanException;
import exception.ItemNotFoundException;

/**
 *
 * @author Allen
 */
public interface UpdatableCopy {
    public abstract void addNewCopy() throws ItemNotFoundException;    
    public abstract void updateCopy(); 
    public abstract void deleteCopy() throws CopyOnLoanException;
}
