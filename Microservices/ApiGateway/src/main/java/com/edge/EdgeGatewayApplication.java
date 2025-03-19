package com.edge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EdgeGatewayApplication {

	public static void main(String[] args) {

		log.info("EdgeGatewayApplication::main");
		SpringApplication.run(EdgeGatewayApplication.class, args);
	}

}
