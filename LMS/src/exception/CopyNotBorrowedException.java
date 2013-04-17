/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class CopyNotBorrowedException extends ReserveException {
    
    public CopyNotBorrowedException() {
        
        super("Book has not been borrowed");
        
    }

    public CopyNotBorrowedException(String msg) {
        
        super(msg);
        
    }
    
}
