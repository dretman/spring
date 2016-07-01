package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Instrument;
import com.dataart.retman.beans.Performer;
import com.dataart.retman.exception.PerformanceException;

public class Instrumentalist implements Performer {
    private Instrument instrument;

    public void perform() throws PerformanceException, InterruptedException {
        if (instrument == null) {
            throw new PerformanceException();
        } else {
//            Thread.sleep(2000);
            instrument.play();
        }
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
