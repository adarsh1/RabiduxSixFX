/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import exception.IncorrectPasswordException;
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
    private ModelController mainController;
    
    public LoginMgr(){
        //default longinMgr constructor
        mainController = new ModelController();
    }
    
    //create a user based on userName entered. If no such user exists, throw exception
    public void createUser(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SQLException, ClassNotFoundException{
        setUser(User.getUser(username, password));
        //if no exception was thrown, user can be set in main controller
        mainController.setUser(user);
    }

    /**
     * @return the mainController
     */
    public ModelController getMainController() {
        return mainController;
    }

    /**
     * @param mainController the mainController to set
     */
    public void setMainController(ModelController mainController) {
        this.mainController = mainController;
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
