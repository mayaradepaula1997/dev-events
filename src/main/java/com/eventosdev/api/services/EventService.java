package com.eventosdev.api.services;

import com.eventosdev.api.domain.event.Event;
import com.eventosdev.api.domain.event.EventRequesDTO;
import com.eventosdev.api.domain.event.EventResponseDTO;
import com.eventosdev.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(EventRequesDTO data){
        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setRemote(data.remote());
        newEvent.setDate(new Date(data.date()));

        eventRepository.save(newEvent);

        return newEvent;
    }

    // Paginação
    public List<EventResponseDTO> getEvents (int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Event> eventsPage = eventRepository.findAll(pageable);


        //Para cada evento, vou passar o EventResponseDTO (mapear)
        return eventsPage.map(event -> new EventResponseDTO(event.getId(),event.getTitle(),event.getDescription(),event.getDate(),"", "",
                event.getRemote(), event.getEventUrl())).stream().toList(); //stream().toList(): tirar do obj de pagina e transformar em uma List


    }




}
