package com.dataart.retman.repository.impl;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.repository.SpitterSweeper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SpitterRepositoryImpl implements SpitterSweeper {
    private static final Log LOG = LogFactory.getLog(SpitterRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Cacheable(value = "spittleCache", key = "#id")
    public Spitter customMethod(long id) {
        System.out.println("----------------------------------");
        System.out.println("customMethod invocation");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            LOG.error("sleep", e);
        }
        return entityManager.find(Spitter.class, id);
    }
}
