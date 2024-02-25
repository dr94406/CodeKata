package com.codekata.springdatajpa.dto.response;

import com.codekata.springdatajpa.entity.Person;
import lombok.Builder;

@Builder
public record PersonResponse(Long id, String name){

    public static PersonResponse from (Person person) {
        return PersonResponse.builder().
                id(person.getId()).
                name(person.getName()).build();
    }
}
