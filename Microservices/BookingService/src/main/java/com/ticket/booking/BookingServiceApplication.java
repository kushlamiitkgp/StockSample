package com.ticket.booking;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class BookingServiceApplication {

	public static void main(String[] args) {


		log.info("Booking::main");
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}