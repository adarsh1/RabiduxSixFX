/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Allen
 */
public class ItemNotFoundException extends Exception{
    
    /**
     * Creates a new instance of
     * <code>ItemNotFoundException</code> without detail message.
     */
    public ItemNotFoundException(){
        super("Item not found in the database");
    }
    
    /**
     * Constructs an instance of
     * <code>ItemNotFoundException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public ItemNotFoundException(String message){
        super(message);
    }
}
