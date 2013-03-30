/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import baseGUI.BaseFXController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Adarsh
 */
public class LMS extends Application {
    //set the inital axis of the window
    private double xOffset = 0;
    private double yOffset = 0;
    private Scene scene;
    private Parent root;
    private FXMLLoader fxmlLoader;
    
    
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.DECORATED);
        fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Login.fxml")); 
        root = (Parent) fxmlLoader.load();
        
        //enable the stage to be draggable via tow new handlers
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });        
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });        
               
        //set the background to be transparent 
        scene = new Scene(root, Color.TRANSPARENT);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //calculate the offset and call 
        double offset = scene.getWidth()/8.0;
        BaseFXController.handleOnShowAnimation(root, 500, offset);
    }    
    
   

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}