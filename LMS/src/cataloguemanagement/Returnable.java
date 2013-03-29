/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

/**
 *
 * @author Richard
 */
public interface Returnable extends Displayable {
    
    public abstract void returnBook(String copyID, String userID);
    
}
