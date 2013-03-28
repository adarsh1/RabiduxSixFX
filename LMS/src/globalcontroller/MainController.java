/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globalcontroller;

import usermanagement.User;

/**
 *
 * @author Allen
 */
public class MainController {
    
    //indicate whether a barcode reader is used
    private boolean isUsingBarcodeReader;
    //current user
    private User user;
    
    //constructor
    public MainController(){
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
