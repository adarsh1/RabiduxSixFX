
package login;

import baseGUI.BaseGUIController;
import exception.UserNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import usermanagement.Librarian;

public class LoginFXController extends BaseGUIController implements Initializable {

    @FXML //  fx:id="warningMsgField"
    private Label warningMsgField; // Value injected by FXMLLoader

    @FXML //  fx:id="password"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML //  fx:id="userIDField"
    private TextField userIDField; // Value injected by FXMLLoader
    
    @FXML //  fx:id="quit"
    private ImageView quit; // Value injected by FXMLLoader
      
    private LoginMgr loginMgr;
    
    public LoginFXController(){
        loginMgr = new LoginMgr(); 
        setMC(loginMgr.getMC());
    }
    
    // Handler enter key pressed
    public void handleEnterKeyPressed(KeyEvent event) {
        //if enter key pressed and input field not null
        if (event.getCode() == KeyCode.ENTER && !userIDField.getText().equals("")) {
            Node node=(Node) event.getSource();
            String userID = userIDField.getText();
            //call login function to process login
            login(node, userID);
        }
    }
    // Handler for Button login [Button[id=null, styleClass=button]] onAction
    public void handleLoginButtonAction(ActionEvent event){    
        //if button pressed and input field not null
        if(!userIDField.getText().equals("")){
            Node node=(Node) event.getSource();
            String userID = userIDField.getText();
            //call login function to process login
            login(node, userID);
        }
    }
    
    public void login(Node node, String userID){
        try{
            loginMgr.createUser(userID);
            if (loginMgr.getUser() instanceof Librarian){
                //if the user is a member, go to librarian GUI
                goWelcomeLibrarian(node); 
            }
            else{
                //else go to member GUI
                goWelcomeMember(node);                 
            }                
        }
        catch(UserNotFoundException e){
            //if user not found, raise this exception
            warningMsgField.setText(e.getMessage());
        }
        catch(SQLException e) {
            warningMsgField.setText(e.getMessage());
        }
        catch(ClassNotFoundException e) {
            warningMsgField.setText(e.getMessage());
        }
        
    }
    // Handler for ImageView[fx:id="quit"] onMouseClicked
    public void quit(MouseEvent event) {
        System.exit(0);
    }

   @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert warningMsgField != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordField != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert userIDField != null : "fx:id=\"userIDField\" was not injected: check your FXML file 'Login.fxml'.";
        assert quit != null : "fx:id=\"quit\" was not injected: check your FXML file 'Login.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected
    }

    private void goWelcomeMember(Node node){
        transitScene("/resources/xml/WelcomeMember.fxml",node);      
    }
    
    private void goWelcomeLibrarian(Node node){
        transitScene("/resources/xml/WelcomeLibrarian.fxml",node);
    }

}