/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import exception.IncorrectPasswordException;
import exception.UserNotFoundException;
import globalcontroller.MainController;
import java.sql.SQLException;
import usermanagement.User;

/**
 *
 * @author Allen
 */
public class LoginMgr {
    
    private User user;
    private MainController MC;
    
    public LoginMgr(){
        //default longinMgr constructor
        MC = new MainController();
    }
    
    //create a user based on userName entered. If no such user exists, throw exception
    public void createUser(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SQLException, ClassNotFoundException{
        setUser(User.getUser(username, password));
        //if no exception was thrown, user can be set in main controller
        MC.setUser(user);
    }

    /**
     * @return the MC
     */
    public MainController getMC() {
        return MC;
    }

    /**
     * @param MC the MC to set
     */
    public void setMC(MainController MC) {
        this.MC = MC;
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
