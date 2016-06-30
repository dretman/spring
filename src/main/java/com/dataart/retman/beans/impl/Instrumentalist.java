package com.dataart.retman.beans.impl;

import com.dataart.retman.annotation.Key;
import com.dataart.retman.beans.Instrument;
import com.dataart.retman.beans.Performer;
import com.dataart.retman.exception.PerformanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("eddie")
public class Instrumentalist implements Performer {
    @Autowired
    @Key
    private Instrument instrument;

    public void perform() throws PerformanceException {
        if (instrument == null) {
            System.out.println("Without instrumen");
        } else {
            instrument.play();
        }
    }
}
