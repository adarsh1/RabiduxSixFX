
package exception;

/**
 *
 * @author Allen
 */
public class UserNotFoundException extends Exception{
    
    public UserNotFoundException(){
        super("User not found in the database");
    }
    
    public UserNotFoundException(String message){
        super (message);
    }
    
}
