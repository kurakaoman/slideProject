package com.slide.project.demo.roles.customer;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {
    private CustomerRepository customerRepository;

    public CustomerDetailsServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails byName = customerRepository.findByName(username);
        return byName;
    }
//    @Transactional <-?????
    public Optional<Customer> getCustomerByCustomerId(long customerId)
    {
        return customerRepository.findById(customerId);//.orElseThrow(EntityNotFoundException::new); <-- ????
    }


}
