/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memberpage;

import baseGUI.BaseFXController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Allen
 */
public class MemberFXController extends BaseFXController implements Initializable {   
    
    
    @FXML //  fx:id="basePane"
    private AnchorPane basePane; // Value injected by FXMLLoader

    @FXML //  fx:id="borrowMenuButton"
    private Button borrowMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPlaceHolderPane"
    private Pane contentPlaceHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="footerPane"
    private Pane footerPane; // Value injected by FXMLLoader

    @FXML //  fx:id="helpPane"
    private Pane helpPane; // Value injected by FXMLLoader

    @FXML //  fx:id="helpText"
    private Text helpText; // Value injected by FXMLLoader

    @FXML //  fx:id="historyMenuButton"
    private Button historyMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="holdingMenuButton"
    private Button holdingMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="menuPane"
    private Pane menuPane; // Value injected by FXMLLoader

    @FXML //  fx:id="searchMenuButton"
    private Button searchMenuButton; // Value injected by FXMLLoader
    
    

    // Handler for Button[fx:id="borrow"] onAction
    public void handleborrowMenuButtonAction(ActionEvent event) {            
        transitPane("Borrow.fxml", getContentPlaceHolderPane(), this.getMainController());            
    }
    // Handler for Button[fx:id="history"] onAction
    public void handleHistoryTabAction(ActionEvent event) {
        Node node=(Node) event.getSource();
        //transitScene("/resources/xml/History.fxml",node);        
    }


    // Handler for Button[fx:id="search"] onAction
    public void handleSearchMenuButtonAction(ActionEvent event) {
        transitPane("Search.fxml", getContentPlaceHolderPane(), this.getMainController());         
    }

    // Handler for Button[fx:id="rentals"] onAction
    public void handleHoldingsMenuButtonAction(ActionEvent event) {
        transitPane("Holdings.fxml", getContentPlaceHolderPane(), this.getMainController());  
        //transitScene("/resources/xml/MyMaterial.fxml",node); 
    }
    
    @Override
    public void playOnShowAnimation(){
        //show search pane when first loaded
        transitPane("Search.fxml", getContentPlaceHolderPane(), this.getMainController()); 
        //animation for GUI on shown
        handleOnShowAnimation(menuPane, 500, 30.0);
        handleOnShowAnimation(getContentPlaceHolderPane(), 500, 30.0);
        handleOnShowAnimation(helpPane, 500, 30.0);
    }
    

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert basePane != null : "fx:id=\"basePane\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert borrowMenuButton != null : "fx:id=\"borrowMenuButton\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert contentPlaceHolderPane != null : "fx:id=\"contentPlaceHolderPane\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert footerPane != null : "fx:id=\"footerPane\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert helpPane != null : "fx:id=\"helpPane\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert helpText != null : "fx:id=\"helpText\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert historyMenuButton != null : "fx:id=\"historyMenuButton\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert holdingMenuButton != null : "fx:id=\"holdingMenuButton\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert menuPane != null : "fx:id=\"menuPane\" was not injected: check your FXML file 'MemberPage.fxml'.";
        assert searchMenuButton != null : "fx:id=\"searchMenuButton\" was not injected: check your FXML file 'MemberPage.fxml'.";

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

    /**
     * @return the contentPlaceHolderPane
     */
    public Pane getContentPlaceHolderPane() {
        return contentPlaceHolderPane;
    }

    /**
     * @param contentPlaceHolderPane the contentPlaceHolderPane to set
     */
    public void setContentPlaceHolderPane(Pane contentPlaceHolderPane) {
        this.contentPlaceHolderPane = contentPlaceHolderPane;
    }
    
    
}
