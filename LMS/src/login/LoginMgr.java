/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import exception.IncorrectPasswordException;
import exception.InvalidUserTypeException;
import exception.NullResultException;
import exception.UserNotFoundException;
import globalcontrol.ModelController;
import java.sql.SQLException;
import usermanagement.User;

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
     */
    public void createUser(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SQLException, ClassNotFoundException, NullResultException, InvalidUserTypeException{
        setUser(User.getUser(username, password));
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
