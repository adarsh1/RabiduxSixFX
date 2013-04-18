/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import exception.*;
import java.sql.SQLException;

/**
 *
 * @author Richard
 */
public interface Extendable extends Displayable {
    
    /**
     *
     * @param loanID
     * @param loanDuration
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public abstract void extend(String loanID, int loanDuration) throws SQLException, ClassNotFoundException, CopyNotFoundException, NullResultException, RecordNotFoundException;
}
