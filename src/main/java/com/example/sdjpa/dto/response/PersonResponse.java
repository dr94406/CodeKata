package com.example.sdjpa.dto.response;

import com.example.sdjpa.entity.Person;
import lombok.Builder;

@Builder
public record PersonResponse(Long id, String name){

    public static PersonResponse from (Person person) {
        return PersonResponse.builder().
                id(person.getId()).
                name(person.getName()).build();
    }
}
