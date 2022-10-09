/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;

/**
 *
 * @author 14686
 */
public class AccountService {
      public User login(String userIn, String passIN)
    {
        String usernameArr[] = {"abe", "barb"};
        String passwordIn = "password";
        if ((userIn.equals(usernameArr[0]) || userIn.equals(usernameArr[1])) 
                && passIN.equals(passwordIn))
        {
            User newUser = new User(userIn,null);
            return newUser;
        }else{
        return null;}
    }
}
