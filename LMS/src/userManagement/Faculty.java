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
        super.setMaxHolding(Member.FACULTY_MAX_HOLDING);
    }
}
