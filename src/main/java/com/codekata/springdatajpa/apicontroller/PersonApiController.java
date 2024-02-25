package com.codekata.springdatajpa.apicontroller;

import com.codekata.springdatajpa.entity.Person;
import com.codekata.springdatajpa.dto.response.CommonResponse;
import com.codekata.springdatajpa.dto.response.PersonResponse;
import com.codekata.springdatajpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class PersonApiController {

    private final PersonService personService;

    @PostMapping(path = "api/v1/jpa", produces = APPLICATION_JSON_VALUE)
    public PersonResponse save(@RequestBody Person person) {
         return personService.save(person);

    }

    @GetMapping(path = "/api/v1/jpa/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Person> findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @GetMapping(path = "/api/v1/jpa", produces = APPLICATION_JSON_VALUE)
    public List<PersonResponse> findAll() {
        return personService.findAll();
    }

    @GetMapping(path = "/api/v1/jpa/count", produces = APPLICATION_JSON_VALUE)
    public Long count() {
        return personService.count();
    }

    @DeleteMapping(path = "/api/v1/jpa/{id}", produces = APPLICATION_JSON_VALUE)
    public CommonResponse delete(@PathVariable ("id") Long id) {
         personService.deleteById(id);
         return CommonResponse.commonResponse;
    }

    @GetMapping(path = "/api/v1/jpa/existsBy/{id}", produces = APPLICATION_JSON_VALUE)
    public Boolean existsById(@PathVariable ("id") Long existsById) {
        return personService.existsById(existsById);
    }
}
