package com.slide.project.demo;

import com.slide.project.demo.roles.admin.AdminDetailsServiceImpl;
import com.slide.project.demo.roles.customer.CustomerDetailsServiceImpl;
import com.slide.project.demo.roles.manager.ManagerDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration//
@EnableWebSecurity//
@EnableGlobalMethodSecurity(securedEnabled = true)// potrrzebne do @Secured("ROLE_XXX" która ogranicza dostęp do poszczególnych metod dla odpowiednich rul
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService customerDetailsService;
    private UserDetailsService managerDetailsService;
    private UserDetailsService adminDetailsService;

    public WebSecurityConfig(CustomerDetailsServiceImpl customerDetailsService, ManagerDetailsServiceImpl managerDetailsService, AdminDetailsServiceImpl adminDetailsService) {
        this.customerDetailsService = customerDetailsService;
        this.managerDetailsService = managerDetailsService;
        this.adminDetailsService = adminDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/unauth/**", "/page/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerDetailsService);
        auth.userDetailsService(managerDetailsService);
        auth.userDetailsService(adminDetailsService);
    }
    // Sprawia, że hasła nie są szyfrowane. - zastanów się czy tego nie usunąć
    @Bean
    public PasswordEncoder noopPaswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
