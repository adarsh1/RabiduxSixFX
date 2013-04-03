/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package history;

import baseGUI.BaseFXController;
import globalcontroller.MainController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import usermanagement.Member;


public class HistoryFXController extends BaseFXController implements Initializable{
    
    private HistoryMgr historyMgr;
    
    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="itemPane"
    private VBox itemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="scrollPane"
    private ScrollPane scrollPane; // Value injected by FXMLLoader
    
   @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'History.fxml'.";
        assert itemPane != null : "fx:id=\"itemPane\" was not injected: check your FXML file 'History.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'History.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected
        historyMgr = new HistoryMgr();
    }
   
    @Override
    public void setMainController(MainController mainController) {
        super.setMainController(mainController); 
        //set the current member
        historyMgr.setCurrentMember((Member)mainController.getUser());
    }

    @Override
    public void playOnShowAnimation() {
        this.handleOnShowAnimation(contentPane);
    }
    
}
