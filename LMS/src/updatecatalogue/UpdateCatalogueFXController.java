package updatecatalogue;

import baseGUI.BaseFXController;
import datamanagement.Table;
import exception.CopyNotFoundException;
import exception.InvalidItemTypeException;
import exception.ItemNotFoundException;
import exception.NullResultException;
import globalcontrol.ModelController;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import usermanagement.Librarian;


/**
 *
 * @author Adarsh
 */

public class UpdateCatalogueFXController extends BaseFXController
    implements Initializable {
    
    private UpdateMgr updateMgr;
    private String tempItemID;
    private String tempCopyID;

    
    
    @FXML //  fx:id="actionHolderPane"
    private AnchorPane actionHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="bookInfoPane"
    private AnchorPane bookInfoPane; // Value injected by FXMLLoader

    @FXML //  fx:id="bookType"
    private RadioButton bookType; // Value injected by FXMLLoader

    @FXML //  fx:id="confirmHeader"
    private Label confirmHeader; // Value injected by FXMLLoader

    @FXML //  fx:id="confirmMessageHolderPane"
    private AnchorPane confirmMessageHolderPane; // Value injected by FXMLLoader

    @FXML //  fx:id="confirmPane"
    private AnchorPane confirmPane; // Value injected by FXMLLoader

    @FXML //  fx:id="confirmText"
    private Label confirmText; // Value injected by FXMLLoader

    @FXML //  fx:id="contentPane"
    private AnchorPane contentPane; // Value injected by FXMLLoader

    @FXML //  fx:id="getCopyDetailsButton"
    private Button getCopyDetailsButton; // Value injected by FXMLLoader

    @FXML //  fx:id="getItemDetailsButton"
    private Button getItemDetailsButton; // Value injected by FXMLLoader
    
    @FXML //  fx:id="maskPane"
    private AnchorPane maskPane; // Value injected by FXMLLoader

    @FXML //  fx:id="newBookGenre"
    private TextField newBookGenre; // Value injected by FXMLLoader

    @FXML //  fx:id="newBookISBN"
    private TextField newBookISBN; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyButton"
    private Button newCopyButton; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyConfirmButton"
    private Button newCopyConfirmButton; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyItemID"
    private TextField newCopyItemID; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyLocation"
    private TextField newCopyLocation; // Value injected by FXMLLoader

    @FXML //  fx:id="newCopyPane"
    private AnchorPane newCopyPane; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemAuthor"
    private TextField newItemAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemButton"
    private Button newItemButton; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemConfirm"
    private Button newItemConfirm; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemDescription"
    private TextArea newItemDescription; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPane"
    private AnchorPane newItemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemPublishDate"
    private TextField newItemPublishDate; // Value injected by FXMLLoader

    @FXML //  fx:id="newItemTitle"
    private TextField newItemTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="noConfirm"
    private Button noConfirm; // Value injected by FXMLLoader

    @FXML //  fx:id="optionPane"
    private AnchorPane optionPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyButton"
    private Button updateCopyButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyConfirmButton"
    private Button updateCopyConfirmButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyDeleteButton"
    private Button updateCopyDeleteButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyID"
    private TextField updateCopyID; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyInfoPane"
    private AnchorPane updateCopyInfoPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyLocation"
    private TextField updateCopyLocation; // Value injected by FXMLLoader

    @FXML //  fx:id="updateCopyPane"
    private AnchorPane updateCopyPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemAuthor"
    private TextField updateItemAuthor; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemButton"
    private Button updateItemButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemConfirmButton"
    private Button updateItemConfirmButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemDeleteButton"
    private Button updateItemDeleteButton; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemDescription"
    private TextArea updateItemDescription; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemGenre"
    private TextField updateItemGenre; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemISBN"
    private TextField updateItemISBN; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemInfoPane"
    private AnchorPane updateItemInfoPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemItemID"
    private TextField updateItemItemID; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemPane"
    private AnchorPane updateItemPane; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemPublishDate"
    private TextField updateItemPublishDate; // Value injected by FXMLLoader

    @FXML //  fx:id="updateItemTitle"
    private TextField updateItemTitle; // Value injected by FXMLLoader

    @FXML //  fx:id="yesConfirm"
    private Button yesConfirm; // Value injected by FXMLLoader



    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert actionHolderPane != null : "fx:id=\"actionHolderPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert bookInfoPane != null : "fx:id=\"bookInfoPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert bookType != null : "fx:id=\"bookType\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert confirmHeader != null : "fx:id=\"confirmHeader\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert confirmMessageHolderPane != null : "fx:id=\"confirmMessageHolderPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert confirmPane != null : "fx:id=\"confirmPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert confirmText != null : "fx:id=\"confirmText\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert getCopyDetailsButton != null : "fx:id=\"getCopyDetailsButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert getItemDetailsButton != null : "fx:id=\"getItemDetailsButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert hideMessage != null : "fx:id=\"hideMessage\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert maskPane != null : "fx:id=\"maskPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageHeader != null : "fx:id=\"messageHeader\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageHolderPane != null : "fx:id=\"messageHolderPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messagePane != null : "fx:id=\"messagePane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert messageText != null : "fx:id=\"messageText\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newBookGenre != null : "fx:id=\"newBookGenre\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newBookISBN != null : "fx:id=\"newBookISBN\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyButton != null : "fx:id=\"newCopyButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyConfirmButton != null : "fx:id=\"newCopyConfirmButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyItemID != null : "fx:id=\"newCopyItemID\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyLocation != null : "fx:id=\"newCopyLocation\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newCopyPane != null : "fx:id=\"newCopyPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemAuthor != null : "fx:id=\"newItemAuthor\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemButton != null : "fx:id=\"newItemButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemConfirm != null : "fx:id=\"newItemConfirm\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemDescription != null : "fx:id=\"newItemDescription\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemPane != null : "fx:id=\"newItemPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemPublishDate != null : "fx:id=\"newItemPublishDate\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert newItemTitle != null : "fx:id=\"newItemTitle\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert noConfirm != null : "fx:id=\"noConfirm\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert optionPane != null : "fx:id=\"optionPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyButton != null : "fx:id=\"updateCopyButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyConfirmButton != null : "fx:id=\"updateCopyConfirmButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyDeleteButton != null : "fx:id=\"updateCopyDeleteButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyID != null : "fx:id=\"updateCopyID\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyInfoPane != null : "fx:id=\"updateCopyInfoPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyLocation != null : "fx:id=\"updateCopyLocation\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateCopyPane != null : "fx:id=\"updateCopyPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemAuthor != null : "fx:id=\"updateItemAuthor\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemButton != null : "fx:id=\"updateItemButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemConfirmButton != null : "fx:id=\"updateItemConfirmButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemDeleteButton != null : "fx:id=\"updateItemDeleteButton\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemDescription != null : "fx:id=\"updateItemDescription\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemGenre != null : "fx:id=\"updateItemGenre\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemISBN != null : "fx:id=\"updateItemISBN\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemInfoPane != null : "fx:id=\"updateItemInfoPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemItemID != null : "fx:id=\"updateItemItemID\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemPane != null : "fx:id=\"updateItemPane\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemPublishDate != null : "fx:id=\"updateItemPublishDate\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert updateItemTitle != null : "fx:id=\"updateItemTitle\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";
        assert yesConfirm != null : "fx:id=\"yesConfirm\" was not injected: check your FXML file 'UpdateCatalogue.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

        updateMgr = new UpdateMgr();
    }



    // Handler for Button[fx:id="getCopyDetailsButton"] onAction
    /**
     *
     * @param event
     */
    public void handleGetCopyDetailsButtonAction(ActionEvent event) {
        String copyID = updateCopyID.getText();
        try{
            //get the details from mgr
            HashMap copyInfo = updateMgr.getCopyDetails(copyID);
            //display on the fields
            updateCopyLocation.setText((String)(copyInfo.get(Table.COPY_LOCATION)));
            //enable the info pane
            updateCopyInfoPane.setDisable(false);
            this.tempCopyID = copyID;
        }        
        catch( SQLException | ClassNotFoundException e){
            this.displayWarning("Error", e.getMessage());
        } catch (Exception ex) {
            this.displayWarning("Error", ex.getMessage());
        } 
    }

    // Handler for Button[fx:id="getItemDetailsButton"] onAction
    /**
     *
     * @param event
     */
    public void handleGetItemDetailsButtonAction(ActionEvent event) {
        String itemID = updateItemItemID.getText();
        try{
            //get the details from mgr
            HashMap itemInfo = updateMgr.getItemInfo(itemID);
            //display on the fields
            updateItemTitle.setText((String)itemInfo.get(Table.BOOK_TITLE));
            updateItemAuthor.setText((String)itemInfo.get(Table.BOOK_AUTHOR));
            updateItemDescription.setText((String)itemInfo.get(Table.BOOK_DESCRIPTION));
            updateItemPublishDate.setText(formatDateString((Calendar)itemInfo.get(Table.BOOK_DATE)));
            updateItemISBN.setText((String)itemInfo.get(Table.BOOK_ISBN));
            updateItemGenre.setText((String)itemInfo.get(Table.BOOK_GENRE));
            //enable item info pane
            updateItemInfoPane.setDisable(false);
            this.tempItemID = itemID;
        }
        catch(ItemNotFoundException | SQLException | ClassNotFoundException e){
            this.displayWarning("Error", e.getMessage());
        } catch (Exception ex) {
            this.displayWarning("Error", ex.getMessage());
        } 
    }

    // Handler for Button[fx:id="newCopyButton"] onAction
    /**
     *
     * @param event
     */
    public void handleNewCopyButtonAction(ActionEvent event) {
        //delete all panes on actionHolderPane and add the newCopyPane
        setAllChildrenInvisible();
        newCopyPane.setVisible(true);
        this.handleOnShowAnimation(actionHolderPane);
    }

    // Handler for Button[fx:id="newCopyConfirmButton"] onAction
    /**
     *
     * @param event
     */
    public void handleNewCopyConfirmButtonAction(ActionEvent event) {
        try{
            String itemID = newCopyItemID.getText();
            String location = newCopyLocation.getText();
            updateMgr.addNewCopy(itemID, location);
            this.displaySuccess("New Copy Added", "A new copy for " + itemID + " has been successfully created.");
            this.clearNewCopyFields();
        }
        /*
        catch(ItemNotFoundException e){
            displayWarning("Error","Item ID not found\n" + e.getMessage());
        }
        */ 
        catch(SQLException | ClassNotFoundException e){
            displayWarning("Sorry","One of the fields is wrong:\n" + e.getMessage());
        }
    }

    // Handler for Button[fx:id="newItemButton"] onAction
    /**
     *
     * @param event
     */
    public void handleNewItemButtonAction(ActionEvent event) {
        //delete all panes on actionHolderPane and add the newItemPane
        setAllChildrenInvisible();
        newItemPane.setVisible(true);
        this.handleOnShowAnimation(actionHolderPane);
    }

    // Handler for Button[fx:id="newItemConfirm"] onAction
    /**
     *
     * @param event
     */
    public void handleNewItemConfirmAction(ActionEvent event) {
        try{
            String title = newItemTitle.getText();
            String author = newItemAuthor.getText();
            GregorianCalendar publishDate = parseDate(newItemPublishDate.getText());
            String description = newItemDescription.getText();
            if (bookType.isSelected()){
                String ISBN = newBookISBN.getText();
                String genre = newBookGenre.getText();
                if (title.length()>0 && author.length()>0 && description.length()>0 && ISBN.length()>0 && genre.length()>0){
                    updateMgr.addNewBook(title, author, publishDate, description, ISBN, genre);
                    this.displaySuccess("New Item Added", "New item " + title + " has been successfully added");
                    this.clearNewItemFields();
                }
                else{                    
                    displayWarning("Item Information incomplete", "Please fill in the necessary fields");
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            displayWarning("Sorry","Date format is wrong\n" + e.getMessage());
        }
        catch(Exception e){
            displayWarning("Sorry","One of the fields is wrong:\n" + e.getMessage());
        }
        
    }

    // Handler for Button[fx:id="updateCopyButton"] onAction
    /**
     *
     * @param event
     */
    public void handleUpdateCopyButtonAction(ActionEvent event) {
        //delete all panes on actionHolderPane and add the updateCopyPane
        setAllChildrenInvisible();
        updateCopyPane.setVisible(true);
        this.handleOnShowAnimation(actionHolderPane);
    }

    // Handler for Button[fx:id="updateCopyConfirmButton"] onAction
    /**
     *
     * @param event
     */
    public void handleUpdateCopyConfirmButtonAction(ActionEvent event) {
        try {
            String copyID = this.tempCopyID;
            String location = updateCopyLocation.getText();
            updateMgr.updateCopy(copyID, location);
            this.displaySuccess("Updated", "Copy information has successfully been updated");
            this.clearUpdateCopyFields();
        } catch (SQLException | ClassNotFoundException ex) {
            this.displayWarning("Error", ex.getMessage());
        } catch (Exception ex) {
            this.displayWarning("Error", ex.getMessage());
        } 
    }

    // Handler for Button[fx:id="updateCopyDeleteButton"] onAction
    /**
     *
     * @param event
     */
    public void handleUpdateCopyDeleteButtonAction(ActionEvent event) {
        confirmHeader.setText("Confirm delete action");
        String text = "are you sure you want to update this copy?";
        confirmText.setText(text);
        confirmPane.setVisible(true);
        maskPane.setVisible(true);
        this.handleOnShowAnimation(confirmMessageHolderPane);
    }
    
    private void deleteCopy(){
        try {
            String copyID = this.tempCopyID;
            updateMgr.deleteCopy(copyID);    
        } catch (SQLException | ClassNotFoundException ex) {
            this.displayWarning("Error", ex.getMessage());
        } catch (Exception ex) {
            this.displayWarning("Error", ex.getMessage());
        } 
    }

    // Handler for Button[fx:id="updateItemButton"] onAction
    /**
     *
     * @param event
     */
    public void handleUpdateItemButtonAction(ActionEvent event) {
        //delete all panes on actionHolderPane and add the updateItemPane
        setAllChildrenInvisible();
        updateItemPane.setVisible(true);
        this.handleOnShowAnimation(actionHolderPane);
    }

    // Handler for Button[fx:id="updateItemConfirmButton"] onAction
    /**
     *
     * @param event
     */
    public void handleUpdateItemConfirmButtonAction(ActionEvent event) {
        try{
            String itemID = this.tempItemID;
            String title = updateItemTitle.getText();
            String author = updateItemAuthor.getText();
            GregorianCalendar publishDate = parseDate(updateItemPublishDate.getText());
            String description = updateItemDescription.getText();
            String ISBN = updateItemISBN.getText();
            String genre = updateItemGenre.getText();
            if (title.length()>0 && author.length()>0 && description.length()>0 && ISBN.length()>0 && genre.length()>0){                
                updateMgr.updateBook(itemID, title, author, publishDate, description, ISBN, genre);
                this.displaySuccess("Updated", "Item information has successfully been updated");
                this.clearUpdateItemFields();
            }
            else{                    
                displayWarning("Item Information incomplete", "Please fill in the necessary fields");
            }            
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            displayWarning("Sorry","Date format is wrong\n" + e.getMessage());
        }
        catch(Exception e){
            displayWarning("Sorry","One of the fields is wrong:\n" + e.getMessage());
        }
    }

    // Handler for Button[fx:id="updateItemDeleteButton"] onAction
    /**
     *
     * @param event
     */
    public void handleUpdateItemDeleteButtonAction(ActionEvent event) {
        confirmHeader.setText("Confirm delete action");
        String text = "are you sure you want to update this item?";
        confirmText.setText(text);
        confirmPane.setVisible(true);
        maskPane.setVisible(true);
        this.handleOnShowAnimation(confirmMessageHolderPane);
    }
    
    private void deleteItem(){
        try {
            String itemID = this.tempItemID;
            updateMgr.deleteBook(itemID);
        } catch (ItemNotFoundException e) {
            this.displayWarning("Item ID Error", e.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            this.displayWarning("Sorry", e.getMessage());
        } catch (Exception ex) {
            this.displayWarning("Error", ex.getMessage());
        } 
    }
        
    /**
     *
     * @param modelController
     */
    @Override
    public void setInitialData(ModelController modelController) {
        this.setModelController(modelController);
        //set the current member to borrow
        updateMgr.setCurrentLibrarian((Librarian)modelController.getUser());
        //set the book info pane to be visible
        if(bookType.isSelected()){
            bookInfoPane.setVisible(true);
        }
    }
    
    // Handler for Button[fx:id="noConfirm"] onAction
    public void handleNoConfirmButtonAction(ActionEvent event) {
        confirmPane.setVisible(false);
        maskPane.setVisible(false);
    }

    // Handler for Button[fx:id="yesConfirm"] onAction
    public void handleYesConfirmButtonAction(ActionEvent event) {
        if (updateItemPane.isVisible()){
            deleteItem();
            this.clearUpdateItemFields();
        }
        else if(updateCopyPane.isVisible()){
            deleteCopy();
            this.clearUpdateCopyFields();
        }
        maskPane.setVisible(false);
        confirmPane.setVisible(false);
    }

    /**
     *
     */
    @Override
    public void playOnShowAnimation() {
        this.handleOnShowAnimation(actionHolderPane);
        this.handleOnShowAnimation(optionPane);
    }
    
    private GregorianCalendar parseDate(String dateString) throws ArrayIndexOutOfBoundsException, NumberFormatException{
        String[] dateElement = dateString.split("-");

        int year = Integer.parseInt(dateElement[0]);
        int month = Integer.parseInt(dateElement[1]);
        int date = Integer.parseInt(dateElement[2]);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setLenient(false);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, --month);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        return calendar;
    }
    
    private void setAllChildrenInvisible(){
        ObservableList<Node> panes = actionHolderPane.getChildren();
        for (int i=0; i<panes.size(); i++){
            panes.get(i).setVisible(false);
        }
    }
    
    private String formatDateString(Calendar date){
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        month++;
        int dateOfMonth = date.get(Calendar.DAY_OF_MONTH);
        return (year + "-" + month + "-" + dateOfMonth);
    }
    
    private void clearNewItemFields(){
        newItemTitle.setText("");
        newItemAuthor.setText("");
        newItemPublishDate.setText("");
        newItemDescription.setText("");
        newBookISBN.setText("");
        newBookGenre.setText("");
    }
    
    private void clearUpdateItemFields(){
        updateItemItemID.setText("");
        updateItemDescription.setText("");
        updateItemPublishDate.setText("");
        updateItemTitle.setText("");
        updateItemAuthor.setText("");
        updateItemISBN.setText("");
        updateItemGenre.setText("");
        updateItemInfoPane.setDisable(true);
    }
    
    private void clearNewCopyFields(){
        newCopyItemID.setText("");
        newCopyLocation.setText("");
    }
    
    private void clearUpdateCopyFields(){
        updateCopyID.setText("");
        updateCopyLocation.setText("");
        updateCopyInfoPane.setDisable(true);
    }
    
}

