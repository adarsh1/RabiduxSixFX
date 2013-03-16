/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package lms;

import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SearchController extends MemberGUI implements Initializable{
  
 
 @FXML //  fx:id="scrollpane"
    private ScrollPane scrollpane; // Value injected by FXMLLoader   
 
 @FXML //  fx:id="skeyword"
    private VBox vb; // Value injected by FXMLLoader  
 
 @FXML //  fx:id="skeyword"
    private RadioButton skeyword; // Value injected by FXMLLoader  
 
 @FXML //  fx:id="stitle"
    private RadioButton stitle; // Value injected by FXMLLoader   
 
 @FXML //  fx:id="sauthor"
    private RadioButton sauthor; // Value injected by FXMLLoader      
 
 @FXML //  fx:id="sisbn"
    private RadioButton sisbn; // Value injected by FXMLLoader      
    
 
 // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void searchbook(ActionEvent event)throws IOException{
      scrollpane.setVisible(true);
      vb.setVisible(true);
      scrollpane.setContent(vb);
      int i;
      for(i=0;i<20;i++)
      {  
          Text t = new Text(10, 50, "This is a test");
          vb.getChildren().add(t);
      }
      
    }
 
 
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Welcome.fxml'.";
         assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Welcome.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected

    }
   }
