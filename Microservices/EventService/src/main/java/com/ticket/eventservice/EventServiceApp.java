package com.ticket.eventservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EventServiceApp {

	public static void main(String[] args) {


		log.info("EventServiceApp::main");
		SpringApplication.run(EventServiceApp.class, args);
	}

}