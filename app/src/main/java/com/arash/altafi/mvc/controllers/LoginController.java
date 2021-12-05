package com.arash.altafi.mvc.controllers;

import com.arash.altafi.mvc.models.User;
import com.arash.altafi.mvc.views.ILoginView;

public class LoginController implements ILoginController {

    private ILoginView view;

    public LoginController(ILoginView view) {
        this.view = view;
    }

    @Override
    public void onLogin(String username, String password) {
        User user = new User(username , password);
        switch (user.inValid()) {
            case 0 :
                view.onLoginError("Please enter Email");
                break;
            case 1 :
                view.onLoginError("Please enter A valid Email");
                break;
            case 2 :
                view.onLoginError("Please enter Password");
                break;
            case 3 :
                view.onLoginError("Please enter Password greater the 6 char");
                break;
            default :
                view.onLoginSuccess("login Successful");
                return;
        }
    }

}
