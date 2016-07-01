package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Performer;
import com.dataart.retman.exception.PerformanceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static final Log LOG = LogFactory.getLog(Main.class);

    public static void main(String[] args) throws PerformanceException, InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol-autoproxy.xml");

//        Audience audience = (Audience) context.getBean("audience");
        Performer kenny = (Performer) context.getBean("kenny");
//        Instrument saxophone = (Instrument) context.getBean("saxophone");

//        Thinker volunteer = (Thinker) context.getBean("volunteer");
//        MindReader magician = (MindReader) context.getBean("magician");
//
//        volunteer.thinkOfSomething("Black cat is in a black car");
//        System.out.println(magician.getThoughts());

        kenny.perform();

    }
}
