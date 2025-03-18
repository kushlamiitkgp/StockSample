package com.stock.usermgmt.service;

import com.stock.usermgmt.database.Users;
import com.stock.usermgmt.feignclient.AuthRequest;
import com.stock.usermgmt.feignclient.AuthenticationResponse;

import java.util.Optional;

public interface UserService {

    Optional<Users> getUser(String name);

    void saveUser(Users abc);

    void editUser(Users abc);


    String login(String username, String password);

    boolean validateToken(String token);
}
