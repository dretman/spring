package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.MindReader;

public class Magician implements MindReader {
    private String thoughts;

    public void interceptThoughts(String thougts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thougts;
    }

    public String getThoughts() {
        return this.thoughts;
    }
}
