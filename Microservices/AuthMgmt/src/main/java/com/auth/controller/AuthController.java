package com.auth.controller;


import com.auth.model.AuthRequest;
import com.auth.model.AuthenticationResponse;
import com.auth.model.Users;
import com.auth.repository.UserRepository;
import com.auth.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthRequest authRequest) {
        System.out.println("login request came  - "+authRequest.toString());
        AuthenticationResponse response = authenticationService.authenticate(authRequest);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users) {
        System.out.println("register request came -"+users.toString());
        if (userRepo.findByUsername(users.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists.");
        }

        // Hash password and assign default role
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRole("ROLE_USER");
        Users.builder().build();
        userRepo.save(users);

        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");

        try {
            if (authenticationService.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Token Valid");
            }
            return ResponseEntity.ok("Token is valid " );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
}
