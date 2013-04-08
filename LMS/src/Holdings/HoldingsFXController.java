/**
 * Sample Skeleton for "Holdings.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package Holdings;

import baseGUI.BaseFXController;
import exception.NotEligibleToBorrowOrReserveException;
import exception.TypeMismatchException;
import globalcontrol.ModelController;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import searchbook.IndividualViewGUIController;
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
        borrowVB.setSpacing(11);
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
        bookCover.setFitWidth(40);
        bookCover.setLayoutX(5);
        bookCover.setLayoutY(5);
        bookCover.setPreserveRatio(true);
        
        Label indTitle = new Label(holdingsMgr.getCurrentHoldings().get(index).getCopy().getTitle());
        indTitle.setPrefWidth(400);
        indTitle.getStyleClass().add("header-5");
        indTitle.setLayoutX(55);
        indTitle.setLayoutY(1);
        indTitle.setEllipsisString("...");
        indTitle.setTooltip(new Tooltip(indTitle.getText()));
        
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);
        
        Label indBorrowDate = new Label("Borrowed On: "+format.format(holdingsMgr.getCurrentHoldings().get(index).getDateBorrowed().getTime()));
        indBorrowDate.setLayoutX(55);
        indBorrowDate.setLayoutY(26);
        
        Label indReturnDate = new Label("Return By: "+format.format(holdingsMgr.getCurrentHoldings().get(index).getDateToReturn().getTime()));
        indReturnDate.setLayoutX(75);
        indReturnDate.setLayoutY(44);
        
        Button extendButton=new Button("Extend");
        extendButton.setLayoutX(243);
        extendButton.setLayoutY(30);
        extendButton.setOnMouseClicked(new MouseClickExtendListener());
        
        p.getChildren().addAll(bookCover,indTitle,indBorrowDate,indReturnDate,extendButton);
    }
 
 private void initializeReserveScrollPane() {
        reserveVB.getChildren().clear();
        reserveVB.setSpacing(12);
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
        p.getStyleClass().add("reserve-holding");
        p.setMinSize(460, 64);
        ImageView bookCover;
       try
       {bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream(ModelController.BOOKCOVER_IMAGE_PATH + holdingsMgr.getReservedCopies().get(index).getCopy().getItemID()+".jpg")));
       }
       catch(Exception e)
       {
        bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + "default_book_cover.jpg")));
       }
        bookCover.setFitWidth(40);
        bookCover.setLayoutX(5);
        bookCover.setLayoutY(5);
        bookCover.setPreserveRatio(true);
        Label indTitle = new Label(holdingsMgr.getReservedCopies().get(index).getCopy().getTitle());
        indTitle.setPrefWidth(400);
        indTitle.getStyleClass().add("header-5");
        indTitle.setLayoutX(55);
        indTitle.setLayoutY(1);
        indTitle.setEllipsisString("...");
        indTitle.setTooltip(new Tooltip(indTitle.getText()));
        
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);
        
        Calendar cd=holdingsMgr.getReservedCopies().get(index).getDateAvailable();
        
        Label indAvailableDate = new Label("Available By: "+format.format(cd.getTime()));
        indAvailableDate.setLayoutX(61);
        indAvailableDate.setLayoutY(26);
        
        cd.add(Calendar.DAY_OF_MONTH,IndividualViewGUIMgr.STUDENT_RESERVE_DURATION );
        
        Label indBorrowByDate = new Label("Borrow By: "+format.format(cd.getTime()));
        indBorrowByDate.setLayoutX(70);
        indBorrowByDate.setLayoutY(44);
        
        Button detailsButton=new Button("Item Details");
        detailsButton.setLayoutX(243);
        detailsButton.setLayoutY(30);
        detailsButton.setOnMouseClicked(new MouseClickDetailsListener());
        
        Button cancelReservationButton=new Button("Cancel");
        cancelReservationButton.setLayoutX(365);
        cancelReservationButton.setLayoutY(30);
        cancelReservationButton.setOnMouseClicked(new MouseClickCancelReserveListener());
        
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
            setChanged();
            notifyObservers(e);
        }
        initializeBorrowScrollPane();
        initializeReserveScrollPane();
    }
    private class MouseClickDetailsListener implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent e) {
            Node node=((Node) e.getSource()).getParent();
            try
        {int id=Integer.parseInt(node.getId());
            FXMLLoader fxmlLoader=transitPane("IndividualReservableGUI.fxml", (Pane)contentPane.getParent(), getModelController() );
            IndividualViewGUIController ic = fxmlLoader.<IndividualViewGUIController>getController();
            setChanged();
            notifyObservers(ic);
            ic.setId(holdingsMgr.getReservedCopies().get(id).getCopy().getItemID());
        }
        catch(Exception except)
        {
            setChanged();
            notifyObservers(except);
        }    
            
        }
}
    private class MouseClickCancelReserveListener implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent e) {
            Node node=((Node) e.getSource()).getParent();
            try
        {int id=Integer.parseInt(node.getId());
         holdingsMgr.cancelReservation(id);
         try{
         holdingsMgr.createItem();
         initializeReserveScrollPane();
         displaySuccess("Reservation Cancelled", "Your reservation of item "+holdingsMgr.getReservedCopies().get(id).getCopy().getItemID()+" was successfully cancelled.");
         }
         catch(ClassNotFoundException| SQLException| TypeMismatchException except){
             setChanged();
            notifyObservers(except);
         }
        }
        catch(SQLException|ClassNotFoundException except)
        {
            String text = "We regret to inform you that your reservation could not be cancelled.\n";
            text += "Reasons might be: \n";
            text += except.getMessage();
            displayWarning("Sorry", text);
        }    
            
        }
    }
    private class MouseClickExtendListener implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent e) {
           Node node=((Node) e.getSource()).getParent();
            try
        {int id=Integer.parseInt(node.getId());
         holdingsMgr.extend(id);
         try{
         holdingsMgr.createItem();
         initializeBorrowScrollPane();
         displaySuccess("Extended", "Your Extension of item "+holdingsMgr.getCurrentHoldings().get(id).getCopy().getItemID()+" was successful.\n Please return by");
         }
         catch(ClassNotFoundException| SQLException| TypeMismatchException except){
             setChanged();
            notifyObservers(except);
         }
        }
        catch(SQLException|ClassNotFoundException| NotEligibleToBorrowOrReserveException except)
        {
            String text = "We regret to inform you that your extension request could not be approved.\n";
            text += "Reasons might be: \n";
            text += except.getMessage();
            displayWarning("Sorry", text);
        }        
            
        }
}
}