package com.auth.controller;


import com.auth.config.JwtUtils;
import com.auth.feignrest.UserServiceClient;
import com.auth.model.JwtResponse;
import com.auth.model.LoginRequest;
import com.auth.model.RegisterRequest;
import com.auth.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private UserServiceClient userServiceClient;
    @Autowired private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("login request came  - "+loginRequest.toString());

        UserDTO user = userServiceClient.validateUser(loginRequest);
        if(user==null)
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        String token = jwtUtils.generateToken(user.getUsername(), user.getRole());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Validated RegisterRequest registerRequest) {
        System.out.println("register request came -"+ registerRequest.toString());

        boolean created = userServiceClient.createUser(registerRequest);
        if (!created)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User exists");

        return ResponseEntity.ok("User registered successfully.");
    }

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("AuthService redirect from APIGW Check successful");
    }

}
