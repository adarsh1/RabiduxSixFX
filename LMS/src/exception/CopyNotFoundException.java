/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class CopyNotFoundException extends DatabaseException {
    
    public CopyNotFoundException() {
        
        super("The copy does not exsit.");
        
    }

    public CopyNotFoundException(String msg) {
        
        super(msg);
        
    }
    
}
