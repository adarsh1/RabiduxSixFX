
package exception;

/**
 *
 * @author Allen
 */
public class UserNotFoundException extends LoginException{
    
    /**
     * Creates a new instance of
     * <code>UserNotFoundException</code> without detail message.
     */
    public UserNotFoundException(){
        super("User not found in the database");
    }
    
    /**
     * Constructs an instance of
     * <code>UserNotFoundException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public UserNotFoundException(String message){
        super (message);
    }
    
}
