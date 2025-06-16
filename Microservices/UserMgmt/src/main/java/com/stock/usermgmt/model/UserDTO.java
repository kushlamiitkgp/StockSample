package com.stock.usermgmt.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String username;
    private String role;
}
