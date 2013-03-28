/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

/**
 *
 * @author Allen
 */
public class Student extends Member{
    public Student(String userID){
        super(userID);
        super.setMaxBorrowing(User.STUDENT_MAX_BORROWING);
    }
}
