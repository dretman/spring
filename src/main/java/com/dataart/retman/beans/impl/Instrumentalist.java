package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Performer;
import com.dataart.retman.beans.StringedInstrument;
import com.dataart.retman.exception.PerformanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;

public class Instrumentalist implements Performer {
    private int age;
    private String song;
    @Inject
    @StringedInstrument
    private Instrument instrument;

    public void perform() throws PerformanceException {
        System.out.print("Instrumentalist age of " + age + "; Playing " + song + " : ");
        if (instrument != null)
            instrument.play();
        else
            System.out.println("No instrument were given");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

}
