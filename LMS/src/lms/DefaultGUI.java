/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package lms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;


public abstract class DefaultGUI
    implements Initializable {

    @FXML //  fx:id="logout"
    protected ImageView logout; // Value injected by FXMLLoader

    @FXML //  fx:id="name"
    protected Text name; // Value injected by FXMLLoader
    
    
    public void logout(MouseEvent event) {
        
   final Popup confirmLogOut = new Popup();


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
    popUpVBox.setStyle("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.55) , 5, 1, 0 , 1 );-fx-background-color: radial-gradient(focus-angle 0deg , focus-distance 0% , center 50% 50% , radius 50% , #00bfff, #000080);;-fx-stroke: black;-fx-stroke-width: 5;");
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
  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));  
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
    }
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file ";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file ";

        // initialize your logic here: all @FXML variables will have been injected

    }
    public void setText(String string) {
        name.setText(string); //To change body of generated methods, choose Tools | Templates.
    }

}
