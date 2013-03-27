
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lms.WelcomeLibrarianController;
import lms.WelcomeMemberController;

public class LoginFXController
    implements Initializable {

    @FXML //  fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML //  fx:id="password"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML //  fx:id="userID"
    private TextField userID; // Value injected by FXMLLoader
    
    @FXML //  fx:id="quit"
    private ImageView quit; // Value injected by FXMLLoader
    
    // Handler for Button[Button[id=null, styleClass=button]] onKeyPressed
    public void enter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
          Node node=(Node) event.getSource();
          if(!userID.getText().equals("")&&userID.getText().charAt(0)=='1')
            goWelcomeMember(node);     
        else
            goWelcomeLibrarian(node); }
    }
    // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void login(ActionEvent event){
        Node node=(Node) event.getSource();
        if(!userID.getText().equals("")&&userID.getText().charAt(0)=='1')
            goWelcomeMember(node);     
        else
            goWelcomeLibrarian(node); 
    }
    // Handler for ImageView[fx:id="quit"] onMouseClicked
    public void quit(MouseEvent event) {
        System.exit(0);
    }

   @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordField != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert userID != null : "fx:id=\"userID\" was not injected: check your FXML file 'Login.fxml'.";
        assert quit != null : "fx:id=\"quit\" was not injected: check your FXML file 'Login.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected

    }

    private void goWelcomeMember(Node node){
        Stage stage=(Stage) node.getScene().getWindow();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/WelcomeMember.fxml"));
            Parent root = (Parent)fxmlLoader.load();          
            WelcomeMemberController controller = fxmlLoader.<WelcomeMemberController>getController();
            controller.setText(userID.getText());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
          System.out.println("ERROR:WelcomeMember.fxml not found!!");
        }
      
    }
    
    private void goWelcomeLibrarian(Node node){
        Stage stage=(Stage) node.getScene().getWindow();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/WelcomeLibrarian.fxml"));
            Parent root = (Parent)fxmlLoader.load();          
            WelcomeLibrarianController controller = fxmlLoader.<WelcomeLibrarianController>getController();
            controller.setText(userID.getText());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
          System.out.println("ERROR:WelcomeLibrarian.fxml not found!!");
        }
      
    }

}