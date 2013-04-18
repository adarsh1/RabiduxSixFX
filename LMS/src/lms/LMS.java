/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import baseGUI.Animatable;
import factory.SystemConfig;
import globalcontrol.ModelController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    
    
    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        SystemConfig instance = SystemConfig.getInstance();
        instance.useMySQLDB();
        
        primaryStage.initStyle(StageStyle.DECORATED);
        fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Login.fxml")); 
        root = (Parent) fxmlLoader.load();
        
        //enable the stage to be draggable via two new handlers
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
        primaryStage.getIcons().add(new Image(ModelController.IMAGE_PATH + "icon.png"));
        primaryStage.setTitle("RabidusSIX Library Management System");
        primaryStage.centerOnScreen();
        primaryStage.show();     
        //get the controller to play animation on show
        Animatable controller = fxmlLoader.getController();
        controller.playOnShowAnimation();        
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