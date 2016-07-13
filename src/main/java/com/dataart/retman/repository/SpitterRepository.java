package com.dataart.retman.repository;

import com.dataart.retman.domain.Spitter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {
    List<Spitter> findByUsername(String username);

    long count();

    @CachePut(value = "spittleCache", key = "#result.id")
    Spitter save(Spitter spitter);

    List<Spitter> findByEmailLike(String s);

    @Cacheable(value = "spittleCache")
    @Query("select s from Spitter s where s.email like '%@gmail.com'")
    List<Spitter> findAllGmailSpitters();

    @Transactional
    @CacheEvict(value = "spittleCache", beforeInvocation = false)
    int deleteById(long id);
}
