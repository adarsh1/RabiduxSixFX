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
    
    private Calendar dateAvailable;
    private ReservationCancellable copy;
    
    public ReservedCopy() {
        
    }
    
    public Calendar getDateAvailable () {
        
        return this.dateAvailable;
        
    }
    
    public void setDateAvailable(Calendar dateAvailable) {
        
        this.dateAvailable = dateAvailable;
        
    }
    
    public ReservationCancellable getCopy() {
        
        return this.copy;
        
    }
    
    public void setCopy(ReservationCancellable copy) {
        
        this.copy = copy;
        
    }
}
