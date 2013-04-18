/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseGUI;

import javafx.scene.Node;

/**
 *
 * @author Allen
 */
public interface Animatable {
    /**
     *
     * @param node
     * @param millis
     * @param offset
     */
    public abstract void handleOnShowAnimation(Node node, int millis, double offset);
    /**
     *
     * @param node
     * @param millis
     * @param fromValue
     * @param toValue
     */
    public abstract void handleNodeFadeTransition(Node node, int millis, double fromValue, double toValue);
    /**
     *
     * @param node
     * @param millis
     */
    public abstract void handleNodeFadeTransition(Node node, int millis);
    /**
     *
     * @param node
     * @param millis
     * @param fromValue
     * @param toValue
     */
    public abstract void handleNodeScaleTransition (Node node, int millis, double fromValue, double toValue );
    /**
     *
     */
    public abstract void playOnShowAnimation();
    
}
