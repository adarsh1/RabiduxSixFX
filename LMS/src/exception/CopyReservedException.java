/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class CopyReservedException extends BorrowException {
    
    public CopyReservedException() {
        
        super("The book has been reserved by another user");
        
    }

    public CopyReservedException(String msg) {
        
        super(msg);
        
    }
    
}
