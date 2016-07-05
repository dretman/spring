package com.dataart.retman;

import com.dataart.retman.beans.Poem;
import com.dataart.retman.exception.PerformanceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static final Log LOG = LogFactory.getLog(Main.class);

    public static void main(String[] args) throws PerformanceException, InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol-component-scan.xml");
        Poem poem = (Poem) context.getBean("sonnet29");
        poem.recite();
    }
}
