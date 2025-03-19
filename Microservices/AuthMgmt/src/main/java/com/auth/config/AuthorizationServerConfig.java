//package com.auth.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//
//
//import java.util.UUID;
//
//@Configuration
//public class AuthorizationServerConfig {
//
//    @Bean
//    public RegisteredClientRepository registeredClientRepository() {
//        RegisteredClient client = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("client-id")
//                .clientSecret("{noop}client-secret")
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .scope("read")
//                .scope("write")
//                .redirectUri("http://localhost:8080/login/oauth2/code/custom")
//                .build();
//
//        return new InMemoryRegisteredClientRepository(client);
//    }
//}
