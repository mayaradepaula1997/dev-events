package com.eventosdev.api.domain.event;

public record EventRequesDTO(String title, String description, Long date, String city,
                             String state, Boolean remote, String eventUrl){
}

