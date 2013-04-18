/**
 *
 * @author Adarsh
 */

package searchbook;

import baseGUI.BaseFXController;
import cataloguemanagement.ReservableCopyGroup;
import exception.CopyNotFoundException;
import exception.InvalidKeywordException;
import exception.ItemNotFoundException;
import globalcontrol.ModelController;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import usermanagement.Member;

/**
 *
 * @author Adarsh Kanodia
 */
public class SearchFXController extends BaseFXController implements Initializable{
    
    private SearchMgr searchMgr;
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
    
    /**
     * Initializes the Controller class from the FXML file
     * @param fxmlFileLocation The URL of the FXML file linked to this Controller
     * @param resources
     */
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
    
    
    /**
     * Sets the initial data for this class
     * @param modelController Sets the {@link globalcontrol.ModelController} object for this Class
     */
    @Override
    public void setInitialData(ModelController modelController){  
        
        this.setModelController(modelController);
        //set the current member to search
        searchMgr.setCurrentMember((Member)modelController.getUser());
        
    }
    
    /**
     * Event Handler for the {@link #searchButton}.
     * It calls the {@link #getDetails() } function to retrieve items that match the search query entered by the User.
     * @param event The Search Button Click Event
     * @throws IOException 
     */
    // Handler for Button[Button[id=null, styleClass=button]] onAction
    public void handlesearchbutton(ActionEvent event)throws IOException{
        getDetails();
    }
    
 /**
     * Creates the Individual Search Result Panes.
     * @param p The Pane to be filled
     * @param item the search results.
     */
    private void createIndividual(Pane p,ReservableCopyGroup item) {
        p.setId(""+item.getItemID());
        p.getStyleClass().add("searchResult");
        p.setMinSize(480, 124);
        ImageView bookCover;
       try
       {bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream(ModelController.BOOKCOVER_IMAGE_PATH + item.getItemID()+".jpg")));
       }
       catch(Exception e)
       {
        bookCover=new ImageView(new Image(SearchFXController.class.getResourceAsStream( ModelController.BOOKCOVER_IMAGE_PATH + "default_book_cover.jpg")));
       }
        bookCover.setFitWidth(80);
        bookCover.setLayoutX(7);
        bookCover.setLayoutY(7);
        bookCover.setPreserveRatio(true);
        
        Label indTitle = new Label(item.getTitle());
        indTitle.setPrefWidth(360);
        indTitle.getStyleClass().add("header-5");
        indTitle.setLayoutX(103);
        indTitle.setLayoutY(9);
        indTitle.setEllipsisString("...");
        indTitle.setTooltip(new Tooltip(indTitle.getText()));
        
        Label indAuthor = new Label("Author: "+item.getAuthor());
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
        p.setOnMouseClicked(new MouseClickListener());
    }
    
    /**
     * Handles the animation for pane transition.
     */
    @Override   //play new animation when shown
    public void playOnShowAnimation (){
        this.handleOnShowAnimation(contentPane);
    }
     /**
     * Enables/Disables the Search Button when the {@link #keywordField} is changed.
     * @param event Event generated when something is entered in the {@link #keywordField}.
     */
    @FXML
    void updateSearchButton(KeyEvent event) {
        updateSearchButton();
    }

    /**
     * Initializes the Scroll Pane which displays all the search results.
     */
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
 /**
  * Initiates the search using the {@link #searchMgr}, depending on User preferences. 
  */
    private void getDetails() {
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
        catch(SQLException|ClassNotFoundException| CopyNotFoundException| InvalidKeywordException| ItemNotFoundException e)
        {displayWarning("Oops","An Unexpected Error occured while processing your query.\nReason might be: \n"+e.getMessage());
        }
        if(searchMgr.getNoOfResults()!=0)
         initializeScrollPane();
        else
        { keywordField.clear();
          updateSearchButton();
            displayWarning("No Results","Sorry your query '"+keywordField.getText()+"' returned no results...");
        }
    }
/**
 * If {@link #keywordField} is not empty it enables the search button otherwise it disables it.
 */
    private void updateSearchButton() {
        if(!keywordField.getText().trim().equals(""))
            searchButton.setDisable(false);
        else
            searchButton.setDisable(true);
    }
  /**
   * This anonymous class handles the Mouse Click events of the search results.
   */  
    private class MouseClickListener implements EventHandler<MouseEvent>{
        /**
         * Handles the clicking of a search result.
         * Transitions the scene to the result item's individual page.
         * @param e The MouseEvent generated on clicking a search Result
         */
        @Override
        public void handle(MouseEvent e) {
            Node node=(Node) e.getSource();
                
            String id=node.getId();
            FXMLLoader fxmlLoader=transitPane("IndividualReservableGUI.fxml", (Pane)contentPane.getParent(), getModelController() );
            IndividualViewGUIController ic = fxmlLoader.<IndividualViewGUIController>getController();
            setChanged();
            notifyObservers(ic);
            try{
            ic.setId(id);
            }
            catch(Exception except)
            {
            setChanged();
            except.printStackTrace();
            notifyObservers(except);
            } 
        }
        
    }
    
}
