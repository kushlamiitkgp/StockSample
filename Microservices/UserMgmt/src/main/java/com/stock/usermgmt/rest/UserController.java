package com.stock.usermgmt.rest;

import com.stock.usermgmt.model.LoginRequest;
import com.stock.usermgmt.model.RegisterRequest;
import com.stock.usermgmt.model.UserDTO;
import com.stock.usermgmt.service.LoginHandler;
import com.stock.usermgmt.service.SignupHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    LoginHandler loginHandler;
    @Autowired
    SignupHandler signupHandler;

    @PostMapping("/validate")
    public UserDTO validate(@RequestBody LoginRequest req) {
        System.out.println("user login/validation request" + req.toString());
        return loginHandler.login(req);
    }

    @PostMapping("/create")
    public boolean create(@RequestBody RegisterRequest req) {
        System.out.println("user creation/ register request" + req.toString());
        return signupHandler.signup(req);    }


    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("UserService call from APIGW Check successful");
    }

    @GetMapping(value = "/all")
    public ResponseEntity<String> getALLUsers() {
        return ResponseEntity.ok("Users APIGW Check successful");
    }
}

