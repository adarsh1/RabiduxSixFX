
package exception;

/**
 *
 * @author Allen
 */
public class UserNotFoundException extends DatabaseException{
    
    public UserNotFoundException(){
        
        super("User not found in the database");
        
    }
    
    public UserNotFoundException(String message){
        
        super (message);
        
    }
    
}
