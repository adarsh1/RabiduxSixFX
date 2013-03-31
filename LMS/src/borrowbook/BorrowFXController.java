/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package borrowbook;

import exception.TypeMismatchException;
import globalcontroller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import memberpage.MemberFXController;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import usermanagement.Member;


    // Handler for Button[Button[id=null, styleClass=button]] onAction
public class BorrowFXController extends MemberFXController implements Initializable{
    
    /* Manager classes  */
    private BorrowMgr borrowMgr;
   
    /* Borrow Control buttons */
    @FXML
    private AnchorPane contentPane;
    @FXML
    private Pane bookInfoPane;
    @FXML
    private ScrollPane itemDescriptionScrollPane;
    @FXML
    private AnchorPane itemDescriptionAnchorPane;
    @FXML
    private TextField itemIDField;
    @FXML
    private Button getBookDetails;
    @FXML
    private Label borrowMsg;
    @FXML
    private Pane bookcoverField;
    @FXML
    private Label itemTitle;
    @FXML
    private Label itemAuthor;
    @FXML
    private Label itemID;
    @FXML
    private Text itemDescription;
    @FXML
    private Button confirmBorrow;
    
    //constructor
    public BorrowFXController(){
        super();
        borrowMgr = new BorrowMgr();
    }
    
    // Handler for Button[Button[id=null, styleClass=button]] onAction
    
    public void handleGetBookDetailsButtonAction (ActionEvent event){
        try{            
            //create a borrowable item
            String copyID = itemIDField.getText();            
            borrowMgr.createItem(copyID);
            //display all the info about this copy
            itemTitle.setText(borrowMgr.getItem().getTitleDisplay());
            itemAuthor.setText(borrowMgr.getItem().getAuthorDisplay());
            String itemDescriptionText = borrowMgr.getItem().getDescriptionDisplay();
            itemDescription.setText(itemDescriptionText);
            //add the image to the bookcover field
            Image image = new Image(MainController.BOOKCOVER_IMAGE_PATH + borrowMgr.getItem().getItemIDDisplay() + ".jpg"); 
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(130.0);
            imageView.setPreserveRatio(true);
            bookcoverField.getChildren().add(imageView);
            
            //make the book info field invisible
            borrowMsg.setVisible(false);
            itemDescriptionScrollPane.setVisible(true);
            //resize the content pane inside scroll pane accordign to the length of the text
            double height = computeTextHeight(itemDescriptionText ,50, 18.0);
            itemDescriptionAnchorPane.setPrefHeight(height);
            
            
            //enable the confirm button
            confirmBorrow.setDisable(false);
            
            //generate animation
            this.handleNodeFadeTransition(bookInfoPane, 1000);
        }
        catch (SQLException | ClassNotFoundException | TypeMismatchException e){
            borrowMsg.setText(e.getMessage());
        }        
    }
    
    private double computeTextHeight(String text, int charsPerLine, double lineHeight){
        return text.length() / charsPerLine * lineHeight;
    }

    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file ";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file ";
        // initialize your logic here: all @FXML variables will have been injected

    }
    
    
    @Override   //call the inherited method to pass the maincontroller in, meanwhile update the current member
    public void setMainController (MainController mainController){
        super.setMainController(mainController);
        //set the current member to borrow
        borrowMgr.setCurrentMember((Member)mainController.getUser());
    }
        
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane, 500, 30.0);
    }
}