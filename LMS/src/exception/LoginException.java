/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class LoginException extends Exception {
    
    /**
     *
     */
    public LoginException() {
        
        super("Login is not successful");
        
    }

    /**
     *
     * @param msg
     */
    public LoginException(String msg) {
        
        super(msg);
        
    }
    
}
