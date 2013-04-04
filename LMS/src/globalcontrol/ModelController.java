/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globalcontrol;

import usermanagement.User;

/**
 *
 * @author Allen
 */
public class ModelController {
    
    //indicate whether a barcode reader is used
    private boolean isUsingBarcodeReader;
    //current user
    private User user;
    
    //link to the bookcover images
    public static final String BOOKCOVER_IMAGE_PATH = "/resources/images/bookcover/";
    public static final String FXML_PATH = "/resources/xml/";
    public static final String IMAGE_PATH = "/resources/images/";
    public static final String JMETRO_PATH = "/resources/JMetro/";
    
    //constructor
    public ModelController(){
    }

    /**
     * @return the isUsingBarcodeReader
     */
    public boolean isIsUsingBarcodeReader() {
        return isUsingBarcodeReader;
    }

    /**
     * @param isUsingBarcodeReader the isUsingBarcodeReader to set
     */
    public void setIsUsingBarcodeReader(boolean isUsingBarcodeReader) {
        this.isUsingBarcodeReader = isUsingBarcodeReader;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
   
    
    
}
