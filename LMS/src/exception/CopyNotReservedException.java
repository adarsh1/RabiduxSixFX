/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class CopyNotReservedException extends ReserveException {
    
    /**
     *
     */
    public CopyNotReservedException() {
        
        super("Copy has not been reserved");
        
    }

    /**
     *
     * @param msg
     */
    public CopyNotReservedException(String msg) {
        
        super(msg);
        
    }
    
}
