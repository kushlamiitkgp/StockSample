package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthMgmtApplication {

	public static void main(String[] args) {

		System.out.println("AuthMgmtApplication ->>> main");
		SpringApplication.run(AuthMgmtApplication.class, args);
	}

}
