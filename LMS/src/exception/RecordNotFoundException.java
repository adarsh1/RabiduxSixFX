/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Haohang
 */
public class RecordNotFoundException extends DatabaseException{
    
    /**
     *
     */
    public RecordNotFoundException(){
        
        super("Record not found in the database");
        
    }
    
    /**
     *
     * @param message
     */
    public RecordNotFoundException(String message){
        
        super(message);
        
    }
}
