package com.codekata.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(
        name ="Member.findByUsername",
        query = "select m from Member m where m.username = :username")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
}
