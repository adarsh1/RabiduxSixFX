
package updatecatalogue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Adarsh
 */

public class UpdateCatalogueFXController
    implements Initializable {

    @FXML //  fx:id="DVDType"
    private RadioButton DVDType; // Value injected by FXMLLoader

    @FXML //  fx:id="ItemTitle"
    private Label ItemTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="bookType"
    private RadioButton bookType; // Value injected by FXMLLoader

    @FXML //  fx:id="confirmButton"
    private Button confirmButton; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="deleteItemPane"
    private Tab deleteItemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="hideMessage"
    private Button hideMessage; // Value injected by FXMLLoader

    @FXML //  fx:id="itemAuthor"
    private Label itemAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="itemAuthorField"
    private TextField itemAuthorField; // Value injected by FXMLLoader

    @FXML //  fx:id="itemDescription"
    private Label itemDescription; // Value injected by FXMLLoader

    @FXML //  fx:id="itemDescriptionField"
    private TextArea itemDescriptionField; // Value injected by FXMLLoader

    @FXML //  fx:id="itemGenre"
    private Label itemGenre; // Value injected by FXMLLoader

    @FXML //  fx:id="itemGenreField"
    private TextField itemGenreField; // Value injected by FXMLLoader

    @FXML //  fx:id="itemISBN"
    private Label itemISBN; // Value injected by FXMLLoader

    @FXML //  fx:id="itemISBNField"
    private TextField itemISBNField; // Value injected by FXMLLoader

    @FXML //  fx:id="itemPublishDate"
    private Label itemPublishDate; // Value injected by FXMLLoader

    @FXML //  fx:id="itemPublishDateField"
    private TextField itemPublishDateField; // Value injected by FXMLLoader

    @FXML //  fx:id="itemTitleField"
    private TextField itemTitleField; // Value injected by FXMLLoader

    @FXML //  fx:id="itemType"
    private Label itemType; // Value injected by FXMLLoader

    @FXML //  fx:id="messageHeader"
    private Label messageHeader; // Value injected by FXMLLoader

    @FXML //  fx:id="messageHolderPane"
    private AnchorPane messageHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="messagePane"
    private AnchorPane messagePane; // Value injected by FXMLLoader

    @FXML //  fx:id="messageText"
    private Label messageText; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPane"
    private AnchorPane newItemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemPane"
    private AnchorPane updateItemPane; // Value injected by FXMLLoader


    // Handler for Button[fx:id="hideMessage"] onAction
    public void handleHideMessageButtonAction(ActionEvent event) {
        // handle the event here
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert DVDType != null : "fx:id=\"DVDType\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert ItemTitle != null : "fx:id=\"ItemTitle\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert bookType != null : "fx:id=\"bookType\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert deleteItemPane != null : "fx:id=\"deleteItemPane\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert hideMessage != null : "fx:id=\"hideMessage\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemAuthor != null : "fx:id=\"itemAuthor\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemAuthorField != null : "fx:id=\"itemAuthorField\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemDescription != null : "fx:id=\"itemDescription\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemDescriptionField != null : "fx:id=\"itemDescriptionField\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemGenre != null : "fx:id=\"itemGenre\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemGenreField != null : "fx:id=\"itemGenreField\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemISBN != null : "fx:id=\"itemISBN\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemISBNField != null : "fx:id=\"itemISBNField\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemPublishDate != null : "fx:id=\"itemPublishDate\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemPublishDateField != null : "fx:id=\"itemPublishDateField\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemTitleField != null : "fx:id=\"itemTitleField\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert itemType != null : "fx:id=\"itemType\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert messageHeader != null : "fx:id=\"messageHeader\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert messageHolderPane != null : "fx:id=\"messageHolderPane\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert messagePane != null : "fx:id=\"messagePane\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert messageText != null : "fx:id=\"messageText\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert newItemPane != null : "fx:id=\"newItemPane\" was not injected: check your FXML file 'UpdateItem.fxml'.";
        assert updateItemPane != null : "fx:id=\"updateItemPane\" was not injected: check your FXML file 'UpdateItem.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }

}
