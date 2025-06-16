package com.ticket.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class SeatAvailabilityService { //EventCacheService
    private static final String SEAT_KEY_PREFIX = "event:seats:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void cacheSeats(Long eventId, int seats) {
        redisTemplate.opsForValue().set(SEAT_KEY_PREFIX + eventId, seats, Duration.ofSeconds(30));
    }

    public Integer getCachedSeats(Long eventId) {
        Object val = redisTemplate.opsForValue().get(SEAT_KEY_PREFIX + eventId);
        return val != null ? (Integer) val : null;
    }

    public void invalidateCache(Long eventId) {
        redisTemplate.delete(SEAT_KEY_PREFIX + eventId);
    }
}