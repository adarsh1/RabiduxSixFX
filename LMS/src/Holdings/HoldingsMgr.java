
package Holdings;

//import lib and packages

import usermanagement.Member;
/**
 *
 * @author Richard
 */

//relationship with other classes
public class HoldingsMgr {
     
    //parameters
    private Member currentMember;    
    
    //constrcutor
    public HoldingsMgr(){      
       
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


  