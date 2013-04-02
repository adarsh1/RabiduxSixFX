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
public interface Extendable extends Displayable {
    
    public abstract void extend(String loanID, int loanDuration) throws SQLException, ClassNotFoundException;
    
}
