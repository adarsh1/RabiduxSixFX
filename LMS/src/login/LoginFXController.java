
package login;

import baseGUI.BaseGUIController;
import exception.IncorrectPasswordException;
import exception.UserNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import usermanagement.Librarian;

public class LoginFXController extends BaseGUIController implements Initializable {

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
      
    private LoginMgr loginMgr;
    private int currentFieldState = DISABLED;
    private int previousFieldState = DISABLED;
    
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    
    public LoginFXController(){
        loginMgr = new LoginMgr(); 
        setMC(loginMgr.getMC());
    }
    
    
    //enable the login once user has entered username and password
    public void enableLogin(KeyEvent event){   
        updateFieldState();
        //handle enterkey pressed
        if (event.getCode() == KeyCode.ENTER) {
            if (currentFieldState == ENABLED){
                Node node=(Node) event.getSource();            
                //call login function to process login
                login(node);
            }
        }
        else{
            enableLoginButton(event);
        }
    }
    
    public void enableLoginButton(KeyEvent event){
        //if input field is empty, disable login button
        if (currentFieldState == DISABLED){
            disableLoginButton();
        }
        else if(currentFieldState == ENABLED && previousFieldState == DISABLED){
            loginButton.setDisable(false);
            handleNodeFade(loginButton, 500, 0, 0.5 ,1.0);
        }
    }
    
    public void disableLoginButton(){
        loginButton.setDisable(true);
    }
    
    // Handler for Button login [Button[id=null, styleClass=button]] onAction
    public void handleLoginButtonAction(ActionEvent event){    
        //if button pressed and input field not null
        if(!usernameField.getText().equals("")){
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
                goWelcomeMember(node);                 
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
   
   public void handleNodeFade(Node node, int millis, int mode){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(millis), node);
        if (mode==0){   //fade in
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
        }
        if (mode==1){   //fade out
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(2.0);
        }        
        fadeTransition.play();
    }
   //overloading handleNodeFade with from value and to value
   public void handleNodeFade(Node node, int millis, int mode, double fromValue, double toValue){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(millis), node);
        if (mode==0){   //fade in
            fadeTransition.setFromValue(fromValue);
            fadeTransition.setToValue(toValue);
        }
        if (mode==1){   //fade out
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(2.0);
        }        
        fadeTransition.play();
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

    private void goWelcomeMember(Node node){
        transitScene("/resources/xml/WelcomeMember.fxml",node);      
    }
    
    private void goWelcomeLibrarian(Node node){
        transitScene("/resources/xml/WelcomeLibrarian.fxml",node);
    }

}