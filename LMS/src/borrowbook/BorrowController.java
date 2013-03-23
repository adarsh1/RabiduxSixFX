/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package lms;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class BorrowController extends MemberGUI implements Initializable{
   
    @FXML //  fx:id="confirmbutton"
    private Button confirmbutton; // Value injected by FXMLLoader
    
    @FXML //  fx:id="bID"
    private TextField bID; // Value injected by FXMLLoader
    
    @FXML //  fx:id="title"
    private Text title; // Value injected by FXMLLoader
    
    @FXML //  fx:id="success"
    private Text success; // Value injected by FXMLLoader
    
    @FXML //  fx:id="author"
    private Text author; // Value injected by FXMLLoader
    
    @FXML //  fx:id="isbn"
    private Text isbn; // Value injected by FXMLLoader
    
    @FXML //  fx:id="bID"
    private Pane result; // Value injected by FXMLLoader
    
     // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void lend(ActionEvent event)throws IOException{
        boolean bookfoundandborrowable = true;
        confirmbutton.setVisible(true);
        success.setText("");
        if(bookfoundandborrowable)
        {title.setText("Software Engineering");
         author.setText("Matthew Riley");
         isbn.setText("SB3984TH");
         confirmbutton.setVisible(true);
         success.setText("");
        }
        else
        {
          title.setText("The book id is invalid or currently unavaiable for borrowing");
          confirmbutton.setVisible(false);
          author.setText("");
          isbn.setText("");
          success.setText("");
        }
           result.setVisible(true);
        
    }
    
    // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void confirm(ActionEvent event)throws IOException{
        //call function to change sts of book
        confirmbutton.setVisible(false);
        success.setText("The book was borrowed successfully!");
        
    }
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file ";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file ";
        // initialize your logic here: all @FXML variables will have been injected

    }
}