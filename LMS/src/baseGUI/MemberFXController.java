/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Allen
 */
public class MemberFXController extends BaseFXController implements Initializable {
    
    @FXML
    private AnchorPane basePane;
    
    @FXML
    private Pane helpPane;
    
    @FXML
    private Pane contentPane;
    
    @FXML
    private Pane menuPane;
        
    @FXML
    private Button searchMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="history"
    private Button BorrowMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="home"
    private Button holdingMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="myMaterial"
    private Button historyMenuButton; // Value injected by FXMLLoader

    
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
