/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memberpage;

import baseGUI.BaseFXController;
import globalcontrol.ModelController;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Allen
 */
public class MemberFXController extends BaseFXController implements Initializable,Observer {   
    
    
    @FXML //  fx:id="basePane"
    private AnchorPane basePane; // Value injected by FXMLLoader

    @FXML //  fx:id="borrowMenuButton"
    private Button borrowMenuButton; // Value injected by FXMLLoader

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

    @FXML //  fx:id="holdingMenuButton"
    private Button holdingMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="menuPane"
    private Pane menuPane; // Value injected by FXMLLoader

    @FXML //  fx:id="searchMenuButton"
    private Button searchMenuButton; // Value injected by FXMLLoader

    @FXML //  fx:id="username"
    private Label username; // Value injected by FXMLLoader
    
    @FXML //  fx:id="logoutHeader"
    private Label logoutHeader; // Value injected by FXMLLoader
    
    @FXML //  fx:id="logoutText"
    private Label logoutText; // Value injected by FXMLLoader
    
    @FXML //  fx:id="yesLogout"
    private Button yesLogout; // Value injected by FXMLLoader
    
    @FXML //  fx:id="noLogout"
    private Button noLogout; // Value injected by FXMLLoader
    
    @FXML //  fx:id="logoutMessageHolderPane"
    private AnchorPane logoutMessageHolderPane; // Value injected by FXMLLoader
    
    @FXML //  fx:id="logoutMessageHolderPane"
    private AnchorPane logoutPane; // Value injected by FXMLLoader

    @FXML //  fx:id="logoutbutton"
    private Label logoutbutton; // Value injected by FXMLLoader
    
    
    /**
     *
     * @param event
     */
    public void handleLogoutYesButtonAction(ActionEvent event){
        Node node=(Node) event.getSource();
        gotologin(node); 
    }
     /**
     *
     * @param event
     */
    public void handleLogoutNoButtonAction(ActionEvent event){
        String [] exceptions={""};
        enableAllPanes(exceptions);
        logoutPane.setVisible(false);
    }
    // Handler for Button[fx:id="borrow"] onAction
    /**
     *
     * @param event
     */
    public void handleborrowMenuButtonAction(ActionEvent event) {            
       transitPane("Borrow.fxml"); 
    }
    // Handler for Button[fx:id="history"] onAction
    /**
     *
     * @param event
     */
    public void handleHistoryMenuButtonAction(ActionEvent event) {
        transitPane("History.fxml");
    }   

    // Handler for Button[fx:id="search"] onAction
    /**
     *
     * @param event
     */
    public void handleSearchMenuButtonAction(ActionEvent event) {
        transitPane("Search.fxml");
    }

    // Handler for Button[fx:id="rentals"] onAction
    /**
     *
     * @param event
     */
    public void handleHoldingsMenuButtonAction(ActionEvent event) {
        transitPane("Holdings.fxml");
    }
    
    
    // Handler for Label[fx:id="logoutbutton"] onMouseClicked
    /**
     *
     * @param event
     */
    public void logoutbuttonhandler(MouseEvent event) {
        
        
        logoutHeader.setText("Confirm Logout");
            String text = username.getText()+" are you sure you want to logout?";
        logoutText.setText(text);
         String [] exceptions={""};
        disableAllPanes(exceptions);
        
        logoutPane.setVisible(true);
        this.handleOnShowAnimation(logoutMessageHolderPane);
    } 

    @Override
    public void update(Observable o, Object arg){
        if(o instanceof BaseFXController){
            BaseFXController bfc=(BaseFXController)o;
            if(arg instanceof Boolean){
                Boolean disable=(Boolean)arg;
                String [] exceptions={bfc.getMessagePaneID()};
                if(disable.booleanValue()==true){
                    
                    disableAllPanes(exceptions);
                }
                else{    
                    enableAllPanes(exceptions);
                } 
            }
            else if(arg instanceof Observable){
                Observable ob=(Observable)arg;
                ob.addObserver(this);
            }
            else if(arg instanceof String){
                String s=(String) arg;
                if(s.endsWith(".fxml"))
                   transitPane(s);
            }
            else if(arg instanceof Exception){
                transitPane("Search.fxml");
                displayWarning("Serious Error","Oops something went wrong from our side.\n The reason might be:\n"+((Exception)arg).getMessage());
            }
        }
    }

    private void gotologin(Node node)
    {
        transitScene("Login.fxml", node);
    }
     
    
    /**
     *
     */
    @Override
    public void playOnShowAnimation(){         
        //show search pane when first loaded
        BaseFXController bc=transitPane("Search.fxml", getContentPlaceHolderPane(), this.getModelController()).getController();
        bc.addObserver(this);
        //animation for GUI on shown
        handleOnShowAnimation(basePane);
    }
    

    /**
     *
     * @param fxmlFileLocation
     * @param resources
     */
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
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'MemberPage.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
    }    

    
    /**
     *
     * @param modelController
     */
    @Override   //set up the content once the ModelController is available
    public void setInitialData( ModelController modelController){
        this.addObserver(this);
        username.setText(modelController.getUser().getUsername());
        helpText.setText("RabidusSIX Library Management System serves you the best. If you have any question while using the system or encounter any bugs, please feel free to contact us at 94715985");
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
    public void setContentPlaceHolderPane(AnchorPane contentPlaceHolderPane) {
        this.contentPlaceHolderPane = contentPlaceHolderPane;
    }
    
    private void disableAllPanes(String []idExcept) {
        enableDisablePanes(idExcept ,true);
    }

    private void enableAllPanes(String []idExcept) {
        enableDisablePanes(idExcept ,false);
    }
    
    private void enableDisablePanes(String [] idExcept ,boolean flag){
        footerPane.setDisable(flag);
        menuPane.setDisable(flag);
        Pane p=(Pane)contentPlaceHolderPane.getChildren().get(0);
        for(int i=0;i<p.getChildren().size(); i++){
            Node n=p.getChildren().get(i);
            String nid=n.getId();
            if(nid==null)
                n.setDisable(flag);
            else
            {boolean idOk=true;
             for(int j=0;j<idExcept.length;j++)
             {
                 if(nid.equals(idExcept[j]))
                 { idOk=false;
                   break;
                 }
             }
             if(idOk)
                n.setDisable(flag);
            
            }
        }
    }
    
    /**
     *
     * @param resourceURL
     * @param placeHolderPane
     * @param modelController
     * @return
     */
    @Override
    public FXMLLoader transitPane(String resourceURL, Pane placeHolderPane, ModelController modelController){
        FXMLLoader fl = super.transitPane(resourceURL, placeHolderPane, modelController);
        BaseFXController bc = fl.getController();         
        bc.addObserver((Observer)(this));
        return fl;
    }
    
    //overloading transitPane function without placeholder or modelcontroller
    /**
     *
     * @param resourceURL
     * @return
     */
    public FXMLLoader transitPane(String resourceURL){
       return transitPane(resourceURL, getContentPlaceHolderPane(), this.getModelController());
    }
}
    
