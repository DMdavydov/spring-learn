package com.ddavydov.boot;

import com.ddavydov.entity.Customer;
import com.ddavydov.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        customerService.saveCustomer(Customer.builder().id(1L).firstName("test1").lastName("test1").email("tes1t@test.ru").build());
        customerService.saveCustomer(Customer.builder().id(2L).firstName("test2").lastName("test2").email("test2@test.ru").build());
        customerService.saveCustomer(Customer.builder().id(3L).firstName("test3").lastName("test3").email("test3@test.ru").build());
    }
}
