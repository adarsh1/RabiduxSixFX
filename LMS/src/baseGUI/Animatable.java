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
    public abstract void handleOnShowAnimation(Node node, int millis, double offset);
    public abstract void handleNodeFadeTransition(Node node, int millis, double fromValue, double toValue);
    public abstract void handleNodeFadeTransition(Node node, int millis);
    public abstract void handleNodeScaleTransition (Node node, int millis, double fromValue, double toValue );
    public abstract void  playOnShowAnimation();
    
}
