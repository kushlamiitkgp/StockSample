package com.ticket.booking.service;

import com.ticket.booking.model.Booking;
import com.ticket.booking.model.Event;
import com.ticket.booking.model.EventType;
import com.ticket.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repo;

    // used to make call to Client(Event Provider) - for proper seat booking
    @Autowired
    private EventClient eventClient;

    @Autowired
    private BookingEventProducer bookingEventProducer;

    @Transactional
    public boolean tryBooking(Long eventId, String user) {

        System.out.println("tryingBooking - "+eventId+":"+user);
        Event event = eventClient.getEventById(eventId);
        if(event == null) return false;

        boolean seatAvailable = eventClient.decrementSeat(eventId);
        if (seatAvailable) {
            Booking booking = Booking.builder().bookingTime( LocalDateTime.now()).eventId(eventId).username(user).build();
            repo.save(booking);

            System.out.println("booking saved , now MQ sendingg- "+booking.toString());
            bookingEventProducer.sendEvent("booking-events", EventType.MOVIE.name() , eventId, "new-booking",user);//booking-events", groupId = "event-group
            return true;
        }
        return false;
    }

}
