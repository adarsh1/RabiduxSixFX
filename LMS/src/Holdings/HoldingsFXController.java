/**
 * Sample Skeleton for "Holdings.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package Holdings;

import baseGUI.BaseFXController;
import globalcontroller.MainController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import usermanagement.Member;


public class HoldingsFXController extends BaseFXController implements Initializable {

    private HoldingsMgr holdingsMgr;
    
    @FXML //  fx:id="holdingsPane"
    private AnchorPane holdingsPane; // Value injected by FXMLLoader
    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader



    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert holdingsPane != null : "fx:id=\"holdingsPane\" was not injected: check your FXML file 'Holdings.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
        holdingsMgr = new HoldingsMgr();
    }

    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane, 500, 30.0);
    }
    
    @Override   //call the inherited method to pass the maincontroller in, meanwhile update the current member
    public void setMainController (MainController mainController){
        super.setMainController(mainController);
        //set the current member to Holdings
        holdingsMgr.setCurrentMember((Member)mainController.getUser());
    }
}
