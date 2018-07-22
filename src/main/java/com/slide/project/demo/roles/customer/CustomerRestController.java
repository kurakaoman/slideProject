package com.slide.project.demo.roles.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/v1/customer")
public class CustomerRestController {
    private final CustomerDetailsServiceImpl customerDetailsService;

    public CustomerRestController(CustomerDetailsServiceImpl customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @PostMapping("/newCustomer01")
    public Customer createCustomer01(@RequestBody Customer customer) {
        return customerDetailsService.create01(customer);
    }
}
