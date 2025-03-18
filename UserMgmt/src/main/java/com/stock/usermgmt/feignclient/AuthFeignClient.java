package com.stock.usermgmt.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "${auth.service.url}")
public interface AuthFeignClient {

    @PostMapping("/auth/login")
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthRequest request);

    @PostMapping("/auth/validate")
    ResponseEntity<String> validateToken(@RequestHeader("Authorization") String token);
}
