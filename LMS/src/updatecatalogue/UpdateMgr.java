
package updatecatalogue;

import cataloguemanagement.UpdatableCopy;
import cataloguemanagement.UpdatableItem;
import exception.ItemExistException;
import usermanagement.Librarian;

/**
 *
 * @author Richard
 */
public class UpdateMgr {
    
    private Librarian currentLibrarian;
    private UpdatableItem updatableItem;
    private UpdatableCopy updatableCopy;    
    
    public UpdateMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    public UpdateMgr(){
        //empty constructor
    }
    
    public void addNewItem() throws ItemExistException{
        
    }
}
