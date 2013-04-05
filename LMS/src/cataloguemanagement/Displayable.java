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
     *
     */
    public abstract String getItemID();
    public abstract String getTitle();
    public abstract String getDescription();
    public abstract String getAuthor();
    public abstract Calendar getPublishDate();
    public abstract String getISBN();
    public abstract String getGenre();
    
}
