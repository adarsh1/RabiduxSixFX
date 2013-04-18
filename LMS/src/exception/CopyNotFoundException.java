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
    
    /**
     *
     */
    public CopyNotFoundException() {
        
        super("Copy not found in the database");
        
    }

    /**
     *
     * @param msg
     */
    public CopyNotFoundException(String msg) {
        
        super(msg);
        
    }
    
}
