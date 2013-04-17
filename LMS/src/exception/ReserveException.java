/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class ReserveException extends Exception {
    
    public ReserveException() {
        
        super("Reserve is not successful");
        
    }

    public ReserveException(String msg) {
        
        super(msg);
        
    }
    
}
