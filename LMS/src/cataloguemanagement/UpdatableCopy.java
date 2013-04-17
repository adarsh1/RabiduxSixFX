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
    public abstract void addNewCopy(String itemID, String location, int NumberOfCopies) throws ItemNotFoundException;    
    public abstract void updateCopy(String copyID, String location); 
    public abstract void deleteCopy(String copyID) throws CopyOnLoanException;
}
