/**
 * Sample Skeleton for "Sample.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package lms;

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

public class LoginController
    implements Initializable {

    @FXML //  fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML //  fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML //  fx:id="usrname"
    private TextField usrname; // Value injected by FXMLLoader
    
    @FXML //  fx:id="quit"
    private ImageView quit; // Value injected by FXMLLoader
// Handler for Button[Button[id=null, styleClass=button]] onKeyPressed
    public void enter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
          Node node=(Node) event.getSource();
          goWelcome(node);}
    }
    // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void login(ActionEvent event){
        Node node=(Node) event.getSource();
        goWelcome(node);     

    }
    // Handler for ImageView[fx:id="quit"] onMouseClicked
    public void quit(MouseEvent event) {
        System.exit(0);
    }

   @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert usrname != null : "fx:id=\"usrname\" was not injected: check your FXML file 'Login.fxml'.";
        assert quit != null : "fx:id=\"quit\" was not injected: check your FXML file 'Login.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected

    }

    private void goWelcome(Node node){
        Stage stage=(Stage) node.getScene().getWindow();
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = (Parent)fxmlLoader.load();          
      WelcomeController controller = fxmlLoader.<WelcomeController>getController();
      controller.setText(usrname.getText());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException e){;}
      
    }

}