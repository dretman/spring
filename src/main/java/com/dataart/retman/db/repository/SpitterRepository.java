package com.dataart.retman.db.repository;

import com.dataart.retman.domain.Spitter;

public interface SpitterRepository {
    void addSpitter(Spitter spitter);

    Spitter retrieveSpitterById(long id);
}
