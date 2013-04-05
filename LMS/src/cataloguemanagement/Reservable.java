/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.sql.SQLException;

/**
 *
 * @author Richard
 */
public interface Reservable extends Displayable {
    
    public abstract void reserve(String userID) throws SQLException, ClassNotFoundException;
    
}
