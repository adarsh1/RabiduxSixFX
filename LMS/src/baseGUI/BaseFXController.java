
package baseGUI;

import globalcontrol.ModelController;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class BaseFXController extends Observable implements Initializable, Animatable {
    @FXML //  fx:id="hideMessage"
    protected Button hideMessage; // Value injected by FXMLLoader
    
    @FXML //  fx:id="MessageText"
    protected Label messageText; // Value injected by FXMLLoader
    
    @FXML //  fx:id="messageHeader"
    protected Label messageHeader; // Value injected by FXMLLoader

    @FXML //  fx:id="messageHolderPane"
    protected AnchorPane messageHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="messagePane"
    protected AnchorPane messagePane; // Value injected by FXMLLoader
    
    @FXML //  fx:id="logout"
    protected ImageView logout; // Value injected by FXMLLoader

    @FXML //  fx:id="name"
    protected Text name; // Value injected by FXMLLoader
    
    //main controller
    private ModelController modelController;
    
    private void setStyleSucess(){
        //message pane
        messagePane.getStyleClass().clear();
        messagePane.getStyleClass().add("success-pane");
        //button
        hideMessage.getStyleClass().clear();
        hideMessage.getStyleClass().add("success-button");       
    }
    private void setStyleWarning(){
        //message pane
        messagePane.getStyleClass().clear();
        messagePane.getStyleClass().add("warning-pane");
        //button
        hideMessage.getStyleClass().clear();
        hideMessage.getStyleClass().add("warning-button");
    }
    
    //clean up the previous result and warning messages
    private void cleanMessages(){        
        messageText.setText("");
        messageHeader.setText("");
    }
    //handle the borrow when the confirm button is pressed
    public void displaySuccess(String header,String text)
    {setStyleSucess();
    messageHeader.setText(header);
    messageText.setText(text);
     messagePane.setVisible(true);
     this.handleOnShowAnimation(messageHolderPane);
     disableAll();
    }
    public void displayWarning(String header,String text)
    {setStyleWarning();
    messageHeader.setText(header);
    messageText.setText(text);
     messagePane.setVisible(true);
     this.handleOnShowAnimation(messageHolderPane);
     disableAll();
    }
    public String getMessagePaneID()
    {return messagePane.getId();
    }
    public void handleHideMessageButtonAction(ActionEvent event){
        messagePane.setVisible(false);
        enableAll();
    }
    /*
    public void logout(MouseEvent event) {
        
   final Popup confirmLogOut = new Popup();
   confirmLogOut.centerOnScreen();
    VBox popUpVBox = new VBox(10);
     popUpVBox.setPadding(new Insets(10));
    
    Text logMes=new Text(" Are you sure you\nwant to log out?");
    logMes.setFill(Color.WHITESMOKE);
    logMes.setFont(Font.font("Minion Pro", 16));
    
    HBox popUpBoxButtons = new HBox(30);
    popUpBoxButtons.setPadding(new Insets(10));
    
    popUpVBox.getChildren().add(logMes);
    
    Button yes=new Button("Yes");
    Button no=new Button("No");
    //Remove Blue Borders
    yes.setStyle("-fx-background-insets:0, 0, 1, 2;");
    no.setStyle("-fx-background-insets:0, 0, 1, 2;");

    popUpBoxButtons.getChildren().addAll(yes,no);
    popUpVBox.getChildren().add(popUpBoxButtons);
    //Style the pop up box
    popUpVBox.setStyle("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.75) , 5, 1, 0 , 1 );-fx-background-color: radial-gradient(focus-angle 0deg , focus-distance 0% , center 50% 50% , radius 50% , #a9a9a9, #475871);");
    confirmLogOut.getContent().add(popUpVBox);
    
    Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
  //Set the pop up
  confirmLogOut.show(stage);
  
    yes.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent t){
                confirmLogOut.hide();
  Stage stage=(Stage) confirmLogOut.getOwnerWindow();
  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/Login.fxml"));  
  try
  {Parent root = (Parent)fxmlLoader.load();     
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  }
  catch(IOException e){}
            }
        });
     no.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent t){
                confirmLogOut.hide();
                  }});
    }*/
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file ";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file ";
        // initialize your logic here: all @FXML variables will have been injected

    }
       
    
    /**
     * @return the ModelController
     */
    public ModelController getModelController() {
        return modelController;
    }

    /**
     * @param modelController the ModelController to set
     */
    public void setModelController(ModelController modelController) {
        this.modelController = modelController;
    }
    //show element with Metro style animation
    @Override
    public void handleOnShowAnimation(Node node, int millis, double offset){
        //fade in
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(millis), node);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        //Scale in
        /*
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(millis / 2), node);
        scaleTransition.setFromX(0.9);
        scaleTransition.setToX(1.0);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(false);
        */ 
        //transition in
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(millis), node);
        translateTransition.setFromX(offset);
        translateTransition.setToX(0.0);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        //parallel animation
        ParallelTransition parallelTransition = new ParallelTransition(node, fadeTransition, translateTransition);
        parallelTransition.play();
    }
    //overloading the above function. Provide a default animation
    public void handleOnShowAnimation(Node node){
        handleOnShowAnimation(node, 1000, 10.0);
    }
    
    //apply fade animation
    @Override
    public void handleNodeFadeTransition(Node node, int millis, double fromValue, double toValue){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(millis), node);
        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);
        fadeTransition.play();
    }
   
    //overloading handleNodeFadeTransistion with default from value and to value
    @Override
    public void handleNodeFadeTransition(Node node, int millis){
        handleNodeFadeTransition(node, millis, 0.0, 1.0);
    }
   
    //apply scale transition to a node element
    @Override
    public void handleNodeScaleTransition (Node node, int millis, double fromValue, double toValue ){        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(millis), node);
        scaleTransition.setFromX(fromValue);
        scaleTransition.setToX(toValue);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(false);
        scaleTransition.play();
    }
    //overloading handleNodeScaleTransition with default from value and to value
     public void handleNodeScaleTransition (Node node, int millis){
         handleNodeScaleTransition(node, millis, 0.0, 0.1);
     }
     
     public FXMLLoader transitPane(String resourceURL, Pane placeHolderPane, ModelController modelController){
        try{      
            //load the FXML file
            FXMLLoader fxmlLoader = generateFXMLLoader( ModelController.FXML_PATH + resourceURL);
            Node content = loadFXML(fxmlLoader);
            //remove all existing children on the place holder
            placeHolderPane.getChildren().clear();
            //add this pane into placeholder
            placeHolderPane.getChildren().add(content);
            BaseFXController FXController = fxmlLoader.<BaseFXController>getController();
            FXController.setInitialData(modelController);            
            /*
            if(modelController!=null)
            {FXController.setModelController(modelController);
            }
            else
            {System.out.println("No modelController");
            }
            */ 
            FXController.playOnShowAnimation();     
            return fxmlLoader;
        }
       catch(IOException e){
           System.out.println("ERROR: " + resourceURL + " not found!!");
           return null;
       }
    }
     
    //tansit to another scene where ModelController is needed
    public void transitScene(String resourceURL, Node node, ModelController modelController){
        Stage stage=(Stage) node.getScene().getWindow();
        try{      
            FXMLLoader fxmlLoader = generateFXMLLoader( ModelController.FXML_PATH + resourceURL);
            Parent root = loadFXML(fxmlLoader);
            BaseFXController FXController = fxmlLoader.<BaseFXController>getController();
            FXController.setModelController(modelController);
            FXController.setInitialData(modelController);    
            initialStage (stage, root);
            FXController.playOnShowAnimation();   
        }
        catch(IOException e){
           System.out.println("ERROR: " + resourceURL + " not found!!");
        }
    }
    
    //tansit to another scene where ModelController is NOT needed
    public void transitScene(String resourceURL, Node node){
        Stage stage=(Stage) node.getScene().getWindow();
        try{      
            FXMLLoader fxmlLoader = generateFXMLLoader( ModelController.FXML_PATH + resourceURL);
            Parent root = loadFXML(fxmlLoader);
            BaseFXController FXController = fxmlLoader.<BaseFXController>getController();
            initialStage (stage, root);
            FXController.playOnShowAnimation();
        }
       catch(IOException e){
           System.out.println("ERROR: " + resourceURL + " not found!!");
       }
    }
    
    protected Parent loadFXML(FXMLLoader fxmlLoader) throws IOException{     
        Parent root = (Parent)fxmlLoader.load(); 
        return root;
    }
    
    protected FXMLLoader generateFXMLLoader(String resourceURL){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resourceURL)); 
        return fxmlLoader;
    }     
    
    protected void initialStage (Stage stage, Parent root){
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();        
    }
    protected void enableAll()
    {
        setChanged();
        notifyObservers(false);
        
    }
    protected void disableAll()
    {
        setChanged();
        notifyObservers(true);
    }
    public abstract void setInitialData( ModelController modelController);
    
    @Override
    public abstract void playOnShowAnimation(); 
}
