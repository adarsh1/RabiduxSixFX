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
   
    public abstract void borrow (String userID) throws SQLException, ClassNotFoundException;
   
    
}
