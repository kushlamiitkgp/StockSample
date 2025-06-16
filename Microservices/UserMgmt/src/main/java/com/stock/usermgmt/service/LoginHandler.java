package com.stock.usermgmt.service;

import com.stock.usermgmt.database.Users;
import com.stock.usermgmt.model.LoginRequest;
import com.stock.usermgmt.model.UserDTO;
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

    public UserDTO login(LoginRequest loginData){

        Users user = userService.getUser(loginData.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found : "+loginData.getUsername()));

        boolean correctPassword = passwordService.matchPassword(loginData.getPassword(), user.getPassword());
        if(!correctPassword)
            return null;
        return UserDTO.builder().role(user.getRole().name()).username(user.getUsername()).build();
    }

}
