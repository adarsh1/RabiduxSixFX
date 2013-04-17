
package updatecatalogue;

import cataloguemanagement.Updatable;
import exception.ItemExistException;
import usermanagement.Librarian;

/**
 *
 * @author Richard
 */
public class UpdateMgr {
    
    private Librarian currentLibrarian;
    private Updatable copy;
    
    public UpdateMgr(Librarian currentLibrarian){
        this.currentLibrarian = currentLibrarian;
    }
    public UpdateMgr(){
        //empty constructor
    }
    
    public void addNewItem() throws ItemExistException{
        
    }
}
