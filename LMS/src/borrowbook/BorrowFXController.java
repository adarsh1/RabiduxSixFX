/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package borrowbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import baseGUI.MemberFXController;
import java.net.URL;
import java.util.ResourceBundle;


    // Handler for Button[Button[id=null, styleClass=button]] onAction
public class BorrowFXController extends MemberFXController implements Initializable{
   
    @FXML //  fx:id="confirmbutton"
    private Button confirmbutton; // Value injected by FXMLLoader
    
    @FXML //  fx:id="bID"
    private TextField itemIDInputField; // Value injected by FXMLLoader
    
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
    
    //constructor
    public BorrowFXController(){
        
    }
    
    // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void handleBorrowButtonAction(ActionEvent event){
        String itemID = getItemID();
        try{
            //Borrowable BorrowableItem = DataStore.getCatalogueItem(); 
            confirmbutton.setVisible(true);
            success.setText("");
            if(true){
                title.setText("Software Engineering");
                author.setText("Matthew Riley");
                isbn.setText("SB3984TH");
                confirmbutton.setVisible(true);
                success.setText("");
            }                       
            else{
                title.setText("The book id is invalid or currently unavaiable for borrowing");
                confirmbutton.setVisible(false);
                author.setText("");
                isbn.setText("");
                success.setText("");
            }
            result.setVisible(true);
        }
        catch(Exception e){
            
        }
        
    }
    public void confirm(ActionEvent event){
        //call function to change sts of book
        confirmbutton.setVisible(false);
        success.setText("The book was borrowed successfully!");        
    }
    
    public String getItemID(){
        return this.itemIDInputField.getText();
    }

    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file ";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file ";
        // initialize your logic here: all @FXML variables will have been injected

    }
}