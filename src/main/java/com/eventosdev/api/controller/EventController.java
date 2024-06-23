package com.eventosdev.api.controller;


import com.eventosdev.api.domain.event.Event;
import com.eventosdev.api.domain.event.EventRequesDTO;
import com.eventosdev.api.domain.event.EventResponseDTO;
import com.eventosdev.api.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/event")

public class EventController {

   @Autowired
    private EventService eventService;



 @PostMapping
 public ResponseEntity <Event> create(@RequestBody EventRequesDTO body){
     Event newEvent = eventService.createEvent(body);
     return ResponseEntity.ok(newEvent);
 }

@GetMapping //retorna eventos por paginação
 public ResponseEntity<List<EventResponseDTO>> getEvents (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
     List<EventResponseDTO> allEvents = eventService.getEvents(page, size);
     return ResponseEntity.ok(allEvents);
 }




}

