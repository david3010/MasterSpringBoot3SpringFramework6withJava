package com.in28minutes.rest.webservices.restfullwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // ALL REQUEST SHOULD BE AUTHENTICATED
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // IF A REQUEST ARE NOT AUTHENTICATED, A WEB PAGE IS SHOWN
        httpSecurity.httpBasic(Customizer.withDefaults());
        // DISABLE CSRF TOKEN ONLY FOR RESTFUL APPS FOR MVC ARE NECESSARY
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }
}
