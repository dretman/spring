package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.MindReader;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.dataart.retman.beans.Thinker.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts){

    }

    @Before("thinking(thougts)")
    public void interceptThoughts(String thougts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thougts;
    }

    public String getThoughts() {
        return this.thoughts;
    }
}
