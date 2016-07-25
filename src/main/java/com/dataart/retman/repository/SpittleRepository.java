package com.dataart.retman.repository;

import com.dataart.retman.domain.Spittle;
import com.dataart.retman.exception.DublicateSpittleMessageException;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);

    Spittle save(Spittle spittle) throws DublicateSpittleMessageException;

}
