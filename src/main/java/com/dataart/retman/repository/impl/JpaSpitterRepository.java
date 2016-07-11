package com.dataart.retman.repository.impl;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.repository.SpitterRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSpitter(Spitter spitter) {
        entityManager.persist(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return entityManager.find(Spitter.class, id);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        entityManager.merge(spitter);
    }

    @Override
    public void deleteSpitter(Spitter spitter) {
        entityManager.remove(entityManager.find(Spitter.class, spitter.getId()));
    }

    public boolean contains(Spitter spitter) {
        return entityManager.contains(spitter);
    }


}
