/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class DatabaseException extends Exception {
    
    /**
     *
     */
    public DatabaseException() {
        
        super("Database communication is not successful");
        
    }

    /**
     *
     * @param msg
     */
    public DatabaseException(String msg) {
        
        super(msg);
        
    }
    
}
