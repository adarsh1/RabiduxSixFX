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
    
    public LoginException() {
        
        super("Login is not successful");
        
    }

    public LoginException(String msg) {
        
        super(msg);
        
    }
    
}
