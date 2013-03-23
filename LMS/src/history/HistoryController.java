/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package history;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import baseGUI.MemberFXController;


public class HistoryController extends MemberFXController implements Initializable{
   @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Welcome.fxml'.";
         assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Welcome.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected

    }
   }
