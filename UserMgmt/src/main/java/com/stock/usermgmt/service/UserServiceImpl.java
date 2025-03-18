package com.stock.usermgmt.service;

import com.stock.usermgmt.database.Users;
import com.stock.usermgmt.database.UserRepository;
import com.stock.usermgmt.feignclient.AuthFeignClient;
import com.stock.usermgmt.feignclient.AuthRequest;
import com.stock.usermgmt.feignclient.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public Optional<Users> getUser(String name){
        return userRepository.findByUsername(name);
    }

    public void saveUser(Users abc){
        userRepository.save(abc);
    }

    public void editUser(Users abc) {
        userRepository.save(abc);
    }


    @Autowired
    private AuthFeignClient authClient;

    public String login(String username, String password) {
        AuthRequest request = new AuthRequest(username, password);
        ResponseEntity<AuthenticationResponse> response = authClient.authenticate(request);
        return response.getBody().getToken(); // JWT token
    }

    public boolean validateToken(String token) {
        try {
            ResponseEntity<String> response = authClient.validateToken("Bearer " + token);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }
}
