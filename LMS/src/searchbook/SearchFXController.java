/**
 *
 * @author Adarsh
 */

package searchbook;

import baseGUI.BaseFXController;
import cataloguemanagement.ReservableCopyGroup;
import globalcontroller.MainController;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import usermanagement.Member;

public class SearchFXController extends MemberFXController implements Initializable{
    
    private SearchMgr searchMgr;
  
  @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup SearchOption;

    @FXML
    private RadioButton byAuthor;

    @FXML
    private RadioButton byGenre;

    @FXML
    private RadioButton byISBN;

    @FXML
    private RadioButton byTitle;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private TextField keywordField;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button searchButton;

    @FXML
    private VBox vb;

    
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
        try{
        if(byTitle.isSelected())
          searchMgr.SearchByTitle(keywordField.getText());
        else if(byAuthor.isSelected())
          searchMgr.SearchByAuthor(keywordField.getText());
        else if(byISBN.isSelected())
          searchMgr.SearchByISBN(keywordField.getText());
        else
          searchMgr.SearchByGenre(keywordField.getText());
          } 
        catch(SQLException e){;}
        catch(ClassNotFoundException e){;}
        
        initializeScrollPane();
    }
 
 
    private void createIndividual(Pane p,ReservableCopyGroup item) {
        p.setId(""+item.getItemID());
        p.getStyleClass().add("searchResult");
        p.setMinSize(480, 124);
        
       
        ImageView bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream("/resources/images/bookcover/"+item.getItemID()+".jpg")));
        bookCover.setFitWidth(80);
        bookCover.setLayoutX(7);
        bookCover.setLayoutY(7);
        bookCover.setPreserveRatio(true);
        
        Label indTitle = new Label(item.getItemTitle());
        indTitle.setPrefWidth(360);
        indTitle.getStyleClass().add("header-5");
        indTitle.setLayoutX(103);
        indTitle.setLayoutY(9);
        indTitle.setEllipsisString("...");
        
        Label indAuthor = new Label("Author: "+item.getItemAuthor());
        indAuthor.setPrefWidth(355);
        indAuthor.setLayoutX(117);
        indAuthor.setLayoutY(44);
        indAuthor.setEllipsisString("...");
        
        Label indGenre = new Label("Genre: "+"Education");
        indGenre.setPrefWidth(355);
        indGenre.setLayoutX(117);
        indGenre.setLayoutY(69);
        indGenre.setEllipsisString("...");
        
        Label indCopies = new Label("Copies: "+item.getCopiesAvailable());
        indCopies.setPrefWidth(129);
        indCopies.setLayoutX(117);
        indCopies.setLayoutY(94);
        indCopies.setEllipsisString("");
        
        p.getChildren().addAll(bookCover,indTitle,indAuthor,indGenre,indCopies);

        p.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                Node node=(Node) e.getSource();
                
                String id=node.getId();
                
            }
        });
    }
    
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane, 500, 30.0);
    }

    private void initializeScrollPane() {
        scrollPane.setVisible(true);
        scrollPane.setContent(vb);
        vb.getChildren().clear();
        vb.setSpacing(20);
        int i;
        for(i=0;i<searchMgr.getNoOfResults();i++)
        {  Pane p=new Pane();
                  createIndividual(p,searchMgr.getItemGroup().get(i));
                vb.getChildren().add(p);
                handleNodeScaleTransition(p, 400,0,1);
         }
    }
}
