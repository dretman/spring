package com.dataart.retman.repository.impl;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.repository.SpitterRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void addSpitter(Spitter spitter) {
        entityManagerFactory.createEntityManager().persist(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return entityManagerFactory.createEntityManager().find(Spitter.class, id);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        entityManagerFactory.createEntityManager().merge(spitter);
    }

    @Override
    public void deleteSpitter(Spitter spitter) {
        entityManagerFactory.createEntityManager().remove(spitter);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean contains(Spitter spitter) {
        return entityManagerFactory.createEntityManager().contains(spitter);
    }


}
