/**
 *
 * @author Adarsh
 */

package searchbook;

import baseGUI.BaseFXController;
import globalcontrol.ModelController;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import usermanagement.Member;


public class IndividualViewGUIController extends BaseFXController implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="author"
    private Label author; // Value injected by FXMLLoader

    @FXML // fx:id="borrowablecopies"
    private Label borrowablecopies; // Value injected by FXMLLoader

    @FXML // fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML // fx:id="cover"
    private ImageView cover; // Value injected by FXMLLoader

    @FXML // fx:id="genre"
    private Label genre; // Value injected by FXMLLoader

    @FXML // fx:id="individualPane"
    private ScrollPane individualPane; // Value injected by FXMLLoader

    @FXML // fx:id="isbn"
    private Label isbn; // Value injected by FXMLLoader

    @FXML // fx:id="itemDescription"
    private Text itemDescription; // Value injected by FXMLLoader

    @FXML // fx:id="itemDescriptionAnchorPane"
    private AnchorPane itemDescriptionAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="itemDescriptionScrollPane"
    private ScrollPane itemDescriptionScrollPane; // Value injected by FXMLLoader

    @FXML // fx:id="reservablecopies"
    private Label reservablecopies; // Value injected by FXMLLoader

    @FXML // fx:id="scrollPane"
    private ScrollPane scrollPane; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private Label title; // Value injected by FXMLLoader

    @FXML // fx:id="vb"
    private VBox vb; // Value injected by FXMLLoader
    
    private IndividualViewGUIMgr individualMgr;


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert borrowablecopies != null : "fx:id=\"borrowablecopies\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert cover != null : "fx:id=\"cover\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert genre != null : "fx:id=\"genre\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert individualPane != null : "fx:id=\"individualPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert isbn != null : "fx:id=\"isbn\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert itemDescription != null : "fx:id=\"itemDescription\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert itemDescriptionAnchorPane != null : "fx:id=\"itemDescriptionAnchorPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert itemDescriptionScrollPane != null : "fx:id=\"itemDescriptionScrollPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert reservablecopies != null : "fx:id=\"reservablecopies\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert vb != null : "fx:id=\"vb\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected        
        individualMgr = new IndividualViewGUIMgr();
    }
public void setId(String id){
    individualMgr.setItem(null);
    try{
        individualMgr.createItem(id);
    }
    catch(SQLException e)
    {
        transitPane("Search.fxml", contentPane, getModelController());
    }
    catch(ClassNotFoundException e){
    ;
    }
    title.setText(individualMgr.getItem().getItemTitle());
    title.setTooltip(new Tooltip(title.getText()));
    title.setTextOverrun( OverrunStyle.CENTER_WORD_ELLIPSIS);
    
    author.setText("Author: "+individualMgr.getItem().getItemAuthor());
    try
       {cover.setImage(new Image(IndividualViewGUIController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + id + ".jpg")));
       }
       catch(Exception e)
       {
        cover.setImage(new Image(IndividualViewGUIController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + "default_book_cover.jpg")));
       }
   //Need Genre
    genre.setText("Genre: "+"Education");
    
    //Need item Description
    String itemDescriptionText = "Introduction to Java Programming, Comprehensive, 9e, features comprehensive coverage ideal for a one-, two-, or three-semester CS1 course sequence.";
    itemDescription.setText(itemDescriptionText);
    double height = computeTextHeight(itemDescriptionText ,42, 12);
    itemDescriptionAnchorPane.setPrefHeight(height); 
    
    //Need ISBN
    isbn.setText("(ISBN: "+"978-0132995177"+")");
    
    borrowablecopies.setText("Borrowable Copies: "+individualMgr.getItem().getCopiesAvailable());
    reservablecopies.setText("Borrowable Copies: "+"0");
}
private double computeTextHeight(String text, int charsPerLine, double lineHeight){
        return text.length() / charsPerLine * lineHeight;
    }
@Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane);
    }

    @Override   //call the inherited method to update the current member
    public void setInitialData(ModelController modelController) {
        this.setModelController(modelController);
        //set the current member to borrow
        individualMgr.setCurrentMember((Member)modelController.getUser());
    }
}
