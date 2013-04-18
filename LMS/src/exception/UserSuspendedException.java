/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class UserSuspendedException extends Exception {
    
    public UserSuspendedException() {
        
        super("Your account is suspended");
        
    }

    public UserSuspendedException(String msg) {
        
        super(msg);
        
    }
    
}
