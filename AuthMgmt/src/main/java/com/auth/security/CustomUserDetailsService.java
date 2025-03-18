package com.auth.security;

import com.auth.model.Users;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                users.getUsername(),
                users.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(users.getRole()))
        );
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Load user from database (Example: Hardcoded user)
//        if (!"testuser".equals(username)) {
//            throw new UsernameNotFoundException("User not found: " + username);
//        }
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(username)
//                .password(StaticUtils.testPwd)
////                .password("$2a$10$QKzzhZl1hmtbCpL9Od5ftOJdG0TgEoUMayK4C0vYz1i/YrbV6HvU6") // "testpassword" (BCrypt encoded)
//                .roles("USER")
//                .build();
//    }
}
