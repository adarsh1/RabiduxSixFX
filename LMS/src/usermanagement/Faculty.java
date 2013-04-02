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
    
    public Faculty(){
        
        super();
        setUsertype(User.FACULTY);
        setMaxHolding(Member.FACULTY_MAX_HOLDING);
        
    }

    @Override
    public int getLoanDuration() {
        return Member.FACULTY_LOAN_DURATION;
    }
    
}
