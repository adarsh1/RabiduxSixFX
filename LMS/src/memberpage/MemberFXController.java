/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memberpage;

import baseGUI.BaseFXController;
import borrowbook.BorrowMgr;
import exception.TypeMismatchException;
import globalcontroller.MainController;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import usermanagement.Member;

/**
 * FXML Controller class
 *
 * @author Allen
 */
public class MemberFXController extends BaseFXController implements Initializable {
    
    /* Manager classes  */
    private BorrowMgr borrowMgr;
    
    @FXML
    private AnchorPane basePane;    
    @FXML
    private Pane helpPane;    
    @FXML
    private Pane contentPane;    
    @FXML
    private Pane menuPane;
        
    /* Menu control buttons */
    @FXML
    private Button searchMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="history"
    private Button BorrowMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="home"
    private Button holdingMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="myMaterial"
    private Button historyMenuButton; // Value injected by FXMLLoader
    
    /* Borrow Control buttons */
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

    
    public MemberFXController(){
        borrowMgr = new BorrowMgr();
    }
    
    
    // Handler for Button[fx:id="home"] onAction
    public void handleHomeTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        //transitScene("/resources/xml/WelcomeMember.fxml",node);
    }

    // Handler for Button[fx:id="borrow"] onAction
    public void handleBorrowTabAction(ActionEvent event) {        
        Node node=(Node) event.getSource();
        //transitScene("/resources/xml/Borrow.fxml",node);               
    }
    // Handler for Button[fx:id="history"] onAction
    public void handleHistoryTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        //transitScene("/resources/xml/History.fxml",node);        
    }


    // Handler for Button[fx:id="search"] onAction
    public void handleSearchTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        //transitScene("/resources/xml/Search.fxml",node);        
    }

    // Handler for Button[fx:id="rentals"] onAction
    public void handleMyMaterialTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        //transitScene("/resources/xml/MyMaterial.fxml",node); 
    }
    
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
        assert BorrowMenuButton != null : "fx:id=\"borrow\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert historyMenuButton != null : "fx:id=\"history\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert holdingMenuButton != null : "fx:id=\"rentals\" was not injected: check your FXML file 'Welcome.fxml'.";
        assert searchMenuButton != null : "fx:id=\"search\" was not injected: check your FXML file 'Welcome.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
    }
    
    @Override
    public void setMC(MainController MC){
        super.setMC(MC);
        //downcast this user to member type
        borrowMgr.setCurrentMember((Member)(this.getMC().getUser()));
    }

    /**
     * @return the basePane
     */
    public AnchorPane getBasePane() {
        return basePane;
    }

    /**
     * @param basePane the basePane to set
     */
    public void setBasePane(AnchorPane basePane) {
        this.basePane = basePane;
    }

    /**
     * @return the helpPane
     */
    public Pane getHelpPane() {
        return helpPane;
    }

    /**
     * @param helpPane the helpPane to set
     */
    public void setHelpPane(Pane helpPane) {
        this.helpPane = helpPane;
    }

    /**
     * @return the contentPane
     */
    public Pane getContentPane() {
        return contentPane;
    }

    /**
     * @param contentPane the contentPane to set
     */
    public void setContentPane(Pane contentPane) {
        this.contentPane = contentPane;
    }

    /**
     * @return the menuPane
     */
    public Pane getMenuPane() {
        return menuPane;
    }

    /**
     * @param menuPane the menuPane to set
     */
    public void setMenuPane(Pane menuPane) {
        this.menuPane = menuPane;
    }
    
    
}
