package com.auth.security;

import com.auth.model.AuthRequest;
import com.auth.model.AuthenticationResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthenticationService(AuthenticationManager authManager, JwtUtil jwtService, CustomUserDetailsService userDetailsService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public AuthenticationResponse authenticate(AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user.getUsername());

        return new AuthenticationResponse(token);
    }

    public boolean validateToken(String token) {
        // Extract username from token
        String username = jwtService.extractUsername(token);

        if (username == null) {
            return false;
        }

        // Load user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Validate token with user details
        return jwtService.validateToken(token, userDetails);
    }

    public String getUserName(String token){
        return jwtService.extractUsername(token);
    }

}
