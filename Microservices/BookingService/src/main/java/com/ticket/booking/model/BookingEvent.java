package com.ticket.booking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "booking_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEvent {
    @Id
    private String id;
    private Long eventId;
    private String type; // BOOKED / CANCELLED
    private LocalDateTime timestamp;
    private String user;
}