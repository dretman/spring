package com.dataart.retman.repository;

import com.dataart.retman.domain.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
