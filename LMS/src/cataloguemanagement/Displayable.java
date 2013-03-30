/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cataloguemanagement;

/**
 *
 * @author Richard
 */
public interface Displayable {
    /**
     *
     */
    public abstract String getTitleDisplay();
    public abstract String getDescriptionDisplay();
    public abstract String getAuthorDisplay();
    public abstract String getPublishYearDisplay();
    public abstract String getItemIDDisplay();
    
}
