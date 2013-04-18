/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ambarish
 */


package resetfine;

import baseGUI.BaseFXController;
import borrowbook.BorrowMgr;
import cataloguemanagement.PastTransaction;
import exception.NotEligibleToBorrowOrReserveException;
import exception.TypeMismatchException;
import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import usermanagement.Member;


public class ResetFineFXController extends BaseFXController implements Initializable {

    @FXML //  fx:id="userinfoPane"
    private Pane userinfoPane; // Value injected by FXMLLoader

    @FXML //  fx:id="confirmBorrow"
    private Button resetButton; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="userIDField"
    private TextField userIDField; // Value injected by FXMLLoader

    @FXML //  fx:id="getDetails"
    private Button getDetails; // Value injected by FXMLLoader

    @FXML //  fx:id="hideMessage"
    private Button hideMessage; // Value injected by FXMLLoader

    @FXML //  fx:id="messageHeader"
    private Label messageHeader; // Value injected by FXMLLoader

    @FXML //  fx:id="messageHolderPane"
    private AnchorPane messageHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="messagePane"
    private AnchorPane messagePane; // Value injected by FXMLLoader

    @FXML //  fx:id="messageText"
    private Label messageText; // Value injected by FXMLLoader

    @FXML //  fx:id="userFine"
    private Label userFine; // Value injected by FXMLLoader

    @FXML //  fx:id="userName"
    private Label userName; // Value injected by FXMLLoader


    private ResetFineMgr resetFineMgr;
    
    // Handler for Button[fx:id="getDetails"] onAction
    public void handleGetDetailsButtonAction(ActionEvent event) {
        try
        {
            getUserDetails();
        }
        catch (Exception e)
        {
            userIDField.clear();
            String header = "No User Found";
            String text = "Oops we could not find a User with this Id\nPlease recheck your User-ID.\n";
            text += "Error message:" + e.getMessage();
            displayWarning(header,text);
        }
    }

    
    
    private void getUserDetails() throws SQLException, ClassNotFoundException, TypeMismatchException{
    
        resetFineMgr.setMember(userIDField.getText());
        userName.setText("User Name : "+resetFineMgr.getUserName());
        userFine.setText("User Fine    : "+resetFineMgr.getUserFine());
        //make the book info panel visible
        userinfoPane.setVisible(true);

        //generate animation
        this.handleOnShowAnimation(userinfoPane);
        
    }
    
    
    //handle the borrow when the confirm button is pressed
    public void handleResetButtonAction(ActionEvent event){
        userinfoPane.setVisible(false);
        try{
            resetFineMgr.reset();
            String text = "The Member's fine has been reset to 0.\n";
            displaySuccess("Thank you",text);
        }
        catch (Exception e){
        //catch(NotEligibleToBorrowOrReserveException | SQLException | ClassNotFoundException e){
            String text = "We regret to inform you that the user's fine was not reset.\n";
            text += "Reasons might be: \n";
            text += e.getMessage();
            displayWarning("Sorry",text);
        }
    }
    
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert userinfoPane != null : "fx:id=\"userinfoPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert resetButton != null : "fx:id=\"confirmBorrow\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert userIDField != null : "fx:id=\"userIDField\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert getDetails != null : "fx:id=\"getDetails\" was not injected: check your FXML file 'Borrow.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
        resetFineMgr = new ResetFineMgr();

    }
    
    
    @Override   //call the inherited method to update the current member
    public void setInitialData( ModelController modelController){      
        this.setModelController(modelController);
    }
        
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane);
    }
}
