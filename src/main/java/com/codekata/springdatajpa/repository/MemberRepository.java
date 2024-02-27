package com.codekata.springdatajpa.repository;

import com.codekata.springdatajpa.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {


    @Query("select m from Member m where m.username = :name")
    Member findByUsername(@Param("name") String username);

    @Modifying
    @Query("update Product p set p.price = p.price * 1.1 where p.stockAmount < :stockAmount")
    int bulkPriceUp (@Param("stockAmount") String stockAmount);

    List<Member> findByName(String name); // 컬렉션

    Member findByEmail (String email); // 단건

    Page<Member> findByNameStartingWith(String name, Pageable pageable);

}
