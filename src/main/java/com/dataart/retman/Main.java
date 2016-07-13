package com.dataart.retman;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.domain.SpitterContainer;
import com.dataart.retman.repository.SpitterRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext context = context = new AnnotationConfigApplicationContext(Config.class);
        SpitterRepository spitterRepository = (SpitterRepository) context.getBean("spitterRepository");

        SpitterContainer spitterContainer = (SpitterContainer) context.getBean("spitterContainer");
        Spitter spitter = spitterContainer.getSpitter();

        System.out.println("----------------------------------");

        Spitter createdSpitter = spitterRepository.save(spitter);

        System.out.println(createdSpitter);

        spitterRepository.deleteById(createdSpitter.getId());

        System.out.println("----------------------------------");

        System.out.println(spitterRepository.customMethod(createdSpitter.getId()));
        System.out.println(spitterRepository.customMethod(createdSpitter.getId()));
        System.out.println(spitterRepository.customMethod(createdSpitter.getId()));


    }
}
