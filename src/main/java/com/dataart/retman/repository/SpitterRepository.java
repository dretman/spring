package com.dataart.retman.repository;

import com.dataart.retman.domain.Spitter;

public interface SpitterRepository {
    void addSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    void saveSpitter(Spitter spitter);

    void deleteSpitter(Spitter spitter);

    boolean contains(Spitter spitter);
}
