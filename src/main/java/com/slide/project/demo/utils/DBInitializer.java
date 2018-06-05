package com.slide.project.demo.utils;

import com.slide.project.demo.roles.customer.Customer;
import com.slide.project.demo.roles.customer.CustomerRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInitializer {
    private CustomerRepository customerRepository;

    public DBInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    private void initializerDB() {
        customerRepository.save(new Customer("Joe","Doe","joed@gmail.com",23,"kopytko"));
        customerRepository.save(new Customer("Ian","Ho","ihod@gmail.com",33,"kotara557"));
    }
}
