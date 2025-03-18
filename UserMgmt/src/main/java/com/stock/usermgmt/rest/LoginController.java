package com.stock.usermgmt.rest;

import com.stock.usermgmt.database.LoginData;
import com.stock.usermgmt.service.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users11")
public class LoginController {

    @Autowired
    LoginHandler loginHandler;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginData loginData) {

        if (loginHandler.login(loginData)) {
            // if login successful then send request for token generation & send back token
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


//    @PostMapping("/register") //signup
    @RequestMapping(value = {"/signup", "/register"}, method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestBody LoginData signupData) {

        if(loginHandler.signup(signupData) == false){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Already username exist");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Signup successful");
    }
}
