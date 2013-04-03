/**
 * Sample Skeleton for "Welcome.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package history;

import baseGUI.BaseFXController;
import cataloguemanagement.ReservableCopyGroup;
import globalcontroller.MainController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import searchbook.IndividualViewGUIController;
import searchbook.SearchFXController;
import usermanagement.Member;


public class HistoryFXController extends BaseFXController implements Initializable{
    
    private HistoryMgr historyMgr;
    
    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="itemPane"
    private VBox itemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="scrollPane"
    private ScrollPane scrollPane; // Value injected by FXMLLoader
    
   @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'History.fxml'.";
        assert itemPane != null : "fx:id=\"itemPane\" was not injected: check your FXML file 'History.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'History.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected
        historyMgr = new HistoryMgr();
        displayHistory();
        
    }
   
   
   private void displayHistory()
   {
       //historyMgr.getHistoryTransactionItems(); 
       initializeScrollPane();
   }
   
   private void initializeScrollPane() {
        scrollPane.setVisible(true);
        scrollPane.setContent(itemPane);
        itemPane.getChildren().clear();
        itemPane.setSpacing(20);
        int i;
        //for(i=0;i<searchMgr.getNoOfResults();i++)
        for(i=0;i<5;i++)
        {       Pane p=new Pane();
                  //createIndividual(p,searchMgr.getItemGroup().get(i));
                createIndividual(p);
                itemPane.getChildren().add(p);
                handleNodeScaleTransition(p, 400,0,1);
         }
    }
   
   //private void createIndividual(Pane p,ReservableCopyGroup item) {
   private void createIndividual(Pane p) {
        p.setId("x");
        p.getStyleClass().add("historyResult");
        p.setMinSize(480, 125);
        ImageView bookCover;
       try
       {bookCover=new ImageView(new Image(HistoryFXController.class.getResourceAsStream(MainController.BOOKCOVER_IMAGE_PATH + "2000000001" +".jpg")));
       }
       catch(Exception e)
       {
        bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream( MainController.BOOKCOVER_IMAGE_PATH + "default_book_cover.jpg")));
       }
        bookCover.setFitWidth(80);
        bookCover.setFitHeight(111);
        bookCover.setLayoutX(7);
        bookCover.setLayoutY(7);
        //bookCover.setPreserveRatio(true);
        
        //Label indTitle = new Label(item.getItemTitle());
        Label indTitle = new Label("Test");
        indTitle.setPrefWidth(360);
        indTitle.getStyleClass().add("header-5");
        indTitle.setLayoutX(103);
        indTitle.setLayoutY(9);
        indTitle.setEllipsisString("...");
        indTitle.setTooltip(new Tooltip(indTitle.getText()));
        
        //Label indAuthor = new Label("Author: "+item.getItemAuthor());
        Label indAuthor = new Label("Author: Test");
        indAuthor.setPrefWidth(355);
        indAuthor.setLayoutX(117);
        indAuthor.setLayoutY(39);
        indAuthor.setEllipsisString("...");
        
        //Label indGenre = new Label("Genre: "+"Education");
        Label indGenre = new Label("Genre: "+"Education");
        indGenre.setPrefWidth(355);
        indGenre.setLayoutX(117);
        indGenre.setLayoutY(57);
        indGenre.setEllipsisString("...");
        
        //Label indBorrowDate = new Label("Copies: "+item.getCopiesAvailable());
        Label indBorrowDate = new Label("Borrow Date: "+"xx-xx-xxxx");
        indBorrowDate.setPrefWidth(129);
        indBorrowDate.setLayoutX(117);
        indBorrowDate.setLayoutY(75);
        indBorrowDate.setEllipsisString("");
        
        //Label indCopies = new Label("Copies: "+item.getCopiesAvailable());
        Label indReturnDate = new Label("Return Date: "+"xx-xx-xxxx");
        indReturnDate.setPrefWidth(129);
        indReturnDate.setLayoutX(117);
        indReturnDate.setLayoutY(93);
        indReturnDate.setEllipsisString("");
        
        p.getChildren().addAll(bookCover,indTitle,indAuthor,indGenre,indBorrowDate,indReturnDate);
        
    }
   
   
    @Override
    public void setMainController(MainController mainController) {
        super.setMainController(mainController); 
        //set the current member
        historyMgr.setCurrentMember((Member)mainController.getUser());
    }

    @Override
    public void playOnShowAnimation() {
        this.handleOnShowAnimation(contentPane);
    }
    
}
