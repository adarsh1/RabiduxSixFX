/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package searchbook;

import cataloguemanagement.ReservableCopyGroup;
import globalcontroller.MainController;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import memberpage.MemberFXController;
import usermanagement.Member;

public class SearchFXController extends MemberFXController implements Initializable{
    
    private String tempT;
    private String tempC;
    private String tempISBN;
    private String tempAuthor;
    
    private SearchMgr searchMgr;
  
 
     @FXML //  fx:id="byAuthor"
    private RadioButton byAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="byGenre"
    private RadioButton byGenre; // Value injected by FXMLLoader

    @FXML //  fx:id="byISBN"
    private RadioButton byISBN; // Value injected by FXMLLoader

    @FXML //  fx:id="byTitle"
    private RadioButton byTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="keywordField"
    private TextField keywordField; // Value injected by FXMLLoader

    @FXML //  fx:id="scrollPane"
    private ScrollPane scrollPane; // Value injected by FXMLLoader

    @FXML //  fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML //  fx:id="vb"
    private VBox vb; // Value injected by FXMLLoader



    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert byAuthor != null : "fx:id=\"byAuthor\" was not injected: check your FXML file 'Search.fxml'.";
        assert byGenre != null : "fx:id=\"byGenre\" was not injected: check your FXML file 'Search.fxml'.";
        assert byISBN != null : "fx:id=\"byISBN\" was not injected: check your FXML file 'Search.fxml'.";
        assert byTitle != null : "fx:id=\"byTitle\" was not injected: check your FXML file 'Search.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'Search.fxml'.";
        assert keywordField != null : "fx:id=\"keywordField\" was not injected: check your FXML file 'Search.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'Search.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'Search.fxml'.";
        assert vb != null : "fx:id=\"vb\" was not injected: check your FXML file 'Search.fxml'.";

        // initialize your logic here: all @FXML variables will have been injecte       
        searchMgr = new SearchMgr();
    }
    
    
    @Override
    public void setMainController (MainController mainController){
        super.setMainController(mainController);
        //set the current member to borrow
        searchMgr.setCurrentMember((Member)mainController.getUser());
    }
    
    
    // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void handlesearchbutton(ActionEvent event)throws IOException{
      // Search manager searches for books here..... if found then display
      scrollPane.setVisible(true);
      vb.setVisible(true);
      scrollPane.setContent(vb);
      vb.setSpacing(20);
      int i;

            for(i=0;i<50;i++)
            {  Pane p=new Pane();
                  createIndividual(p,i);
                vb.getChildren().add(p);
            }

          /* CODE TO GET SEARCH RESULTS FROM DATABASE AND PUT IN PANES
          try{
          if(byTitle.isSelected())
          searchMgr.SearchByTitle(keywordField.getText());
          else if(byAuthor.isSelected())
          searchMgr.SearchByAuthor(keywordField.getText());
          else if(byISBN.isSelected())
          searchMgr.SearchByISBN(keywordField.getText());
          else
          searchMgr.SearchByGenre(keywordField.getText());
          } catch those exceptions
          for(i=0;i<searchMgr.getItemGroup().size();i++)
          {Pane p=new Pane();
           createIndividual(p,i,searchMgr.getItemGroup().get(i));
           vb.getChildren().add(p);
          }
          */
    }
 
 
    private void createIndividual(Pane p,int i) {
        p.setId(""+i);
        p.getStyleClass().add("individual");
        p.setMinSize(295, 98);
        ImageView img=new ImageView(new Image(SearchFXController.class.getResourceAsStream("/resources/images/default_book_cover.jpg")));
        img.setFitHeight(80);
        img.setFitWidth(60);
        img.setLayoutX(228);
        img.setLayoutY(8);
        img.setPreserveRatio(true);
        Text t = new Text(14, 50, "Title Of Book 2nd Edition Champak Publishing");
        
        t.setWrappingWidth(210);
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
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/IndividualViewGUI.fxml"));
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
        catch(IOException ei){
            System.out.println("ERROR:IndividualViewGUI.fxml not found!!");
        }
            }
        });
    }
    
     private void createIndividual(Pane p,int i, ReservableCopyGroup item) {
        p.setId(""+i);
        p.getStyleClass().add("individual");
        p.setMinSize(295, 98);
        ImageView img=new ImageView(new Image(SearchFXController.class.getResourceAsStream("/resources/images/default_book_cover.jpg")));
        img.setFitHeight(80);
        img.setFitWidth(60);
        img.setLayoutX(228);
        img.setLayoutY(8);
        img.setPreserveRatio(true);
        Text t = new Text(14, 50, item.getItemTitle());
        
        t.setWrappingWidth(210);
        t.setTextOrigin(VPos.CENTER);
        t.setTextAlignment(TextAlignment.CENTER);
        p.getChildren().addAll(t,img);
        tempT=t.getText();
        tempISBN=item.getISBN();
        tempAuthor=item.getItemAuthor();
        tempC="images/default_book_cover.jpg";
        p.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                Node node=(Node) e.getSource();
                
                int i=Integer.parseInt(node.getId());
                Stage stage=(Stage) node.getScene().getWindow();
                
                try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/xml/IndividualViewGUI.fxml"));
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
        catch(IOException ei){
            System.out.println("ERROR:IndividualViewGUI.fxml not found!!");
        }
            }
        });
    }
    
    
    
    
    
    
    
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane, 500, 30.0);
    }
}
