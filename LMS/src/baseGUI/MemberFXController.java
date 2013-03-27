

package baseGUI;

import globalcontroller.MainController;
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


public class MemberFXController extends BaseGUIController implements Initializable {
    @FXML //  fx:id="borrow"
    private Button borrow; // Value injected by FXMLLoader

    @FXML //  fx:id="history"
    private Button history; // Value injected by FXMLLoader

    @FXML //  fx:id="home"
    private Button home; // Value injected by FXMLLoader

    @FXML //  fx:id="myMaterial"
    private Button myMaterial; // Value injected by FXMLLoader

    @FXML //  fx:id="search"
    private Button search; // Value injected by FXMLLoader

    
    // Handler for Button[fx:id="home"] onAction
    public void handleHomeTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        transitScene("/resources/xml/WelcomeMember.fxml",node);
    }

    // Handler for Button[fx:id="borrow"] onAction
    public void handleBorrowTabAction(ActionEvent event) {        
        Node node=(Node) event.getSource();
        transitScene("/resources/xml/Borrow.fxml",node);               
    }
    // Handler for Button[fx:id="history"] onAction
    public void handleHistoryTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        transitScene("/resources/xml/History.fxml",node);        
    }


    // Handler for Button[fx:id="search"] onAction
    public void handleSearchTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        transitScene("/resources/xml/Search.fxml",node);        
    }

    // Handler for Button[fx:id="rentals"] onAction
    public void handleMyMaterialTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        transitScene("/resources/xml/MyMaterial.fxml",node); 
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert borrow != null : "fx:id=\"borrow\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert history != null : "fx:id=\"history\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert myMaterial != null : "fx:id=\"rentals\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'Welcome.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }
}
