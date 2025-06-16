package com.stock.usermgmt.database;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Max(24)
    private String email;
}
