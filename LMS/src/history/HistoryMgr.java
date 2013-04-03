/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package history;
import usermanagement.Member;
/**
 *
 * @author Richard
 */
public class HistoryMgr {
    
    private Member currentMember;
    
    /**
     *
     * @param currentMember
     */
    public HistoryMgr(Member currentMember) {
        
    }
    public HistoryMgr(){
        //empty constructor
    }

    /**
     * @return the currentMember
     */
    public Member getCurrentMember() {
        return currentMember;
    }

    /**
     * @param currentMember the currentMember to set
     */
    public void setCurrentMember(Member currentMember) {
        this.currentMember = currentMember;
    }
}   
