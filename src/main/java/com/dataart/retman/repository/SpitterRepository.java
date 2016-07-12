package com.dataart.retman.repository;

import com.dataart.retman.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    Spitter findByUsername(String username);
}
