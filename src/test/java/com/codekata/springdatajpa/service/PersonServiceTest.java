package com.codekata.springdatajpa.service;

import com.codekata.springdatajpa.entity.Person;
import com.codekata.springdatajpa.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Transactional
@SpringBootTest

class PersonServiceTest {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * 데이터를 테스트 하는 것이 익숙해지기 위한 목적으로 작성하는 테스트입니다.
     * 유닛 테스트를 먼저 하는 것이 올바르지만, 학습이 목적이기에 우선은 INTEGRATION 테스트를 먼저 합니다.
     */

    @Test
    @DisplayName("회원 데이터를 저장합니다.")
    void save() {

        // given
        Person person = Person.builder().name("khm").build();

        //when
        Person savePersonData = personRepository.save(person);

        //then
        Assertions.assertEquals(savePersonData.getName(), "khm");
    }

    @Test
    @DisplayName("회원 아이디를 한 건 확인합니다.")
    void findById() {

        //given
        Person person = Person.builder().build();

        //when
        Person savePerson = personRepository.save(person);

        //then
        Assertions.assertEquals(savePerson.getId(), person.getId());
    }


    @Test
    @DisplayName("특정한 이름을 가진 데이터를 저장한 후에 회원 데이터내에 정상적으로 등록되었는지 확인한다.")
    void findAll() {

        //given
        Person person = Person.builder().name("jpa to khm").build();

        //when
        personRepository.save(person);
        List<Person> PersonList = personRepository.findAll();

        //then
        assertTrue(PersonList.stream().anyMatch(s -> s.getName() ==("jpa to khm")));
    }

    @Test
    @DisplayName("회원 데이터를 작성하고 전체 데이터의 카운트와 동일한지 확인한다.")
    void count() {

        //given
        Person khm1 = Person.builder().name("khm1").build();
        Person khm2 = Person.builder().name("khm2").build();

        //when
        personRepository.save(khm1);
        personRepository.save(khm2);

        Long count = personRepository.count();

        //then
        assertEquals(personRepository.findAll().stream().count(), count);
    }

    @Test
    @DisplayName("회원 데이터 한 건 지우기")
    void deleteById() {

        //given
        Person data = Person.builder().name("alice").build();
        Person person = personRepository.save(data);

        //when
        personRepository.deleteById(person.getId());

        //then
        Optional<Person> findByPersonId = personRepository.findById(person.getId());
        assertEquals(Optional.empty(), findByPersonId);

    }

    @Test
    @DisplayName("회원 데이터 존재하는지 확인")
    void existsById() {

        //given
        Person data = Person.builder().name("alice").build();
        Person person = personRepository.save(data);

        //when
        personRepository.existsById(person.getId());
    }
}