package com.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/dontuse")
public class ApiController {

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("You have access to the protected endpoint!");
    }

    @GetMapping("/userinfo")
    public ResponseEntity<String> getUserInfo(@AuthenticationPrincipal Jwt jwt) {
        String username = jwt.getSubject();
        List<String> roles = jwt.getClaimAsStringList("roles");

        return ResponseEntity.ok("Username: " + username + ", Roles: " + roles);
    }

    @GetMapping("/me")
    public ResponseEntity<String> getMe(Principal principal) {
        return ResponseEntity.ok("Hello, " + principal.getName());
    }
}
