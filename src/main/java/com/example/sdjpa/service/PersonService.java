package com.example.sdjpa.service;

import com.example.sdjpa.dto.response.PersonResponse;
import com.example.sdjpa.entity.Person;
import com.example.sdjpa.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    // 엔티티를 저장한다. <S extend T>
    @Transactional
    public PersonResponse save(Person person) {
        Person personSave = personRepository.save(person);
        return PersonResponse.from(personSave);
    }

    // ID로 식별 엔티티를 반환한다. Optional<T>
    @Transactional(readOnly = true)
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(personRepository.findById(id).
                orElseThrow(NoSuchElementException::new));
    }

    @Transactional(readOnly = true)
    // 모든 엔티티를 반환한다. Iterable<T>
    public List<PersonResponse> findAll() {
        return personRepository.findAll().
                stream().map(Person::from).
                toList();
    }

    @Transactional(readOnly = true)
    // 엔티티 개수를 반환한다.
    public Long count() {
        return personRepository.count();
    }

    @Transactional
    public void deleteById(Long id) {
         personRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return personRepository.existsById(id);
    }
}
