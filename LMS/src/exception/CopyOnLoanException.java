
package exception;

/**
 *
 * @author Allen
 */
public class CopyOnLoanException extends Exception {

    /**
     * Creates a new instance of
     * <code>CopyOnLoanException</code> without detail message.
     */
    public CopyOnLoanException() {
    }

    /**
     * Constructs an instance of
     * <code>CopyOnLoanException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CopyOnLoanException(String msg) {
        super(msg);
    }
}
