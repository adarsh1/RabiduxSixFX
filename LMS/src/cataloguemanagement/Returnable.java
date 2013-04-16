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
public interface Returnable extends Displayable {
    
    public abstract void returnCopy(double fine) throws SQLException, ClassNotFoundException ;
    public abstract PastTransaction getPastTransaction () throws SQLException, ClassNotFoundException;
    
}
