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
                .csrf() // wez crsf
                .disable() // wyłącz je czyli ajaxsowe requesty z innego serwera też beda działąć
                .authorizeRequests() // weź autoryzowanie requestów
                .antMatchers("/unauth/**", "/page/**") // wsyzstkie requesty  ... "/unauth/**", "/page/**"
//                .antMatchers("/**")
                .permitAll() // daj im wszystkim dostęp , bez autoryzacji
                .and() //i
                .authorizeRequests() //  wez autoryzacje requestów
                .anyRequest() // wszytkie requesty ( teraz już bez tych wyżej)
                .authenticated() // rządaj autoryzacju - czyli musisz być zalogowany
                .and()             // i
                .formLogin()        // wez formlogin - formularz logowania
                .loginPage("/page/loginLogout/loginLogout.html");  // przypisz mu takiego url-a .. teraz jak natrafi na url który wymaga autoryzacji przeneisie mnie do url-u z loginem
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();

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
