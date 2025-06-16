package com.ticket.eventservice.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class TokenValidationFilter extends OncePerRequestFilter {

    @Autowired
    private AuthServiceClient authClient;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
            return;
        }

        try {
            String jwt = token.substring(7);
            AuthUserDetails userDetails = authClient.validateToken(jwt);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null,
                            userDetails.getRoles().stream().map(SimpleGrantedAuthority::new).toList());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token validation failed");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
