package com.auth.feignrest;

import com.auth.model.LoginRequest;
import com.auth.model.RegisterRequest;
import com.auth.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service", url = "http://user-service:8082/users")
public interface UserServiceClient {

    @PostMapping("/create")
    boolean createUser(RegisterRequest req);

    @PostMapping("/validate")
    UserDTO validateUser(LoginRequest req);
}
