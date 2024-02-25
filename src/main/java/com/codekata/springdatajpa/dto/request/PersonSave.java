package com.codekata.springdatajpa.dto.request;

import com.codekata.springdatajpa.entity.Person;
import lombok.Builder;

@Builder
public record PersonSave(Long id, String name) {

    public static PersonSave from (Person person) {
        return PersonSave.builder().name(person.getName()).build();
    }
}
