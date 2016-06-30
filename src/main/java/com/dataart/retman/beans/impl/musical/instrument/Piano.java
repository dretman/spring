package com.dataart.retman.beans.impl.musical.instrument;

import com.dataart.retman.annotation.Key;
import com.dataart.retman.beans.Instrument;

@Key
public class Piano implements Instrument {
    public void play() {
        System.out.println("PLINK PLINK PLINK");
    }
}
