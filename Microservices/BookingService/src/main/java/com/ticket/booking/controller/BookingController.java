package com.ticket.booking.controller;

import com.ticket.booking.service.BookingEventProducer;
import com.ticket.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public ResponseEntity<String> book(@RequestParam Long eventId, @RequestParam String user) {
        boolean result = service.tryBooking(eventId, user);
        return ResponseEntity.ok(result ? "Booked" : "Failed to book");
    }


    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("Booking Check successful");
    }
}
