package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Knight;
import com.dataart.retman.beans.Performer;
import com.dataart.retman.exception.PerformanceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main1(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        Knight knight = (Knight) context.getBean("braveKnight");
        knight.embarkOnQuest();
    }

    public static void main(String[] args) throws PerformanceException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");
        Performer performer = (Performer) context.getBean("duke");
        performer.perform();
    }
}
