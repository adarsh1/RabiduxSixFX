/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class CopyOverdueException extends ExtendException {
    
    /**
     *
     */
    public CopyOverdueException() {
        
        super("The copy has overdued");
        
    }

    /**
     *
     * @param msg
     */
    public CopyOverdueException(String msg) {
        
        super(msg);
        
    }
    
}
