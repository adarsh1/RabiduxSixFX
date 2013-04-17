/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class SearchException extends Exception {
    
    public SearchException() {
        
        super("Search is not successful");
        
    }

    public SearchException(String msg) {
        
        super(msg);
        
    }
    
}
