/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class UpdateException extends Exception {
    
    public UpdateException() {
        
        super("Item type does not exsit");
        
    }
    
    public UpdateException(String msg) {
        
        super(msg);
        
    }
    
}
