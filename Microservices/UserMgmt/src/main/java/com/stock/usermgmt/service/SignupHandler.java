package com.stock.usermgmt.service;

import com.stock.usermgmt.database.Users;
import com.stock.usermgmt.model.RegisterRequest;
import com.stock.usermgmt.model.UsersRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SignupHandler {
    private final PasswordService passwordService;
    private final UserService userService;

    @Autowired
    public SignupHandler(PasswordService passwordService, UserService userService) {
        this.passwordService = passwordService;
        this.userService = userService;
    }

    public boolean signup(RegisterRequest signupData){
        String username = signupData.getUsername();
        String password =  signupData.getPassword();
        String mail =  signupData.getEmail();

        Users users = userService.getUser(username)
                .orElse(null);

        if (null != users) {
            return false;
        }

        // Encrypt the password using BCrypt
        String encryptedPassword = passwordService.enCryptPwd(password);
        UsersRole role = UsersRole.ROLE_ADMIN.equals(signupData.getRole()) ? UsersRole.ROLE_ADMIN: UsersRole.ROLE_USER;

        // Create a new User and set the username and encrypted password
        users = Users.builder()
                .username(username)
                .password(encryptedPassword)
                .level(1)
                .role(role)
                .email(mail)
                .created_at(LocalDateTime.now())
                .is_verified(true) // todo OTP BASED will do later
                .build();

        userService.saveUser(users);

        return true;
    }
}
