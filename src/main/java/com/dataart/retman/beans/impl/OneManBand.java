package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Performer;
import com.dataart.retman.exception.PerformanceException;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class OneManBand implements Performer {
    private Properties instruments;

    public void perform() throws PerformanceException {
        for (Object key : instruments.keySet()) {
            String sound = (String) instruments.get(key);
            System.out.println("Key : " + key + " : " + sound);
        }
    }

    public void setInstruments(Properties instruments) {
        this.instruments = instruments;
    }
}
