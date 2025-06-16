package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.auth.feignrest")
public class AuthMgmtApplication {

	public static void main(String[] args) {

		System.out.println("AuthMgmtApplication -> for Handling Authentication ONLY \n" +
				"1. Registration & Authentication\n 2. Calls UserService to validate password.\n 3. On success, issues JWT - Token generation");
		SpringApplication.run(AuthMgmtApplication.class, args);
	}

}
