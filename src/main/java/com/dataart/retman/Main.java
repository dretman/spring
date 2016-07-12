package com.dataart.retman;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.domain.SpitterContainer;
import com.dataart.retman.repository.SpitterRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        SpitterRepository spitterRepository = (SpitterRepository) context.getBean("jpaSpitterRepository");

        SpitterContainer spitterContainer = (SpitterContainer) context.getBean("spitterContainer");
        Spitter spitter = spitterContainer.getSpitter();
        spitter.setId(3);
        spitterRepository.deleteSpitter(spitter);

    }
}
