
package login;

import baseGUI.BaseFXController;
import memberpage.MemberFXController;
import exception.IncorrectPasswordException;
import exception.UserNotFoundException;
import globalcontroller.MainController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import usermanagement.Librarian;

public class LoginFXController extends BaseFXController implements Initializable {

    @FXML //  fx:id="warningMsgField"
    private Label warningMsgField; // Value injected by FXMLLoader

    @FXML //  fx:id="password"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML //  fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader
    
    @FXML //  fx:id="quit"
    private ImageView quit; // Value injected by FXMLLoader
    
    @FXML //  fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader
    
    @FXML //  fx:id="rootPane"
    private Pane rootPane; // Value injected by FXMLLoader
      
    private LoginMgr loginMgr;
    private int currentFieldState;
    private int previousFieldState;
    
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    
    public LoginFXController(){
        loginMgr = new LoginMgr(); 
        setMC(loginMgr.getMC());
        currentFieldState = DISABLED;
        previousFieldState = DISABLED;
    }
    
    
    //enable the login once user has entered username and password
    public void handleOnKeyTyped(KeyEvent event){   
        updateFieldState();
        //handle Enterkey pressed
        if (event.getCode() == KeyCode.ENTER) {
            if (currentFieldState == ENABLED){
                Node node=(Node) event.getSource();            
                //call login function to process login
                login(node);
            }
        }
        else{
            updateLoginButton();
        }
    }
    //handle on key released action
    public void handleOnKeyReleased(KeyEvent event){
        //update field state and login button
        updateFieldState();
        updateLoginButton();
    }
    
    //update login button based on the state of the fields
    public void updateLoginButton(){
        //if input field is empty, disable login button
        if (currentFieldState == DISABLED){
            loginButton.setDisable(true);
        }
        else if(currentFieldState == ENABLED && previousFieldState == DISABLED){
            loginButton.setDisable(false);
            handleNodeFadeTransition(loginButton, 500, 0.5 ,1.0);
        }
    }
    
    // Handler for Button login [Button[id=null, styleClass=button]] onAction
    public void handleLoginButtonAction(ActionEvent event){    
        //if button pressed and input field not null
        if(currentFieldState == ENABLED){
            Node node=(Node) event.getSource();
            //call login function to process login
            login(node);
        }
    }
    
    public void login(Node node){
        String userID = usernameField.getText();
        String password = passwordField.getText();
        try{
            loginMgr.createUser(userID, password);        
            if (loginMgr.getUser() instanceof Librarian){
                //if the user is a member, go to librarian GUI
                goWelcomeLibrarian(node); 
            }
            else{
                //else go to member GUI
                gotoMemberPage(node);                 
            }                
        }
        catch(UserNotFoundException | IncorrectPasswordException | SQLException | ClassNotFoundException e){
            //if user not found, raise this exception
            warningMsgField.setText(e.getMessage());
        }
        
    }
    
   @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert warningMsgField != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordField != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'Login.fxml'.";
        assert quit != null : "fx:id=\"quit\" was not injected: check your FXML file 'Login.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected
    }   
   
    private void updateFieldState(){
        previousFieldState = currentFieldState;
        String inputText = usernameField.getText();
        String inputPassword = passwordField.getText();
        //user needs to input both username and password to enable the button
        if ( (inputText.length() > 0) && (inputPassword.length() > 0)){            
            currentFieldState = ENABLED;
        }
        else{
            currentFieldState = DISABLED;
        }
    }

    private void gotoMemberPage(Node node){
        transitScene("/resources/xml/MemberPage.fxml",node);      
        BaseFXController.handleOnShowAnimation(node, ENABLED, ENABLED);
    }
    
    private void goWelcomeLibrarian(Node node){
        transitScene("/resources/xml/WelcomeLibrarian.fxml",node);
    }
    
    public void transitScene(String resourceURL, Node node){
        Stage stage=(Stage) node.getScene().getWindow();
        try{      
            FXMLLoader fxmlLoader = generateFXMLLoader(resourceURL);
            Parent root = loadFXML(fxmlLoader);
            MemberFXController memberFXController = fxmlLoader.<MemberFXController>getController();
            passMC(memberFXController);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            //animation for GUI on shown
            BaseFXController.handleOnShowAnimation(memberFXController.getMenuPane(), 500, 50);
            BaseFXController.handleOnShowAnimation(memberFXController.getContentPane(), 500, 50);
            BaseFXController.handleOnShowAnimation(memberFXController.getHelpPane(), 500, 50);
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
    
    protected void passMC (BaseFXController FXController){
        MainController MC = getMC();
        FXController.setMC(MC);            
    }

}