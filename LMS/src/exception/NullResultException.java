/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class NullResultException extends DatabaseException {
    
    public NullResultException() {
        
        super("An empty result set is received from database");
        
    }

    public NullResultException(String msg) {
        
        super(msg);
        
    }
    
}
