/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package lms;

import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SearchController extends MemberGUI implements Initializable{
  
 
 @FXML //  fx:id="scrollpane"
    private ScrollPane scrollpane; // Value injected by FXMLLoader   
 
 @FXML //  fx:id="skeyword"
    private VBox vb; // Value injected by FXMLLoader  
 
 @FXML //  fx:id="skeyword"
    private RadioButton skeyword; // Value injected by FXMLLoader  
 
 @FXML //  fx:id="stitle"
    private RadioButton stitle; // Value injected by FXMLLoader   
 
 @FXML //  fx:id="sauthor"
    private RadioButton sauthor; // Value injected by FXMLLoader      
 
 @FXML //  fx:id="sisbn"
    private RadioButton sisbn; // Value injected by FXMLLoader      
    
 private String tempT;
 private String tempC;
 private String tempISBN;
 private String tempAuthor;
 // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void searchbook(ActionEvent event)throws IOException{
      scrollpane.setVisible(true);
      vb.setVisible(true);
      scrollpane.setContent(vb);
      vb.setSpacing(20);
      int i;
      for(i=0;i<50;i++)
      {  Pane p=new Pane();
            createIndividual(p,i);
          vb.getChildren().add(p);
      }
      
    }
 
 
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
       assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Welcome.fxml'.";
         assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Welcome.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected

    }

    private void createIndividual(Pane p,int i) {
        p.setId(""+i);
        p.getStyleClass().add("individual");
        p.setMinSize(295, 98);
        ImageView img=new ImageView(new Image(SearchController.class.getResourceAsStream("images/default_book_cover.jpg")));
        img.setFitHeight(80);
        img.setFitWidth(60);
        img.setLayoutX(228);
        img.setLayoutY(8);
        img.setPreserveRatio(true);
        Text t = new Text(14, 50, "Title Of Book 2nd Edition Champak Publishing");
        
        t.setWrappingWidth(210);
       /*Text dis=new Text(9,48,"Text Description, take limited characters add ...");
        dis.setFont(Font.font("System", FontWeight.THIN, 12));
        dis.setWrappingWidth(215);*/
        t.setTextOrigin(VPos.CENTER);
        t.setTextAlignment(TextAlignment.CENTER);
         p.getChildren().addAll(t,img);
         tempT=t.getText();
         tempISBN="1111111111";
         tempAuthor="Charles Dickens";
         tempC="images/default_book_cover.jpg";
          p.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                Node node=(Node) e.getSource();
                
                int i=Integer.parseInt(node.getId());
                Stage stage=(Stage) node.getScene().getWindow();
                
                try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IndividualViewGUI.fxml"));
                Parent root = (Parent)fxmlLoader.load();          
                IndividualViewGUIController controller = fxmlLoader.<IndividualViewGUIController>getController();
                controller.setTitle(tempT);
                controller.setImage(tempC);
                controller.setAuthor(tempAuthor);
                controller.setIsbn(tempISBN);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                }
        catch(IOException ei){;}
            }
        });
    }
   }
