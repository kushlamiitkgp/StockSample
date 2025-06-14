package com.ticket.booking.repository;

import com.ticket.booking.model.BookingEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingEventRepository extends MongoRepository<BookingEvent, String> {}
