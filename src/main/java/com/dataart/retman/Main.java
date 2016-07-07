package com.dataart.retman;

import com.dataart.retman.repo.HibernateSpitterRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFac");
        System.out.println(sessionFactory.getCurrentSession());
        HibernateSpitterRepository repository = (HibernateSpitterRepository) context.getBean("hibernateSpitterRepository");

    }
}
