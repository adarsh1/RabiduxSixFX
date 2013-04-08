/**
 * Sample Skeleton for "Holdings.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package Holdings;

import baseGUI.BaseFXController;
import exception.TypeMismatchException;
import globalcontrol.ModelController;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import searchbook.IndividualViewGUIMgr;
import searchbook.SearchFXController;
import usermanagement.Member;


public class HoldingsFXController extends BaseFXController implements Initializable {

    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox borrowVB;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private VBox reserveVB;
    
    private HoldingsMgr holdingsMgr;

    @FXML
    void extendButtonAction(ActionEvent event) {
    }

    @FXML
    void itemDetailsButtonaction(ActionEvent event) {
    }

    @FXML
    void reserveCancelButtonaction(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert borrowVB != null : "fx:id=\"borrowVB\" was not injected: check your FXML file 'Holdings.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'Holdings.fxml'.";
        assert reserveVB != null : "fx:id=\"reserveVB\" was not injected: check your FXML file 'Holdings.fxml'.";


    }

private void initializeBorrowScrollPane() {
        borrowVB.getChildren().clear();
        int i;
        for(i=0;i<holdingsMgr.getNoOfCurrentHoldings();i++)
        {  Pane p=new Pane();
                  createHoldingIndividual(p,i);
                borrowVB.getChildren().add(p);
                handleNodeScaleTransition(p, 400,0,1);
         }
    }
 private void createHoldingIndividual(Pane p,int index) {
        p.setId(""+index);
        p.getStyleClass().add("borrow-holding");
        p.setMinSize(460, 64);
        ImageView bookCover;
       try
       {bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream(ModelController.BOOKCOVER_IMAGE_PATH + holdingsMgr.getCurrentHoldings().get(index).getCopy().getItemID()+".jpg")));
       }
       catch(Exception e)
       {
        bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + "default_book_cover.jpg")));
       }
        bookCover.setFitWidth(75);
        bookCover.setLayoutX(5);
        bookCover.setLayoutY(0);
        bookCover.setPreserveRatio(true);
        
        Label indTitle = new Label(holdingsMgr.getCurrentHoldings().get(index).getCopy().getTitle());
        indTitle.setPrefWidth(360);
        indTitle.getStyleClass().add("header-5");
        indTitle.setLayoutX(103);
        indTitle.setLayoutY(9);
        indTitle.setEllipsisString("...");
        indTitle.setTooltip(new Tooltip(indTitle.getText()));
        
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);
        
        Label indBorrowDate = new Label("Borrowed On: "+format.format(holdingsMgr.getCurrentHoldings().get(index).getDateBorrowed()));
        indBorrowDate.setLayoutX(51);
        indBorrowDate.setLayoutY(28);
        
        Label indReturnDate = new Label("Return By: "+format.format(holdingsMgr.getCurrentHoldings().get(index).getDateToReturn()));
        indReturnDate.setLayoutX(70);
        indReturnDate.setLayoutY(42);
        
        Button extendButton=new Button("Extend");
        extendButton.setLayoutX(205);
        extendButton.setLayoutY(30);
        
        p.getChildren().addAll(bookCover,indTitle,indBorrowDate,indReturnDate,extendButton);
    }
 
 private void initializeReserveScrollPane() {
        reserveVB.getChildren().clear();
        int i;
        for(i=0;i<holdingsMgr.getNoOfReservedCopies();i++)
        {  Pane p=new Pane();
                  createReservedIndividual(p,i);
                reserveVB.getChildren().add(p);
                handleNodeScaleTransition(p, 400,0,1);
         }
    }
 private void createReservedIndividual(Pane p,int index) {
        p.setId(""+index);
        p.getStyleClass().add("borrow-holding");
        p.setMinSize(460, 64);
        ImageView bookCover;
       try
       {bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream(ModelController.BOOKCOVER_IMAGE_PATH + holdingsMgr.getReservedCopies().get(index).getCopy().getItemID()+".jpg")));
       }
       catch(Exception e)
       {
        bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + "default_book_cover.jpg")));
       }
        bookCover.setFitWidth(75);
        bookCover.setLayoutX(5);
        bookCover.setLayoutY(0);
        bookCover.setPreserveRatio(true);
        
        Label indTitle = new Label(holdingsMgr.getReservedCopies().get(index).getCopy().getTitle());
        indTitle.setPrefWidth(360);
        indTitle.getStyleClass().add("header-5");
        indTitle.setLayoutX(103);
        indTitle.setLayoutY(9);
        indTitle.setEllipsisString("...");
        indTitle.setTooltip(new Tooltip(indTitle.getText()));
        
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);
        
        Calendar cd=holdingsMgr.getReservedCopies().get(index).getDateAvailable();
        
        Label indAvailableDate = new Label("Available By: "+format.format(cd.getTime()));
        indAvailableDate.setLayoutX(51);
        indAvailableDate.setLayoutY(28);
        
        cd.add(Calendar.DAY_OF_MONTH,IndividualViewGUIMgr.STUDENT_RESERVE_DURATION );
        
        Label indBorrowByDate = new Label("Borrow By: "+format.format(cd.getTime()));
        indBorrowByDate.setLayoutX(51);
        indBorrowByDate.setLayoutY(42);
        
        Button detailsButton=new Button("Item Details");
        detailsButton.setLayoutX(205);
        detailsButton.setLayoutY(30);
        
        Button cancelReservationButton=new Button("Cancel");
        cancelReservationButton.setLayoutX(205);
        cancelReservationButton.setLayoutY(30);
        
        p.getChildren().addAll(bookCover,indTitle,indAvailableDate,indBorrowByDate,detailsButton,cancelReservationButton);
    }

    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane);
    }
    
    @Override   //call the inherited method to  update the current member
    public void setInitialData( ModelController modelController){        
        this.setModelController(modelController);
        //set the current member to Holdings
        holdingsMgr=new HoldingsMgr((Member)modelController.getUser()); 
        try{
            holdingsMgr.createItem();
        }
        catch(ClassNotFoundException| SQLException| TypeMismatchException e){
            ;
        }
        initializeBorrowScrollPane();
        initializeReserveScrollPane();
    }
}
