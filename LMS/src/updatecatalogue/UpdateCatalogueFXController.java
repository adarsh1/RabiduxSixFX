
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


    @FXML //  fx:id="DVDType"
    private RadioButton DVDType; // Value injected by FXMLLoader

    @FXML //  fx:id="bookType"
    private RadioButton bookType; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemAuthor"
    private Label newItemAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemAuthorField"
    private TextField newItemAuthorField; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemConfirm"
    private Button newItemConfirm; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemDescription"
    private Label newItemDescription; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemDescriptionField"
    private TextArea newItemDescriptionField; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemGenre"
    private Label newItemGenre; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemGenreField"
    private TextField newItemGenreField; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemISBN"
    private Label newItemISBN; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemISBNField"
    private TextField newItemISBNField; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPane"
    private AnchorPane newItemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPublishDate"
    private Label newItemPublishDate; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPublishDateField"
    private TextField newItemPublishDateField; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemTitle"
    private Label newItemTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemTitleField"
    private TextField newItemTitleField; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemType"
    private Label newItemType; // Value injected by FXMLLoader


    // Handler for Button[fx:id="hideMessage"] onAction
    public void handleHideMessageButtonAction(ActionEvent event) {
        // handle the event here
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert DVDType != null : "fx:id=\"DVDType\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert bookType != null : "fx:id=\"bookType\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert hideMessage != null : "fx:id=\"hideMessage\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageHeader != null : "fx:id=\"messageHeader\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageHolderPane != null : "fx:id=\"messageHolderPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messagePane != null : "fx:id=\"messagePane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageText != null : "fx:id=\"messageText\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemAuthor != null : "fx:id=\"newItemAuthor\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemAuthorField != null : "fx:id=\"newItemAuthorField\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemConfirm != null : "fx:id=\"newItemConfirm\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemDescription != null : "fx:id=\"newItemDescription\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemDescriptionField != null : "fx:id=\"newItemDescriptionField\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemGenre != null : "fx:id=\"newItemGenre\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemGenreField != null : "fx:id=\"newItemGenreField\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemISBN != null : "fx:id=\"newItemISBN\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemISBNField != null : "fx:id=\"newItemISBNField\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemPane != null : "fx:id=\"newItemPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemPublishDate != null : "fx:id=\"newItemPublishDate\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemPublishDateField != null : "fx:id=\"newItemPublishDateField\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemTitle != null : "fx:id=\"newItemTitle\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemTitleField != null : "fx:id=\"newItemTitleField\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemType != null : "fx:id=\"newItemType\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

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
