/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import login.LoginFXController;

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
        handleRootFadeIn();
    }
    
    public void handleRootFadeIn(){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500), root);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }
    
    /*
    @Override
    public void start(final Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT); // here it is

        Group rg = new Group();
        Scene scene = new Scene(rg, 320, 240, Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Rectangle r = new Rectangle(5, 5, stage.getWidth() - 10, stage.getHeight() - 10);
        r.setFill(Color.STEELBLUE);
        r.setEffect(new DropShadow());
        rg.getChildren().add(r);
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