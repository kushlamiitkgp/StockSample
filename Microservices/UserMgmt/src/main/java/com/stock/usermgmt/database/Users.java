package com.stock.usermgmt.database;

import com.stock.usermgmt.model.UsersRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;  // Store encrypted password

    private String email;


    @Enumerated(EnumType.STRING)
    private UsersRole role;

    private int level; // Authorization level for stocks

    private Boolean is_verified;
    private LocalDateTime created_at;

}