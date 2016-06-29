package com.dataart.retman.beans.impl.musical.instrument;

import com.dataart.retman.beans.impl.Instrument;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("key")
public class Piano implements Instrument {
    public void play() {
        System.out.println("PLINK PLINK PLINK");
    }
}
