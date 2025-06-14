package com.ticket.eventservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BookingEventListener {

    @KafkaListener(topics = "booking-events", groupId = "event-group")
    public void listen(String message) {
        System.out.println("[EventService] Received Kafka Message: " + message);
        // Further logic to update internal store or cache can be added here

    }

}