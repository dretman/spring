package com.dataart.retman.repository;

import com.dataart.retman.domain.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
