package com.codekata.springdatajpa.repository;

import com.codekata.springdatajpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person save(Person person);

    Optional<Person> findById(long id);

    List<Person> findAll();

    long count();
}
