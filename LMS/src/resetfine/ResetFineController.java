/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resetfine;

import baseGUI.LibrarianFXController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Adarsh
 */
public class ResetFineController extends LibrarianFXController implements Initializable {

     @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file";
         assert name != null : "fx:id=\"name\" was not injected: check your FXML file";
        // initialize your logic here: all @FXML variables will have been injected

    }    
}