package com.stockmgmt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StockMgmtApplication {

	public static void main(String[] args) {

		log.info("StockMgmtApplication::main");
		SpringApplication.run(StockMgmtApplication.class, args);
	}

}
