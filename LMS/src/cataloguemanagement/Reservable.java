/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

/**
 *
 * @author Richard
 */
public interface Reservable extends Displayable {
    public abstract Boolean reserve(String memberID);
    
}
