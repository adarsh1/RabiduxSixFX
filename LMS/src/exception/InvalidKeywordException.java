/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class InvalidKeywordException extends SearchException {
    
    public InvalidKeywordException() {
        
        super("Seach keyword cannot be empty");
        
    }

    public InvalidKeywordException(String msg) {
        
        super(msg);
        
    }
    
}
