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
     */
    public abstract String getItemID();
    public abstract String getIndividualCopyID();
    public abstract String getTitle();
    public abstract String getDescription();
    public abstract String getAuthor();
    public abstract Calendar getPublishDate();
    public abstract String getISBN();
    public abstract String getGenre();
    public abstract String getLocation();
    
}
