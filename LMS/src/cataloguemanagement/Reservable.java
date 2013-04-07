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
    public abstract boolean isReserved () throws SQLException, ClassNotFoundException;
    public abstract boolean isBorrowed () throws SQLException, ClassNotFoundException;
    public abstract ReservedCopy getReservedCopy () throws SQLException, ClassNotFoundException;
    public abstract PastTransaction getPastTransaction () throws SQLException, ClassNotFoundException;
    
}
