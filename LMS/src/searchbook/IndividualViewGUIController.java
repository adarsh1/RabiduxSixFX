/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import baseGUI.MemberFXController;

/**
 * FXML Controller class
 *
 * @author Adarsh
 */
public class IndividualViewGUIController extends MemberFXController implements Initializable {

   
    @FXML //  fx:id="author"
    private Text author; // Value injected by FXMLLoader

    @FXML //  fx:id="cover"
    private ImageView cover; // Value injected by FXMLLoader

    @FXML //  fx:id="isbn"
    private Text isbn; // Value injected by FXMLLoader

    @FXML //  fx:id="title"
    private Text title; // Value injected by FXMLLoader


   

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'IndividualViewGUI.fxml'.";
        assert cover != null : "fx:id=\"cover\" was not injected: check your FXML file 'IndividualViewGUI.fxml'.";
        assert isbn != null : "fx:id=\"isbn\" was not injected: check your FXML file 'IndividualViewGUI.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'IndividualViewGUI.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'IndividualViewGUI.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }
public void setIsbn(String ISBN){
    isbn.setText("ISBN:"+ISBN);
}
public void setAuthor(String a){
    author.setText("Author:"+a);
}
public void setTitle(String t){
    title.setText(t);
}
public void setImage(String url){
    try
    { cover.setImage(new Image(SearchController.class.getResourceAsStream(url)));
    }
    catch(Exception e){
        cover.setImage(new Image(SearchController.class.getResourceAsStream("/resources/images/default_book_cover.jpg")));
    }
    }
}