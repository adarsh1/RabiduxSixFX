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
public interface ReservationCancellable extends Displayable {
    
    /**
     *
     * @param userID
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void cancelReservation(String userID) throws SQLException, ClassNotFoundException;
  
}
