/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lms.WelcomeLibrarianController;
import returnbook.ReturnController;
import updatecatalogue.UpdateCatalogueController;

/**
 *
 * @author Adarsh
 */
public class LibrarianFXController extends BaseGUIController implements Initializable{
    @FXML //  fx:id="home"
    private Button home; // Value injected by FXMLLoader
     @FXML //  fx:id="resetfine"
    private Button resetfine; // Value injected by FXMLLoader

    @FXML //  fx:id="return"
    private Button returnB; // Value injected by FXMLLoader

    @FXML //  fx:id="update"
    private Button update; // Value injected by FXMLLoader
    
     // Handler for Button[fx:id="home"] onAction
    public void home(ActionEvent event) {
        try{
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/WelcomeLibrarian.fxml"));     
            Parent root = (Parent)fxmlLoader.load();          
            WelcomeLibrarianController controller = fxmlLoader.<WelcomeLibrarianController>getController();
            controller.setText(name.getText());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
       catch(IOException e){
           System.out.println("ERROR:WelcomeLibrarian.fxml not found!!");
       }
    }
   // Handler for Button[fx:id="resetfine"] onAction
    public void resetFine(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="returnB"] onAction
    public void returnBook(ActionEvent event) {
        try{
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Return.fxml"));     
            Parent root = (Parent)fxmlLoader.load();          
            ReturnController controller = fxmlLoader.<ReturnController>getController();
            controller.setText(name.getText());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
       catch(IOException e){
           System.out.println("ERROR:Return.fxml not found!!");
       }
    }

    // Handler for Button[fx:id="update"] onAction
    public void update(ActionEvent event) {
       try{
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/UpdateCatalogue.fxml"));     
            Parent root = (Parent)fxmlLoader.load();          
            UpdateCatalogueController controller = fxmlLoader.<UpdateCatalogueController>getController();
            controller.setText(name.getText());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
       catch(IOException e){
           System.out.println("ERROR:UpdateCatalogue.fxml not found!!");
       }
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'Return.fxml'.";
        assert resetfine != null : "fx:id=\"resetfine\" was not injected: check your FXML file 'Return.fxml'.";
        assert returnB != null : "fx:id=\"returnB\" was not injected: check your FXML file 'Return.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'Return.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }

}

