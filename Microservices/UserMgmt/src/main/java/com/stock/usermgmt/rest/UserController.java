package com.stock.usermgmt.rest;

import com.stock.usermgmt.feignclient.AuthRequest;
import com.stock.usermgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        System.out.println("login request : "+request.toString());
        String token = userService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam("token") String token) {
        boolean isValid = userService.validateToken(token);
        if (isValid) {
            return ResponseEntity.ok("Token valid");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token invalid");
        }
    }
}
