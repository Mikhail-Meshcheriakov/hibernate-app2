package ru.geekbrains.hibernate.app2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GlobalSessionFactory {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }

    @PostConstruct
    private void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
