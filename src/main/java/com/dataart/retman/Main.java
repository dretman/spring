package com.dataart.retman;

import com.dataart.retman.db.dao.SpitterDAO;
import com.dataart.retman.domain.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        SpitterDAO spitterDao = (SpitterDAO) context.getBean("spitterDao");
        Spitter spitter = spitterDao.getSpitterById(1);
        System.out.println(spitter);
//        User user = (User) context.getBean("user");
//        System.out.println(user);
    }
}
