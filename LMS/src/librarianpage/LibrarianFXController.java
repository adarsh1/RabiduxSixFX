/**
 * Sample Skeleton for "LibrarianPage.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package librarianpage;

import baseGUI.BaseFXController;
import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class LibrarianFXController extends BaseFXController implements Initializable {

    @FXML //  fx:id="basePane"
    private AnchorPane basePane; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPlaceHolderPane"
    private AnchorPane contentPlaceHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="footerPane"
    private Pane footerPane; // Value injected by FXMLLoader

    @FXML //  fx:id="helpPane"
    private Pane helpPane; // Value injected by FXMLLoader

    @FXML //  fx:id="helpText"
    private Text helpText; // Value injected by FXMLLoader

    @FXML //  fx:id="historyMenuButton"
    private Button historyMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="logoutbutton"
    private Label logoutbutton; // Value injected by FXMLLoader

    @FXML //  fx:id="menuPane"
    private Pane menuPane; // Value injected by FXMLLoader

    @FXML //  fx:id="resetFineMenuButton"
    private Button resetFineMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="returnMenuButton"
    private Button returnMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateMenuButton"
    private Button updateMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="username"
    private Label username; // Value injected by FXMLLoader


    // Handler for Button[fx:id="historyMenuButton"] onAction
    public void handleHistoryMenuButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="returnMenuButton"] onAction
    public void handleReturnMenuButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="resetFineMenuButton"] onAction
    public void handlefineMenuButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="updateMenuButton"] onAction
    public void handleupdateMenuButtonAction(ActionEvent event) {
        // handle the event here
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert basePane != null : "fx:id=\"basePane\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert contentPlaceHolderPane != null : "fx:id=\"contentPlaceHolderPane\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert footerPane != null : "fx:id=\"footerPane\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert helpPane != null : "fx:id=\"helpPane\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert helpText != null : "fx:id=\"helpText\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert historyMenuButton != null : "fx:id=\"historyMenuButton\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert logoutbutton != null : "fx:id=\"logoutbutton\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert menuPane != null : "fx:id=\"menuPane\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert resetFineMenuButton != null : "fx:id=\"resetFineMenuButton\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert returnMenuButton != null : "fx:id=\"returnMenuButton\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert updateMenuButton != null : "fx:id=\"updateMenuButton\" was not injected: check your FXML file 'LibrarianPage.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'LibrarianPage.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }

    
    @Override   //set up the content once the ModelController is available
    public void setInitialData( ModelController modelController){
        username.setText(modelController.getUser().getUsername());        
    }
    
    
    @Override
    public void playOnShowAnimation(){         
        //show search pane when first loaded
        transitPane("Return.fxml", getContentPlaceHolderPane(), this.getModelController()); 
        //animation for GUI on shown
        handleOnShowAnimation(basePane);
    }
    
    public Pane getContentPlaceHolderPane() {
        return contentPlaceHolderPane;
    }
    
    // Handler for Label[fx:id="logoutbutton"] onMouseClicked
    public void logoutbuttonhandler(MouseEvent event) {
        
        final Node node=(Node) event.getSource();
        final ModelController mc = this.getModelController();
        
        final Popup confirmLogOut = new Popup();
        confirmLogOut.centerOnScreen();
        VBox popUpVBox = new VBox(10);
        popUpVBox.setPadding(new Insets(10));
    
        Text logMes=new Text(" Are you sure you\nwant to log out?");
        logMes.setFill(Color.BLACK);
        logMes.setFont(Font.font("Segoe", 16));
    
        HBox popUpBoxButtons = new HBox(30);
        popUpBoxButtons.setPadding(new Insets(10));
    
        popUpVBox.getChildren().add(logMes);
    
        Button yes=new Button("Yes");
        Button no=new Button("No");
        //Remove Blue Borders
        /*yes.setStyle("-fx-background-insets:0, 0, 1, 2;");
        no.setStyle("-fx-background-insets:0, 0, 1, 2;");*/

        popUpBoxButtons.getChildren().addAll(yes,no);
        popUpVBox.getChildren().add(popUpBoxButtons);
        //Style the pop up box
        //popUpVBox.setStyle("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.75) , 5, 1, 0 , 1 );-fx-background-color: radial-gradient(focus-angle 0deg , focus-distance 0% , center 50% 50% , radius 50% , #a9a9a9, #475871);");
        popUpVBox.getStylesheets().add(BaseFXController.class.getResource(ModelController.JMETRO_PATH+"JMetroLightTheme.css").toExternalForm());
        confirmLogOut.getContent().add(popUpVBox);
    
        Stage stage=(Stage) node.getScene().getWindow();
        //Set the pop up
        confirmLogOut.show(stage);
  
        yes.setOnMouseClicked(new EventHandler<MouseEvent>()
        {            
            @Override
            public void handle(MouseEvent t){
            confirmLogOut.hide();
            gotologin(node,mc); 
            }
        }
            );
        no.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent t){
                confirmLogOut.hide();}
        }
            );
    }    
    
    private void gotologin(Node node,ModelController mc)
    {
        transitScene("Login.fxml", node, mc);
    }

}
