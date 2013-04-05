/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package borrowbook;

import baseGUI.BaseFXController;
import cataloguemanagement.PastTransaction;
import exception.NotEligibleToBorrowOrReserveException;
import exception.TypeMismatchException;
import globalcontrol.ModelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import usermanagement.Member;


    // Handler for Button[Button[id=null, styleClass=button]] onAction
public class BorrowFXController extends BaseFXController implements Initializable{
    
    /* Manager classes  */
    private BorrowMgr borrowMgr;
   
    @FXML //  fx:id="MessageText"
    private Label messageText; // Value injected by FXMLLoader

    @FXML //  fx:id="bookInfoPane"
    private Pane bookInfoPane; // Value injected by FXMLLoader

    @FXML //  fx:id="bookcoverField"
    private Pane bookcoverField; // Value injected by FXMLLoader

    @FXML //  fx:id="confirmBorrow"
    private Button confirmBorrow; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="copyIDField"
    private TextField copyIDField; // Value injected by FXMLLoader

    @FXML //  fx:id="fullItemTitle"
    private Tooltip fullItemTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="getDetails"
    private Button getDetails; // Value injected by FXMLLoader

    @FXML //  fx:id="hideMessage"
    private Button hideMessage; // Value injected by FXMLLoader

    @FXML //  fx:id="itemAuthor"
    private Label itemAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="itemDescription"
    private Text itemDescription; // Value injected by FXMLLoader

    @FXML //  fx:id="itemDescriptionAnchorPane"
    private AnchorPane itemDescriptionAnchorPane; // Value injected by FXMLLoader

    @FXML //  fx:id="itemDescriptionScrollPane"
    private ScrollPane itemDescriptionScrollPane; // Value injected by FXMLLoader

    @FXML //  fx:id="itemID"
    private Label itemID; // Value injected by FXMLLoader

    @FXML //  fx:id="itemMsg"
    private Label itemMsg; // Value injected by FXMLLoader

    @FXML //  fx:id="itemTitle"
    private Label itemTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="messageHeader"
    private Label messageHeader; // Value injected by FXMLLoader

    @FXML //  fx:id="messageHolderPane"
    private AnchorPane messageHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="messagePane"
    private AnchorPane messagePane; // Value injected by FXMLLoader
   
    
    // Handler for Button Get details onAction    
    public void handleGetDetailsButtonAction (ActionEvent event){
        try{                        
            getItemDetails();
        }
        catch (SQLException | ClassNotFoundException | TypeMismatchException e){
            displayItemErrorMsg(e.getMessage());
        }        
    }
    
    private void displayItemErrorMsg(String message){
        bookInfoPane.setVisible(false);
        itemMsg.setVisible(true);
        itemMsg.setText(message);
        this.handleOnShowAnimation(itemMsg, 500, 20.0);        
    }
    
    private void getItemDetails() throws SQLException, ClassNotFoundException, TypeMismatchException{
        //create a borrowable item
        String copyID = copyIDField.getText();            
        borrowMgr.createItem(copyID);
        //display all the info about this copy
        itemTitle.setText(borrowMgr.getItem().getTitleDisplay());
        fullItemTitle.setText(borrowMgr.getItem().getTitleDisplay());
        itemAuthor.setText("Author: " + borrowMgr.getItem().getAuthorDisplay());
        itemID.setText("Item ID: " + borrowMgr.getItem().getItemIDDisplay());
        String itemDescriptionText = borrowMgr.getItem().getDescriptionDisplay();
        itemDescription.setText(itemDescriptionText);
        //add the image to the bookcover field
        Image image = new Image(ModelController.BOOKCOVER_IMAGE_PATH + borrowMgr.getItem().getItemIDDisplay() + ".jpg"); 
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(130.0);
        imageView.setPreserveRatio(true);
        bookcoverField.getChildren().add(imageView);

        //make the book info field invisible
        itemMsg.setVisible(false);
        cleanMessages();
        //resize the content pane inside scroll pane accordign to the length of the text
        double height = computeTextHeight(itemDescriptionText ,60, 18.0);
        itemDescriptionAnchorPane.setPrefHeight(height);        
        
        //make the book info panel visible
        bookInfoPane.setVisible(true);

        //generate animation
        this.handleOnShowAnimation(bookInfoPane);
    }
    
    //compute the height needed for the scroll pane based on the text length
    private double computeTextHeight(String text, int charsPerLine, double lineHeight){
        return text.length() / charsPerLine * lineHeight;
    }
    
    //handle the borrow when the confirm button is pressed
    public void handleConfirmButtonAction(ActionEvent event){
        cleanMessages();
        try{
            PastTransaction transaction = borrowMgr.borrow();
            //set the text to be shown
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);
            messageHeader.setText("Thank you");
            String text = "Your request for loan of this item has been sucessfully granted.\n";
            text += "Kindly return by "+ format.format(transaction.getDateToReturn().getTime());
            messageText.setText(text);
            //set the style to be success
            setStyleSucess();
        }
        catch(NotEligibleToBorrowOrReserveException | SQLException | ClassNotFoundException e){
            messageHeader.setText("Sorry");
            String text = "We regret to inform you that your loan request was not granted.\n";
            text += "Reasons might be: \n";
            text += e.getMessage();
            messageText.setText(text);
            setStyleWarning();
        }
        finally{
            messagePane.setVisible(true);
            this.handleOnShowAnimation(messageHolderPane);
        }
    }
    
    private void setStyleSucess(){
        //message pane
        messagePane.getStyleClass().clear();
        messagePane.getStyleClass().add("success-pane");
        //button
        hideMessage.getStyleClass().clear();
        hideMessage.getStyleClass().add("success-button");       
    }
    
    private void setStyleWarning(){
        //message pane
        messagePane.getStyleClass().clear();
        messagePane.getStyleClass().add("warning-pane");
        //button
        hideMessage.getStyleClass().clear();
        hideMessage.getStyleClass().add("warning-button");
    }
    
    //clean up the previous result and warning messages
    private void cleanMessages(){        
        messageText.setText("");
        messageHeader.setText("");
    }

    //hide the message pane on action
    public void handleHideMessageButtonAction(ActionEvent event){
        messagePane.setVisible(false);
    }
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert messageText != null : "fx:id=\"MessageText\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert bookInfoPane != null : "fx:id=\"bookInfoPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert bookcoverField != null : "fx:id=\"bookcoverField\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert confirmBorrow != null : "fx:id=\"confirmBorrow\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert copyIDField != null : "fx:id=\"copyIDField\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert fullItemTitle != null : "fx:id=\"fullItemTitle\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert getDetails != null : "fx:id=\"getDetails\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert hideMessage != null : "fx:id=\"hideMessage\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemAuthor != null : "fx:id=\"itemAuthor\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemDescription != null : "fx:id=\"itemDescription\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemDescriptionAnchorPane != null : "fx:id=\"itemDescriptionAnchorPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemDescriptionScrollPane != null : "fx:id=\"itemDescriptionScrollPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemID != null : "fx:id=\"itemID\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemMsg != null : "fx:id=\"itemMsg\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemTitle != null : "fx:id=\"itemTitle\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert messageHeader != null : "fx:id=\"messageHeader\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert messageHolderPane != null : "fx:id=\"messageHolderPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert messagePane != null : "fx:id=\"messagePane\" was not injected: check your FXML file 'Borrow.fxml'.";


        // initialize your logic here: all @FXML variables will have been injected
        borrowMgr = new BorrowMgr();

    }
    
    
    @Override   //call the inherited method to update the current member
    public void setInitialData( ModelController modelController){      
        this.setModelController(modelController);
        //set the current member to borrow
        borrowMgr.setCurrentMember((Member)modelController.getUser());
    }
        
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane);
    }
}