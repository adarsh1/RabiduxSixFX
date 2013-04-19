/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import cataloguemanagement.*;
import exception.CopyNotFoundException;
import exception.IncorrectPasswordException;
import exception.InvalidUserTypeException;
import exception.ItemNotFoundException;
import exception.NullResultException;
import exception.UserNotFoundException;
import globalcontrol.ModelController;
import java.sql.SQLException;
import java.util.ArrayList;
import usermanagement.*;

/**
 *
 * @author Allen
 */
public class LoginMgr {
    
    private User user;
    private ModelController modelController;
    
    /**
     *
     */
    public LoginMgr(){
        //default longinMgr constructor
        modelController = new ModelController();
    }
    
    //create a user based on userName entered. If no such user exists, throw exception
    /**
     *
     * @param username
     * @param password
     * @throws UserNotFoundException
     * @throws IncorrectPasswordException
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NullResultException
     * @throws InvalidUserTypeException  
     */
    public void createUser(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SQLException, ClassNotFoundException, NullResultException, InvalidUserTypeException, CopyNotFoundException, ItemNotFoundException{
        
        ArrayList<CurrentHolding> holdings;
        User newUser = User.getUser(username, password);
        
        setUser(newUser);
        
        if (newUser.getUsertype() != User.LIBRARIAN) {
            
            holdings = ((Member)newUser).getCurrentHoldingItems();
            
            for (int i = 0; i < holdings.size(); i++) {
                
                if (holdings.get(i).getCopy().isOverdued()) {
                    
                    newUser.suspend();
                    break;
                    
                }
                
            }
            
        }
        
        //if no exception was thrown, user can be set in main controller
        modelController.setUser(user);
    }

    /**
     * @return the modelController
     */
    public ModelController getModelController() {
        return modelController;
    }

    /**
     * @param modelController the modelController to set
     */
    public void setModelController(ModelController modelController) {
        this.modelController = modelController;
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
