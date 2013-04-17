
package exception;

/**
 *
 * @author Allen
 */
public class ItemExistException extends Exception {

    /**
     * Creates a new instance of
     * <code>ItemExistException</code> without detail message.
     */
    public ItemExistException() {
    }

    /**
     * Constructs an instance of
     * <code>ItemExistException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ItemExistException(String msg) {
        super(msg);
    }
}
