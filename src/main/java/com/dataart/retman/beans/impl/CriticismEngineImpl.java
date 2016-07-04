package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.CriticismEngine;

public class CriticismEngineImpl implements CriticismEngine {
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }

    public String getCriticism() {
        return criticismPool[(int) (Math.random() * criticismPool.length)];
    }
}
