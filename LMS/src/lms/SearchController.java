/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package lms;

import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

public class SearchController extends MemberGUI implements Initializable{
  
 
 @FXML //  fx:id="skeyword"
    private RadioButton skeyword; // Value injected by FXMLLoader   
 
 @FXML //  fx:id="stitle"
    private RadioButton stitle; // Value injected by FXMLLoader   
 
 @FXML //  fx:id="sauthor"
    private RadioButton sauthor; // Value injected by FXMLLoader      
 
 @FXML //  fx:id="sisbn"
    private RadioButton sisbn; // Value injected by FXMLLoader      
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Welcome.fxml'.";
         assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Welcome.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected

    }
   }
