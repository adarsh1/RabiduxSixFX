/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.ItemNotFoundException;
import java.util.HashMap;

/**
 *
 * @author Allen
 */
public class UpdatableCopy {
    
    /**
     *
     */
    public UpdatableCopy(){
        
    }
    
    /**
     *
     * @param location
     */
    public void addNewCopy(String location){
        
    }
    
    /**
     *
     * @param copyID
     * @param location
     * @throws ItemNotFoundException
     */
    public void updateCopy(String copyID, String location) throws ItemNotFoundException{
        
    }
    
    /**
     *
     * @param copyID
     * @return
     * @throws ItemNotFoundException
     */
    public HashMap getCopyDetails(String copyID) throws ItemNotFoundException{
        return new HashMap();
    }
    
    /**
     *
     * @param copyID
     * @throws ItemNotFoundException
     */
    public void deleteCopy(String copyID) throws ItemNotFoundException{
        
    }
}
