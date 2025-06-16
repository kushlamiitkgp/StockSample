package com.auth.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private UsersRole role;
    private String email;
}

