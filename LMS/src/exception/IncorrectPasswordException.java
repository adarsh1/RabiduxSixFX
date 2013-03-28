
package exception;

/**
 *
 * @author Allen
 */
public class IncorrectPasswordException extends Exception {

    /**
     * Creates a new instance of
     * <code>IncorrectPasswordException</code> without detail message.
     */
    public IncorrectPasswordException() {
        super("Incorrect password.");
    }

    /**
     * Constructs an instance of
     * <code>IncorrectPasswordException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public IncorrectPasswordException(String msg) {
        super(msg);
    }
}
