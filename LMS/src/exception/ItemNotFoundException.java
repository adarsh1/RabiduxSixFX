/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Allen
 */
public class ItemNotFoundException extends Exception{
    
    /**
     *
     */
    public ItemNotFoundException(){
        
        super("Item not found in the database");
        
    }
    
    /**
     *
     * @param message
     */
    public ItemNotFoundException(String message){
        
        super(message);
        
    }
}
