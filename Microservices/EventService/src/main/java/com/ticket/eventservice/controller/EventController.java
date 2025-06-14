package com.ticket.eventservice.controller;

import com.ticket.eventservice.model.Event;
import com.ticket.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository repo;

    @PostMapping
    public Event create(@RequestBody Event e) {
        //todo check if duplicate event exist - then dont save. just update.. check the logic
        System.out.println("create event - "+e.toString());
        return repo.save(e);
    }

    @GetMapping(value = "/all")
    public List<Event> list() {
        System.out.println("get All Events");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Event get(@PathVariable Long id) {
        System.out.println("get Event by Id : "+id);
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/{id}/decrement")
    public boolean decrementSeat(@PathVariable Long id) {
        System.out.println("booking seat - so decrementSeat");
        Event event = repo.findById(id).orElseThrow();
        if (event.getAvailableSeats() > 0) {
            event.setAvailableSeats(event.getAvailableSeats() - 1);
            repo.save(event);
            return true;
        }
        return false;
    }

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("Event G/W Check successful");
    }
}