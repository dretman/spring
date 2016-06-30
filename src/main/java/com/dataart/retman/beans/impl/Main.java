package com.dataart.retman.beans.impl;

import com.dataart.retman.exception.PerformanceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws PerformanceException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol-component-scan.xml");
        String beanName = "instrumentalist";
        beanName = "eddie";
        Instrumentalist kenny = (Instrumentalist) context.getBean(beanName);
        kenny.perform();

    }
}
