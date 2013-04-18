

package Holdings;

import baseGUI.BaseFXController;
import exception.CopyNotFoundException;
import exception.ItemNotFoundException;
import exception.NotEligibleToBorrowOrReserveException;
import exception.NullResultException;
import exception.RecordNotFoundException;
import exception.TypeMismatchException;
import exception.UserNotFoundException;
import exception.UserSuspendedException;
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

/**
 *
 * @author Adarsh
 */

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
    
      @FXML
    private Label confirmHeader;

    @FXML
    private AnchorPane confirmMessageHolderPane;

    @FXML
    private AnchorPane confirmPane;

    @FXML
    private Label confirmText;
    
    @FXML
    private Button noconfirm;
    
    @FXML
    private Button yesconfirm;
    
    private MouseEvent confEvent;
    
    private HoldingsMgr holdingsMgr;

    /**
     * Initializes the Controller class from the FXML file
     * @param fxmlFileLocation The URL of the FXML file linked to this Controller
     * @param resources
     */
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert borrowVB != null : "fx:id=\"borrowVB\" was not injected: check your FXML file 'Holdings.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'Holdings.fxml'.";
        assert reserveVB != null : "fx:id=\"reserveVB\" was not injected: check your FXML file 'Holdings.fxml'.";

    }
     /**
     * Initializes the Scroll Pane which displays all of the User's current Borrowings.
     */
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

/**
     *
     * @param event
     */
    public void handleConfirmYesButtonAction(ActionEvent event){
       Node node=((Node) confEvent.getSource()).getParent();
       String [] exceptions={""};
       enableDisablePanes(exceptions,false);
       if(node.getId().charAt(0)=='r')
       { cancelReservation(node);    
       }
       else if(node.getId().charAt(0)=='h')
       {  extend(node);   
       }
       confirmPane.setVisible(false);
    }
     /**
     *
     * @param event
     */
    public void handleConfirmNoButtonAction(ActionEvent event){
     confirmPane.setVisible(false);
     String [] exceptions={""};
     enableDisablePanes(exceptions ,false);
    }
    
    /**
 * Creates the Individual Borrowed Copy Panes.
 * @param p The Pane to be filled
 * @param index the index of the particular {@link cataloguemanagement.CurrentHolding} object in the ArrayList in {@link #holdingsMgr}.
 */
 private void createHoldingIndividual(Pane p,int index) {
        p.setId("h"+index);
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
 /**
  * Initializes the Scroll Pane which displays all of the User's current Reservations.
  */
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
 /**
 * Creates the Individual Reserved Copy Panes.
 * @param p The Pane to be filled
 * @param index the index of the particular {@link cataloguemanagement.ReservedCopy} object in the ArrayList in {@link #holdingsMgr}.
 */
 private void createReservedIndividual(Pane p,int index) {
        p.setId("r"+index);
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
    /**
     * Handles the animation for pane transition.
     */
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane);
    }
     /**
     * Sets the initial data for this class
     * @param modelController Sets the {@link globalcontrol.ModelController} object for this Class
     */
    @Override   //call the inherited method to  update the current member
    public void setInitialData( ModelController modelController){        
        this.setModelController(modelController);
        //set the current member to Holdings
        holdingsMgr=new HoldingsMgr((Member)modelController.getUser()); 
        try{
            holdingsMgr.createItem();
            
        }
        catch(ClassNotFoundException| SQLException| TypeMismatchException | CopyNotFoundException | ItemNotFoundException | UserNotFoundException e){
            setChanged();
            notifyObservers(e);
        }
        initializeBorrowScrollPane();
        initializeReserveScrollPane();
    }

    private void cancelReservation(Node node){
        try
    {int id=Integer.parseInt(node.getId().substring(1));
     holdingsMgr.cancelReservation(id);
     try{
     String cancelledId=holdingsMgr.getReservedCopies().get(id).getCopy().getItemID();
     holdingsMgr.createItem();
     initializeReserveScrollPane();
     displaySuccess("Reservation Cancelled", "Your reservation of item "+cancelledId+" was successfully cancelled.");
     }
     catch(ClassNotFoundException| SQLException| TypeMismatchException |NumberFormatException | CopyNotFoundException | ItemNotFoundException | UserNotFoundException except){
         setChanged();
        notifyObservers(except);
     }
    }
    catch(SQLException|ClassNotFoundException| CopyNotFoundException| NullResultException| NumberFormatException| UserNotFoundException except)
    {
        String text = "We regret to inform you that your reservation could not be cancelled.\n";
        text += "Reasons might be: \n";
        text += except.getMessage();
        displayWarning("Sorry", text);
    }
    }
    private void extend(Node node){
        try
        {int id=Integer.parseInt(node.getId().substring(1));
         holdingsMgr.extend(id);
         try{
         holdingsMgr.createItem();
         initializeBorrowScrollPane();
         SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);
         displaySuccess("Extended", "Your Extension of item "+holdingsMgr.getCurrentHoldings().get(id).getCopy().getItemID()+" was successful.\n Please return by\n"+format.format(holdingsMgr.getCurrentHoldings().get(id).getDateToReturn().getTime()));
         }
         catch(ClassNotFoundException| SQLException| TypeMismatchException except){
             setChanged();
            notifyObservers(except);
         }
        }
        catch(SQLException|ClassNotFoundException| NotEligibleToBorrowOrReserveException | CopyNotFoundException| ItemNotFoundException| NullResultException| NumberFormatException| RecordNotFoundException| UserNotFoundException| UserSuspendedException except)
        {
            String text = "We regret to inform you that your extension request could not be approved.\n";
            text += "Reasons might be: \n";
            text += except.getMessage();
            displayWarning("Sorry", text);
        }   
    }
  /**
   * This anonymous class handles the Mouse Click events of the Get Details Button for each Reserved Copy.
   */ 
    private class MouseClickDetailsListener implements EventHandler<MouseEvent>{
        /**
         * Handles the clicking of the Get Details button.
         * Transitions the scene to the particular Reserved item's individual page.
         * @param e The MouseEvent generated on clicking a Get Details button.
         */
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
} /**
   * This anonymous class handles the Mouse Click events of the Cancel Button for each Reserved Copy.
   */ 
    private class MouseClickCancelReserveListener implements EventHandler<MouseEvent>{
        /**
         * Handles the clicking of the Cancel button.
         * Cancels a particular Reservation.
         * @param e The MouseEvent generated on clicking a Cancel button.
         */
        @Override
        public void handle(MouseEvent e) {
            confEvent=e;
            updateConfirmPane("Confirm Action", "Are You Sure you wish to cancel this Reservation?");
            confirmPane.setVisible(true);
            String [] exceptions={confirmPane.getId(),messagePane.getId()};
            enableDisablePanes( exceptions,true);
        handleOnShowAnimation(confirmMessageHolderPane);   
        }
    }
  /**
   * This anonymous class handles the Mouse Click events of the Extend Button for each Borrowed Copy.
   */ 
    private class MouseClickExtendListener implements EventHandler<MouseEvent>{
        /**
         * Handles the clicking of the Extend button.
         * Extends a Borrowed item.
         * @param e The MouseEvent generated on clicking a Extend button.
         */
        @Override
        public void handle(MouseEvent e) {
          confEvent=e;
          updateConfirmPane("Confirm Action", "Are You Sure you wish to Extend this Copy?");
          confirmPane.setVisible(true);
          String [] exceptions={confirmPane.getId(),messagePane.getId()};
          enableDisablePanes(exceptions ,true);
          handleOnShowAnimation(confirmMessageHolderPane); 
        }
}
    private void updateConfirmPane(String title,String message){
        confirmHeader.setText(title);
        confirmText.setText(message);
    }
    private void enableDisablePanes(String[] idExcept ,boolean flag){
        Pane p=contentPane;
        for(int i=0;i<p.getChildren().size(); i++){
            Node n=p.getChildren().get(i);
            String nid=n.getId();
            if(nid==null)
                n.setDisable(flag);
            else
            {boolean idOk=true;
             for(int j=0;j<idExcept.length;j++)
             {
                 if(nid.equals(idExcept[j]))
                 { idOk=false;
                   break;
                 }
             }
             if(idOk)
                n.setDisable(flag);
        }
    }
    }
}