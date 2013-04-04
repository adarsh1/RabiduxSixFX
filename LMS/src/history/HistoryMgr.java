
package history;
import cataloguemanagement.PastTransaction;
import java.util.ArrayList;
import usermanagement.Member;
/**
 *
 * @author Ambarish
 */
public class HistoryMgr {
    
    private Member currentMember;
    
    private ArrayList<PastTransaction> itemGroup;

    public HistoryMgr(Member member) {
        currentMember = member;
    }
    public HistoryMgr(){
    }

    public Member getCurrentMember() {
        return currentMember;
    }

    public void setCurrentMember(Member currentMember) {
        this.currentMember = currentMember;
    }
    
    public ArrayList<PastTransaction> getItemGroup ()
    {
        return this.itemGroup;
    }
    public void setItemGroup (ArrayList<PastTransaction> group)
    {
        this.itemGroup = group;
    }
    
    public void getHistory()
    {
        //Call the datastore function of past transaction to get all the 
        //loan details in an array and then assign it to the array list present
        //Use "Member" class methods??
    }
    
}   
