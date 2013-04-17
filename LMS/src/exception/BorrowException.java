/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class BorrowException extends Exception {
    
    public BorrowException() {
        
        super("Borrow is not successful");
        
    }

    public BorrowException(String msg) {
        
        super(msg);
        
    }
    
}
