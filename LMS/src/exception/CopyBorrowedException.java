/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class CopyBorrowedException extends BorrowException {
    
    /**
     *
     */
    public CopyBorrowedException() {
        
        super("The book has been borrowed by another user");
        
    }

    /**
     *
     * @param msg
     */
    public CopyBorrowedException(String msg) {
        
        super(msg);
        
    }
    
}
