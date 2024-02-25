package com.example.sdjpa.dto.request;

import com.example.sdjpa.entity.Person;
import lombok.Builder;

@Builder
public record PersonSave(Long id, String name) {

    public static PersonSave from (Person person) {
        return PersonSave.builder().name(person.getName()).build();
    }
}
