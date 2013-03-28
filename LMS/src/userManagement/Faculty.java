/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

/**
 *
 * @author Allen
 */
public class Faculty extends Member{
    public Faculty(String userID){
        super(userID);
        super.setMaxBorrowing(User.FACULTY_MAX_BORROWING);
    }
}
