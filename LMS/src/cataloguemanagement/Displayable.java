/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

import java.util.Calendar;

/**
 *
 * @author Richard
 */
public interface Displayable {
    /**
     * get Strings for various attributes that client class may use to display
     * @return 
     */
    public abstract String getItemID();
    /**
     *
     * @return
     */
    public abstract String getIndividualCopyID();
    /**
     *
     * @return
     */
    public abstract String getTitle();
    /**
     *
     * @return
     */
    public abstract String getDescription();
    /**
     *
     * @return
     */
    public abstract String getAuthor();
    /**
     *
     * @return
     */
    public abstract Calendar getPublishDate();
    /**
     *
     * @return
     */
    public abstract String getISBN();
    /**
     *
     * @return
     */
    public abstract String getGenre();
    /**
     *
     * @return
     */
    public abstract String getLocation();
    
}
