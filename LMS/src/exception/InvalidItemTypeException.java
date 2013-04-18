/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class InvalidItemTypeException extends UpdateException {
    
    /**
     *
     */
    public InvalidItemTypeException() {
        
        super("Item type does not exsit");
        
    }
    
    /**
     *
     * @param msg
     */
    public InvalidItemTypeException(String msg) {
        
        super(msg);
        
    }
    
}
