

package searchbook;

import baseGUI.BaseFXController;
import cataloguemanagement.Reservable;
import exception.CopyBorrowedException;
import exception.CopyNotBorrowedException;
import exception.CopyNotFoundException;
import exception.CopyReservedException;
import exception.InvalidUserTypeException;
import exception.ItemNotFoundException;
import exception.NotEligibleToBorrowOrReserveException;
import exception.NullResultException;
import exception.UserNotFoundException;
import exception.UserSuspendedException;
import globalcontrol.ModelController;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import usermanagement.Member;

/**
 *
 * @author Adarsh
 */
public class IndividualViewGUIController extends BaseFXController implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="author"
    private Label author; // Value injected by FXMLLoader

    @FXML // fx:id="borrowablecopies"
    private Label borrowablecopies; // Value injected by FXMLLoader

    @FXML // fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML // fx:id="cover"
    private ImageView cover; // Value injected by FXMLLoader

    @FXML // fx:id="genre"
    private Label genre; // Value injected by FXMLLoader

    @FXML // fx:id="individualPane"
    private ScrollPane individualPane; // Value injected by FXMLLoader

    @FXML // fx:id="isbn"
    private Label isbn; // Value injected by FXMLLoader

    @FXML // fx:id="itemDescription"
    private Text itemDescription; // Value injected by FXMLLoader

    @FXML // fx:id="itemDescriptionAnchorPane"
    private AnchorPane itemDescriptionAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="itemDescriptionScrollPane"
    private ScrollPane itemDescriptionScrollPane; // Value injected by FXMLLoader

    @FXML // fx:id="reservablecopies"
    private Label reservablecopies; // Value injected by FXMLLoader

    @FXML // fx:id="scrollPane"
    private ScrollPane scrollPane; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private Label title; // Value injected by FXMLLoader
    
    @FXML
    private VBox copyVBox;
    
    private IndividualViewGUIMgr individualMgr;
    private int bc,rc;
 
    /**
     * Initializes the Controller class from the FXML file
     * @param fxmlFileLocation The URL of the FXML file linked to this Controller
     * @param resources
     */
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert borrowablecopies != null : "fx:id=\"borrowablecopies\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert cover != null : "fx:id=\"cover\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert genre != null : "fx:id=\"genre\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert individualPane != null : "fx:id=\"individualPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert isbn != null : "fx:id=\"isbn\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert itemDescription != null : "fx:id=\"itemDescription\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert itemDescriptionAnchorPane != null : "fx:id=\"itemDescriptionAnchorPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert itemDescriptionScrollPane != null : "fx:id=\"itemDescriptionScrollPane\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert reservablecopies != null : "fx:id=\"reservablecopies\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";
        assert copyVBox != null : "fx:id=\"copyVBox\" was not injected: check your FXML file 'IndividualReservableGUI.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected        
        individualMgr = new IndividualViewGUIMgr();
    }
    /**
     *Initializes the entire Book View based on the Item with ID id.
     * @param id The ID of the {@link Reservable} Item which is being detailed.
     */
    public void setId(String id){
    individualMgr.setItem(null);
    try{
        individualMgr.createItem(id);
    }
    catch(SQLException|ClassNotFoundException | CopyNotFoundException | ItemNotFoundException e)
    {  
        setChanged();
        notifyObservers(e);
    }   
    title.setText(individualMgr.getItem().getTitle());
    title.setTooltip(new Tooltip(title.getText()));
    title.setTextOverrun( OverrunStyle.CENTER_WORD_ELLIPSIS);
    author.setText("Author: "+individualMgr.getItem().getAuthor());
    try
       {cover.setImage(new Image(IndividualViewGUIController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + id + ".jpg")));
       }
       catch(Exception e)
       {
        cover.setImage(new Image(IndividualViewGUIController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + "default_book_cover.jpg")));
       }
   //Need Genre in Better way
    String genreStr=individualMgr.getItem().getGenre();
    if(genreStr==null)
        genreStr="-";
    genre.setText("Genre: "+genreStr);
    
    //Need item Description in Better way
    String itemDescriptionText = individualMgr.getItem().getDescription();
    itemDescription.setText(itemDescriptionText);
    double height = computeTextHeight(itemDescriptionText ,42, 12);
    itemDescriptionAnchorPane.setPrefHeight(height); 
    
    //Need ISBN in Better way
    String isbnStr=individualMgr.getItem().getISBN();
    if(isbnStr==null)
        isbnStr="-";
    isbn.setText("(ISBN: "+isbnStr+")");
        initializeCopyScrollPane();
}
    /**
     * Resizes the height of the String contained in text, provided there are charsPerLine characters per line and the height of each line is lineHeight.
     * @param text The text who's height is to be measured 
     * @param charsPerLine The characters per line.
     * @param lineHeight The height of each line.
     * @return Height of text
     */
private double computeTextHeight(String text, int charsPerLine, double lineHeight){
        return text.length() / charsPerLine * lineHeight;
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
    @Override   //call the inherited method to update the current member
    public void setInitialData(ModelController modelController) {
        this.setModelController(modelController);
        //set the current member to borrow
        individualMgr.setCurrentMember((Member)modelController.getUser());
    }
    /**
     * Creates the Individual Book Copy Panes.
     * @param p The Pane to be filled
     * @param item the item to be displayed.
     */
    private void createIndividual(Pane p,Reservable item) {
        p.setMinSize(498, 40);
        
        Text copyText=new Text(item.getIndividualCopyID());
        copyText.setLayoutX(78);
        copyText.setLayoutY(23);
        
        Label copyID = new Label("Copy ID:");
        copyID.getStyleClass().add("copy-label");
        copyID.setLayoutX(28);
        copyID.setLayoutY(10);
        
        Label status = new Label("Status:");
        status.getStyleClass().add("copy-label");
        status.setLayoutX(165);
        status.setLayoutY(10);
        
        Text statusText;
        try{
          if(!item.isBorrowed()&&!item.isReserved()){   
            statusText=new Text("Available");
            statusText.setLayoutX(205);
            statusText.setLayoutY(23);
            p.getStyleClass().add("individual-copy-available-pane");
            
            Label copyLocation = new Label("Location:");
            copyLocation.getStyleClass().add("copy-label");
            copyLocation.setLayoutX(272);
            copyLocation.setLayoutY(10);
            
            Text locationText=new Text(item.getLocation());
            locationText.setLayoutX(325);
            locationText.setLayoutY(23);
            
            bc++;
            
            p.getChildren().addAll(copyID,copyText,status,statusText,copyLocation,locationText);
          }
          else if(item.isReserved()){
            statusText=new Text("Borrowed");
            statusText.setLayoutX(205);
            statusText.setLayoutY(23);
            p.getStyleClass().add("individual-copy-reserved-pane");
            
            Label returnDate = new Label("Return Date:");
            returnDate.getStyleClass().add("copy-label");
            returnDate.setLayoutX(272);
            returnDate.setLayoutY(10);
            
            Text returnText=new Text("***");
            Date d = item.getPastTransaction().getDateToReturn().getTime();
            SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
            returnText.setText(ft.format(d));
            returnText.setLayoutX(343);
            returnText.setLayoutY(23);
            
            Text reservedText=new Text("Reserved");
            reservedText.setLayoutX(409);
            reservedText.setLayoutY(23);
            
            
            p.getChildren().addAll(copyID,copyText,status,statusText,returnDate,returnText,reservedText);
          }
          else
          {statusText=new Text("Borrowed");
            statusText.setLayoutX(205);
            statusText.setLayoutY(23);
            p.getStyleClass().add("individual-copy-reservable-pane");
            
            Label returnDate = new Label("Return Date:");
            returnDate.getStyleClass().add("copy-label");
            returnDate.setLayoutX(272);
            returnDate.setLayoutY(10);
            
            Text returnText=new Text("***");
            Date d = item.getPastTransaction().getDateToReturn().getTime();
            SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
            returnText.setText(ft.format(d));
            returnText.setLayoutX(343);
            returnText.setLayoutY(23);
            rc++;
            Button reserveButton=new Button("Reserve");
            reserveButton.setLayoutX(409);
            reserveButton.setLayoutY(7);
            reserveButton.setOnMouseClicked(new MouseClickListener());
            p.getChildren().addAll(copyID,copyText,status,statusText,returnDate,returnText,reserveButton); 
          }
        }
        catch(SQLException|ClassNotFoundException| CopyNotFoundException| InvalidUserTypeException| ItemNotFoundException| NullResultException| UserNotFoundException e){
            setChanged();
            notifyObservers(e);
        }
    }
/**
     * Initializes the Scroll Pane which displays all the item Copies.
     */
    private void initializeCopyScrollPane() {
        copyVBox.getChildren().clear();
        bc=0;rc=0;
        for(int i=0;i<individualMgr.getItem().getCopiesAvailable();i++)
            {  Pane p=new Pane();
               p.setId(i+"");
                      createIndividual(p,individualMgr.getItem().getCopies().get(i));
                      copyVBox.getChildren().add(p);
                    handleNodeScaleTransition(p, 400,0,1);
             }
       borrowablecopies.setText("Borrowable Copies: "+bc);
        reservablecopies.setText("Reservable Copies: "+rc);
    }
    /**
   * This anonymous class handles the Mouse Click events of the individual item copies.
   */
    private class MouseClickListener implements EventHandler<MouseEvent>{
        /**
         * Reserves an item.
         * @param e The MouseEvent generated on clicking a the reserveButton for a copy
         */
        @Override
        public void handle(MouseEvent e) {
            Node node=(Node)e.getSource();
                
            String id=node.getParent().getId();
            try
            {
            individualMgr.reserve(Integer.parseInt(id));
            Calendar cd=individualMgr.getItem().getCopies().get(Integer.parseInt(id)).getPastTransaction().getDateToReturn();
            initializeCopyScrollPane();
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);
            String availableDate=format.format(cd.getTime());
            cd.add(Calendar.DAY_OF_MONTH,IndividualViewGUIMgr.STUDENT_RESERVE_DURATION );
            String borrowByDate=format.format(cd.getTime());
            String text = "Your request for reservation of this item has been sucessfully granted.\n";
            text += "It will be tentatively be available to you by "+availableDate+".\nKindly Borrow it by "+borrowByDate+". Following which this reservation shall expire";
            displaySuccess("Thank you",text);
            }
            catch(NotEligibleToBorrowOrReserveException | SQLException | ClassNotFoundException | CopyBorrowedException|CopyNotFoundException | CopyNotBorrowedException| CopyReservedException| InvalidUserTypeException| ItemNotFoundException| NullResultException| NumberFormatException| UserNotFoundException| UserSuspendedException except){
            String text = "We regret to inform you that your request to reserve this copy was not granted.\n";
            text += "Reasons might be: \n";
            text += except.getMessage();
            displayWarning("Sorry",text);
        }
        }
        
    }
}
