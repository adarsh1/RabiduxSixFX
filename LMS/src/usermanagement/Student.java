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
    
    /**
     *
     */
    public Student(){
        
        super();
        setUsertype(User.STUDENT);
        setMaxHolding(Member.STUDENT_MAX_HOLDING);
        setMaxReserve(Member.STUDENT_MAX_RESERVE);
    }

    /**
     *
     * @return
     */
    @Override
    public int getLoanDuration() {
        return Member.STUDENT_LOAN_DURATION;
    }
    
}
