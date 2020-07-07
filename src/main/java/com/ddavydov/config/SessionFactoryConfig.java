package com.ddavydov.config;

import com.ddavydov.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionFactoryConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
    }
}
