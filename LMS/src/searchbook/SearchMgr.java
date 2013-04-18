/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import cataloguemanagement.ReservableCopyGroup;
import exception.CopyNotFoundException;
import exception.InvalidKeywordException;
import exception.ItemNotFoundException;
import java.sql.SQLException;
import java.util.*;
import usermanagement.Member;

/**
 *
 * @author Ambarish
 */
public class SearchMgr {
    
    private Member currentMember;
    private ArrayList<ReservableCopyGroup> itemGroup; 
    
    /**
     *
     */
    public SearchMgr ()
    {   
    }
    
    /**
     *
     * @param user
     */
    public void setCurrentMember(Member user)
    {
        currentMember = user;
    }
    
    /**
     *
     * @param searchstring
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void SearchByTitle(String searchstring) throws SQLException, ClassNotFoundException, InvalidKeywordException, CopyNotFoundException, ItemNotFoundException
    {
        
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("TITLE", searchstring));
        
    }
    
    /**
     *
     * @param searchstring
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void SearchByAuthor(String searchstring) throws SQLException, ClassNotFoundException, InvalidKeywordException, CopyNotFoundException, ItemNotFoundException
    {
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("AUTHOR", searchstring));
    }
    
    /**
     *
     * @param searchstring
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void SearchByISBN(String searchstring) throws SQLException, ClassNotFoundException, InvalidKeywordException, CopyNotFoundException, ItemNotFoundException
    {
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("ISBN", searchstring));
    }
    
    /**
     *
     * @param searchstring
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void SearchByGenre(String searchstring) throws SQLException, ClassNotFoundException, InvalidKeywordException, CopyNotFoundException, ItemNotFoundException
    {
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("GENRE", searchstring));
    }
    
    /**
     *
     * @return
     */
    public ArrayList<ReservableCopyGroup> getItemGroup () 
    {
        return itemGroup;
    }
    
    /**
     *
     * @param group
     */
    public void setItemGroup (ArrayList<ReservableCopyGroup> group)
    {
        this.itemGroup = group;
    }
    /**
     *
     * @return
     */
    public int getNoOfResults(){
      return  itemGroup.size();
    }
}
