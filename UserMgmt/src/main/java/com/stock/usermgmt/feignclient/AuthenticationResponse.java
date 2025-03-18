package com.stock.usermgmt.feignclient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable {
    private String token;
//
//    public AuthenticationResponse(String token) {
//        this.token = token;
//    }
}