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
    
    public void cancelReservation(String userID) throws SQLException, ClassNotFoundException;
  
}
