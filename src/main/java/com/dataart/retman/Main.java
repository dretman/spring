package com.dataart.retman;

import com.dataart.retman.db.repository.SpitterRepository;
import com.dataart.retman.domain.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-component-scan.xml");
        SpitterRepository spitterRepository = (SpitterRepository) context.getBean("spitterRepositoryImpl");
        Spitter spitter = createSpitter();

//        spitterRepository.addSpitter(spitter);
        System.out.println(spitterRepository.retrieveSpitterById(spitter.getId()));
    }

    private static Spitter createSpitter() {
        Spitter spitter = new Spitter();

        spitter.setId(13);
        spitter.setUsername("toxa");
        spitter.setPassword("toxa1986");
        spitter.setFullName("Anton Kucin");
        spitter.setEmail("antonkucin@gmail.com");
        spitter.setUpdatedById(false);

        return spitter;
    }
}
