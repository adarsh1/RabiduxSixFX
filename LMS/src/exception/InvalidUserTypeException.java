/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class InvalidUserTypeException extends DatabaseException{
    
    /**
     *
     */
    public InvalidUserTypeException(){
        
        super("User type is not defined");
        
    }
    
    /**
     *
     * @param message
     */
    public InvalidUserTypeException(String message){
        
        super (message);
        
    }
    
}
