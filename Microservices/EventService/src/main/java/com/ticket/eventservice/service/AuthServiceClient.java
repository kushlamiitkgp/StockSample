package com.ticket.eventservice.service;

import com.ticket.eventservice.model.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "http://authservice:9000")
public interface AuthServiceClient {
    @PostMapping("/auth/validate")
    UserDTO validateToken(@RequestBody String token);
}