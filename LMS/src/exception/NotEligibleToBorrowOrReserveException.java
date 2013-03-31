/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Allen
 */
public class NotEligibleToBorrowOrReserveException extends Exception {

    /**
     * Creates a new instance of
     * <code>NotEligibleToBorrowOrReserveException</code> without detail
     * message.
     */
    public NotEligibleToBorrowOrReserveException() {
    }

    /**
     * Constructs an instance of
     * <code>NotEligibleToBorrowOrReserveException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NotEligibleToBorrowOrReserveException(String msg) {
        super(msg);
    }
}
