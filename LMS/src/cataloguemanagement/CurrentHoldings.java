/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.Date;

/**
 *
 * @author Richard
 */
public class CurrentHoldings {
    
    private String loanID;
    private Date dateBorrowed;
    private Date dateReturned;
    private Extendable item;
    
    public Extendable getItem(){
       return item;
    }
   
    public void setItem(Extendable item){
       this.item=item;
    }
    
}
