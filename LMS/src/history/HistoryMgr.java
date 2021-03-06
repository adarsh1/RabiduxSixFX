
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

    /**
     *
     * @param member
     */
    public HistoryMgr(Member member) {
        currentMember = member;
    }
    /**
     *
     */
    public HistoryMgr(){
    }

    /**
     *
     * @return
     */
    public Member getCurrentMember() {
        return currentMember;
    }

    /**
     *
     * @param currentMember
     */
    public void setCurrentMember(Member currentMember) {
        this.currentMember = currentMember;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<PastTransaction> getItemGroup ()
    {
        return this.itemGroup;
    }
    /**
     *
     * @param group
     */
    public void setItemGroup (ArrayList<PastTransaction> group)
    {
        this.itemGroup = group;
    }
    
    /**
     *
     * @return
     */
    public int getItemSize()
    {
        if(itemGroup == null) return 0;
        return itemGroup.size();
    }
    
    /**
     *
     */
    public void getHistory()
    {
        //Call the datastore function of past transaction to get all the 
        //loan details in an array and then assign it to the array list present
        //Use "Member" class methods??
    }
    
}   
