package com.dataart.retman.repository.impl;

import com.dataart.retman.SpittleGenerator;
import com.dataart.retman.domain.Spittle;
import com.dataart.retman.repository.SpittleRepository;

import java.util.List;

public class SpittleRepositoryImpl implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        return SpittleGenerator.generateSpittleList(count);
    }

    public Spittle findOne(long spittleId) {
        return SpittleGenerator.generateSpittleList(1).get(0);
    }
}
