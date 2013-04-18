/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class ExtendException extends Exception {
    
    /**
     *
     */
    public ExtendException() {
        
        super("Extend is not successful");
        
    }

    /**
     *
     * @param msg
     */
    public ExtendException(String msg) {
        
        super(msg);
        
    }
    
}
