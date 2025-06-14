package com.ticket.booking.service;

import com.ticket.booking.model.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "eventservice", url = "http://host.docker.internal:9001")
public interface EventClient {

    @PostMapping("/events/{id}/decrement")
    boolean decrementSeat(@PathVariable("id") Long id);

    @GetMapping("/events/{id}")
    Event getEventById(@PathVariable("id") Long id);
}