package com.stock.usermgmt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.stock.usermgmt.feignclient")
@Slf4j
public class UsermgmtApplication {

	public static void main(String[] args) {


		log.info("UsermgmtApplication-> Handles registration and role storage.\n");
		SpringApplication.run(UsermgmtApplication.class, args);
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}