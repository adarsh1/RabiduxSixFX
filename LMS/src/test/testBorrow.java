/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import globalcontroller.MainController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import usermanagement.User;

/**
 *
 * @author Allen
 */
public class testBorrow extends Application{

    /**
     * @param args the command line arguments
     */
    private Scene scene;
    private Parent root;
    private FXMLLoader fxmlLoader;
    private MainController MC = new MainController();
    
    
    @Override
    public void start(final Stage primaryStage) {
        try{
            MC.setUser( User.getUser("Liux0047@e.ntu.edu.sg","12345678"));
            primaryStage.initStyle(StageStyle.DECORATED);
            fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/MemberPage.fxml")); 
            root = (Parent) fxmlLoader.load();        


            //set the background to be transparent 
            scene = new Scene(root, Color.TRANSPARENT);

            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch( Exception e){
            System.out.println(e.getMessage());
        }
        
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
