/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.*;

/**
 *
 * @author Richard
 */

public class ReservedCopy {
    
    private String copyID;
    private Calendar dateAvailable;
    private ReservationCancellable copy;
    
    /**
     *
     */
    public ReservedCopy() {
        
    }
    
    /**
     *
     * @return
     */
    public String getCopyID () {
        
        return this.copyID;
        
    }
    
    /**
     *
     * @param copyID
     */
    public void setCopyID (String copyID) {
        
        this.copyID = copyID;
        
    }
    
    /**
     *
     * @return
     */
    public Calendar getDateAvailable () {
        
        return this.dateAvailable;
        
    }
    
    /**
     *
     * @param dateAvailable
     */
    public void setDateAvailable(Calendar dateAvailable) {
        
        this.dateAvailable = dateAvailable;
        
    }
    
    /**
     *
     * @return
     */
    public ReservationCancellable getCopy() {
        
        return this.copy;
        
    }
    
    /**
     *
     * @param copy
     */
    public void setCopy(ReservationCancellable copy) {
        
        this.copy = copy;
        
    }
}
