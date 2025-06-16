package com.ticket.booking.service;

import com.ticket.booking.model.BookingEvent;
import com.ticket.booking.repository.BookingEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BookingEventProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private BookingEventRepository mongoRepo;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void sendEvent(String topic, String message, Long eventId, String type, String user) {
        kafkaTemplate.send(topic, message);
        mongoRepo.save(new BookingEvent(null, eventId, type, LocalDateTime.now(), user));

        if ("BOOKED".equalsIgnoreCase(type) || "CANCELLED".equalsIgnoreCase(type)) {
            redisTemplate.delete("event:seats:" + eventId); // Invalidate cache
        }

        System.out.println("sent to kafka + saved into mongoDb");
    }


}