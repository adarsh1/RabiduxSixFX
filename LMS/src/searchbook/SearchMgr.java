/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import cataloguemanagement.ReservableCopyGroup;
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
    
    public SearchMgr ()
    {   
    }
    
    public void setCurrentMember(Member user)
    {
        currentMember = user;
    }
    
    public void SearchByTitle(String searchstring) throws SQLException, ClassNotFoundException
    {
        
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("TITLE", searchstring));
        
    }
    
    public void SearchByAuthor(String searchstring) throws SQLException, ClassNotFoundException
    {
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("AUTHOR", searchstring));
    }
    
    public void SearchByISBN(String searchstring) throws SQLException, ClassNotFoundException
    {
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("ISBN", searchstring));
    }
    
    public void SearchByGenre(String searchstring) throws SQLException, ClassNotFoundException
    {
        setItemGroup(ReservableCopyGroup.getReservableCopyGroups("GENRE", searchstring));
    }
    
    public ArrayList<ReservableCopyGroup> getItemGroup () 
    {
        return itemGroup;
    }
    
    public void setItemGroup (ArrayList<ReservableCopyGroup> group)
    {
        this.itemGroup = group;
    }
}
