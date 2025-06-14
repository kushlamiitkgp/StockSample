package com.ticket.booking.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Event {
    private Long id;
    private String name;
    private LocalDate date;
    private int totalSeats;
    private int availableSeats;
}