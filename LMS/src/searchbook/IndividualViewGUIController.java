/**
 * Sample Skeleton for "IndividualReservableGUI.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package searchbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class IndividualViewGUIController {

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


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
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

    }

}
