/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package baseGUI;

import mymaterials.MyMaterialGUIController;
import history.HistoryController;
import borrowbook.BorrowController;
import searchbook.SearchController;
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
import lms.WelcomeController;


public class MemberFXController extends BaseGUIController
    implements Initializable {
    @FXML //  fx:id="borrow"
    private Button borrow; // Value injected by FXMLLoader

    @FXML //  fx:id="history"
    private Button history; // Value injected by FXMLLoader

    @FXML //  fx:id="home"
    private Button home; // Value injected by FXMLLoader

    @FXML //  fx:id="rentals"
    private Button rentals; // Value injected by FXMLLoader

    @FXML //  fx:id="search"
    private Button search; // Value injected by FXMLLoader


// Handler for Button[fx:id="home"] onAction
    public void home(ActionEvent event) {
       try{Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Welcome.fxml"));     
Parent root = (Parent)fxmlLoader.load();          
WelcomeController controller = fxmlLoader.<WelcomeController>getController();
controller.setText(name.getText());
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
        }
        catch(IOException e){System.out.println("ERROR:Welcome.fxml not found!!");}
    }

    // Handler for Button[fx:id="borrow"] onAction
    public void borrow(ActionEvent event) {
       try{Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Borrow.fxml"));     
Parent root = (Parent)fxmlLoader.load();          
BorrowController controller = fxmlLoader.<BorrowController>getController();
controller.setText(name.getText());
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
        }
        catch(IOException e){System.out.println("ERROR:Borrow.fxml not found!!");}
    }
    // Handler for Button[fx:id="history"] onAction
    public void history(ActionEvent event) {
        try{Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/History.fxml"));     
Parent root = (Parent)fxmlLoader.load();          
HistoryController controller = fxmlLoader.<HistoryController>getController();
controller.setText(name.getText());
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
        }
        catch(IOException e){System.out.println("ERROR:History.fxml not found!!");}
    }


    // Handler for Button[fx:id="search"] onAction
    public void search(ActionEvent event) {
        try{Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Search.fxml"));     
Parent root = (Parent)fxmlLoader.load();          
SearchController controller = fxmlLoader.<SearchController>getController();
controller.setText(name.getText());
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
        }
        catch(IOException e){System.out.println("ERROR:Search.fxml not found!!");}
    }

    // Handler for Button[fx:id="rentals"] onAction
    public void showRentals(ActionEvent event) {
        try{Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Rentals.fxml"));     
Parent root = (Parent)fxmlLoader.load();          
MyMaterialGUIController controller = fxmlLoader.<MyMaterialGUIController>getController();
controller.setText(name.getText());
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
        }
        catch(IOException e){System.out.println("ERROR:Rentals.fxml not found!!");}
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert borrow != null : "fx:id=\"borrow\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert history != null : "fx:id=\"history\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert rentals != null : "fx:id=\"rentals\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'Welcome.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }

}
