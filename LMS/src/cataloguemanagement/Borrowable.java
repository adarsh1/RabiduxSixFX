/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.sql.*;

/**
 *
 * @author Richard
 */
public interface Borrowable extends Displayable {
   
    public abstract PastTransaction borrow (String userID, int loanDuration) throws SQLException, ClassNotFoundException;
   
    
}
