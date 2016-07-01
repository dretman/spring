package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Thinker;

public class Volunteer implements Thinker {
    private String thoughts;

    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThougts() {
        return thoughts;
    }

}
