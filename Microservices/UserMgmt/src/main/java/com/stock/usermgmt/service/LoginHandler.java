package com.stock.usermgmt.service;

import com.stock.usermgmt.database.LoginData;
import com.stock.usermgmt.database.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler {
    private final PasswordService passwordService;
    private final UserService userService;

    @Autowired
    public LoginHandler(PasswordService passwordService, UserService userService) {
        this.passwordService = passwordService;
        this.userService = userService;
    }

    public boolean login(LoginData loginData){
        Users users = userService.getUser(loginData.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found : "+loginData.getUsername()));

        return passwordService.matchPassword(loginData.getPassword(), users.getPassword());
    }

    public boolean signup(LoginData signupData){
        String username = signupData.getUsername();
        String password =  signupData.getPassword();
        Users users = userService.getUser(username)
                .orElse(null);

        if (null != users) {
            return false;
        }

        // Encrypt the password using BCrypt
        String encryptedPassword = passwordService.enCryptPwd(password);

        // Create a new User and set the username and encrypted password
        users = Users.builder().username(username).password(encryptedPassword).level(1).role("User")
                .email(username.concat("@gmail.com")).build();

        userService.saveUser(users);

        return true;

    }
}
