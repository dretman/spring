package com.dataart.retman;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.domain.SpitterContainer;
import com.dataart.retman.repository.SpitterRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        SpitterRepository spitterRepository = (SpitterRepository) context.getBean("spitterRepository");

        SpitterContainer spitterContainer = (SpitterContainer) context.getBean("spitterContainer");
        Spitter spitter = spitterContainer.getSpitter();
        System.out.println("----------------------------------");

        for (Spitter spitter1 : spitterRepository.findAllGmailSpitters())
            System.out.println(spitter1);
    }
}
