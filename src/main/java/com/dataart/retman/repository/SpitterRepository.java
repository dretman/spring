package com.dataart.retman.repository;

import com.dataart.retman.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    List<Spitter> findByUsername(String username);

    long count();

    Spitter save(Spitter spitter);

    List<Spitter> findByEmailLike(String s);

    @Query("select s from Spitter s where s.email like '%@gmail.com'")
    List<Spitter> findAllGmailSpitters();
}
