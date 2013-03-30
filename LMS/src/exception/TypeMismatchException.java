/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Allen
 */
public class TypeMismatchException extends Exception {
    
    private String instanceID;
    private String typeName;

    /**
     * Creates a new instance of
     * <code>TypeMismatchException</code> without detail message.
     */
    
    public TypeMismatchException(String instanceID, String typeName) {
        this.instanceID = instanceID;
        this.typeName = typeName;
    }
    
    public TypeMismatchException() {
        this("Anonymous", "Anonymous");
    }

    /**
     * Constructs an instance of
     * <code>TypeMismatchException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */    
    
    @Override
    public String getMessage(){
        return (instanceID + " is not of " + typeName + " type.");
    }
}
