/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package returnbook;

import baseGUI.BaseFXController;
import cataloguemanagement.PastTransaction;
import exception.*;
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
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import usermanagement.Librarian;
import usermanagement.Member;


/**
 * FXML Controller class
 *
 * @author Adarsh
 */
public class ReturnFXController extends BaseFXController implements Initializable {

/* Manager classes  */
    private ReturnMgr returnMgr;

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

   
    
    // Handler for Button Get details onAction    
    /**
     *
     * @param event
     */
    public void handleGetDetailsButtonAction (ActionEvent event){
        try{                        
            getItemDetails();
        }
        catch (SQLException | ClassNotFoundException | TypeMismatchException |UserNotFoundException |CopyNotFoundException |ItemNotFoundException |InvalidUserTypeException e){
           // displayItemErrorMsg(e.getMessage());
            copyIDField.clear();
            String header = "No Item Found";
            String text = "Oops we could not find a Book with this Id\nPlease recheck your Book-ID or contact a Librarian for assistance.\n";
            text += "Error message:" + e.getMessage();
            displayWarning(header,text);
        }        
    }
    
    private void displayItemErrorMsg(String message){
        bookInfoPane.setVisible(false);
        itemMsg.setVisible(true);
        itemMsg.setText(message);
        this.handleOnShowAnimation(itemMsg, 500, 20.0);        
    }
    
    private void getItemDetails() throws SQLException, ClassNotFoundException, TypeMismatchException, UserNotFoundException ,CopyNotFoundException ,ItemNotFoundException ,InvalidUserTypeException{
        //create a borrowable item
        String copyID = copyIDField.getText();            
        returnMgr.createItem(copyID);
        //display all the info about this copy
        itemTitle.setText(returnMgr.getItem().getTitle());
        fullItemTitle.setText(returnMgr.getItem().getTitle());
        itemAuthor.setText("Author: " + returnMgr.getItem().getAuthor());
        itemID.setText("Item ID: " + returnMgr.getItem().getItemID());
        String itemDescriptionText = returnMgr.getItem().getDescription();
        itemDescription.setText(itemDescriptionText);
        //add the image to the bookcover field
        Image image = new Image(ModelController.BOOKCOVER_IMAGE_PATH + returnMgr.getItem().getItemID() + ".jpg"); 
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(130.0);
        imageView.setPreserveRatio(true);
        bookcoverField.getChildren().add(imageView);

        //make the book info field invisible
        itemMsg.setVisible(false);
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
    /**
     *
     * @param event
     */
    public void handleConfirmButtonAction(ActionEvent event){
        bookInfoPane.setVisible(false);
        try{
            if(!returnMgr.returnbook())
            {//set the text to be shown
             String text = "The book has been successfully returned.\nNo fine has been set on the user.";
             displaySuccess("Thank you",text);
            }
            else
            {
             
             String text = "The book has been successfully returned.\n";
             text += "A fine of " + returnMgr.getfine() + " is to be paid by the member";
             displaySuccess("Thank you",text);
             
            }
           }
        catch(SQLException | ClassNotFoundException |CopyNotFoundException| CopyNotBorrowedException| NullResultException  e){
            String text = "We regret to inform you that the book could not be returned.\n";
            text += "Reasons might be: \n";
            text += e.getMessage();
            displayWarning("Sorry",text);
        }
    }
    
    
    /**
     *
     * @param fxmlFileLocation
     * @param resources
     */
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert bookInfoPane != null : "fx:id=\"bookInfoPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert bookcoverField != null : "fx:id=\"bookcoverField\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert confirmBorrow != null : "fx:id=\"confirmBorrow\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert copyIDField != null : "fx:id=\"copyIDField\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert fullItemTitle != null : "fx:id=\"fullItemTitle\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert getDetails != null : "fx:id=\"getDetails\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemAuthor != null : "fx:id=\"itemAuthor\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemDescription != null : "fx:id=\"itemDescription\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemDescriptionAnchorPane != null : "fx:id=\"itemDescriptionAnchorPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemDescriptionScrollPane != null : "fx:id=\"itemDescriptionScrollPane\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemID != null : "fx:id=\"itemID\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemMsg != null : "fx:id=\"itemMsg\" was not injected: check your FXML file 'Borrow.fxml'.";
        assert itemTitle != null : "fx:id=\"itemTitle\" was not injected: check your FXML file 'Borrow.fxml'.";


        // initialize your logic here: all @FXML variables will have been injected
        returnMgr = new ReturnMgr();

    }
    
    
    /**
     *
     * @param modelController
     */
    @Override   //call the inherited method to update the current member
    public void setInitialData( ModelController modelController){      
        this.setModelController(modelController);
        //set the current member to borrow
        returnMgr.setCurrentLibrarian((Librarian)modelController.getUser());
    }
        
    /**
     *
     */
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane);
    }
}
