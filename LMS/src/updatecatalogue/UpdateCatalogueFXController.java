package updatecatalogue;

import baseGUI.BaseFXController;
import globalcontrol.ModelController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Adarsh
 */

public class UpdateCatalogueFXController extends BaseFXController
    implements Initializable {
    
    private UpdateMgr updateMgr;

    @FXML //  fx:id="actionHolderPane"
    private AnchorPane actionHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="bookType"
    private RadioButton bookType; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="getCopyDetailsButton"
    private Button getCopyDetailsButton; // Value injected by FXMLLoader

    @FXML //  fx:id="getItemDetailsButton"
    private Button getItemDetailsButton; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyButton"
    private Button newCopyButton; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyConfirmButton"
    private Button newCopyConfirmButton; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyItemID"
    private TextField newCopyItemID; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyLocation"
    private TextField newCopyLocation; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyPane"
    private AnchorPane newCopyPane; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemAuthor"
    private TextField newItemAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemButton"
    private Button newItemButton; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemConfirm"
    private Button newItemConfirm; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemDescription"
    private TextArea newItemDescription; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemGenre"
    private TextField newItemGenre; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemISBN"
    private TextField newItemISBN; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPane"
    private AnchorPane newItemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPublishDate"
    private TextField newItemPublishDate; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemTitle"
    private TextField newItemTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyButton"
    private Button updateCopyButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyConfirmButton"
    private Button updateCopyConfirmButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyID"
    private TextField updateCopyID; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyLocation"
    private TextField updateCopyLocation; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyPane"
    private AnchorPane updateCopyPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemAuthor"
    private TextField updateItemAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemButton"
    private Button updateItemButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemConfirmButton"
    private Button updateItemConfirmButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemDescription"
    private TextArea updateItemDescription; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemGenre"
    private TextField updateItemGenre; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemISBN"
    private TextField updateItemISBN; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemInfoPane"
    private AnchorPane updateItemInfoPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemPane"
    private AnchorPane updateItemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemPublishDate"
    private TextField updateItemPublishDate; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemTitle"
    private TextField updateItemTitle; // Value injected by FXMLLoader


    // Handler for Button[fx:id="getCopyDetailsButton"] onAction
    public void handleGetCopyDetailsButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="newCopyButton"] onAction
    public void handleNewCopyButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="newCopyConfirmButton"] onAction
    public void handleNewCopyConfirmButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="newItemButton"] onAction
    public void handleNewItemButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="updateCopyButton"] onAction
    public void handleUpdateCopyButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="updateCopyConfirmButton"] onAction
    public void handleUpdateCopyConfirmButtonAction(ActionEvent event) {
        // handle the event here
    }

    // Handler for Button[fx:id="updateItemButton"] onAction
    public void handleUpdateItemButtonAction(ActionEvent event) {
        // handle the event here
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert actionHolderPane != null : "fx:id=\"actionHolderPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert bookType != null : "fx:id=\"bookType\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert getCopyDetailsButton != null : "fx:id=\"getCopyDetailsButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert getItemDetailsButton != null : "fx:id=\"getItemDetailsButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert hideMessage != null : "fx:id=\"hideMessage\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageHeader != null : "fx:id=\"messageHeader\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageHolderPane != null : "fx:id=\"messageHolderPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messagePane != null : "fx:id=\"messagePane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageText != null : "fx:id=\"messageText\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyButton != null : "fx:id=\"newCopyButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyConfirmButton != null : "fx:id=\"newCopyConfirmButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyItemID != null : "fx:id=\"newCopyItemID\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyLocation != null : "fx:id=\"newCopyLocation\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyPane != null : "fx:id=\"newCopyPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemAuthor != null : "fx:id=\"newItemAuthor\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemButton != null : "fx:id=\"newItemButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemConfirm != null : "fx:id=\"newItemConfirm\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemDescription != null : "fx:id=\"newItemDescription\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemGenre != null : "fx:id=\"newItemGenre\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemISBN != null : "fx:id=\"newItemISBN\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemPane != null : "fx:id=\"newItemPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemPublishDate != null : "fx:id=\"newItemPublishDate\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemTitle != null : "fx:id=\"newItemTitle\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyButton != null : "fx:id=\"updateCopyButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyConfirmButton != null : "fx:id=\"updateCopyConfirmButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyID != null : "fx:id=\"updateCopyID\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyLocation != null : "fx:id=\"updateCopyLocation\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyPane != null : "fx:id=\"updateCopyPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemAuthor != null : "fx:id=\"updateItemAuthor\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemButton != null : "fx:id=\"updateItemButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemConfirmButton != null : "fx:id=\"updateItemConfirmButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemDescription != null : "fx:id=\"updateItemDescription\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemGenre != null : "fx:id=\"updateItemGenre\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemISBN != null : "fx:id=\"updateItemISBN\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemInfoPane != null : "fx:id=\"updateItemInfoPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemPane != null : "fx:id=\"updateItemPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemPublishDate != null : "fx:id=\"updateItemPublishDate\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemTitle != null : "fx:id=\"updateItemTitle\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
        updateMgr = new UpdateMgr();
    }

    @Override
    public void setInitialData(ModelController modelController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void playOnShowAnimation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

