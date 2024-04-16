package com.in28minutes.rest.webservices.restfullwebservices.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class SpringSecurityConfiguration {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .authorizeHttpRequests(
//                        auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                                .anyRequest().authenticated()
//                ).httpBasic(Customizer.withDefaults())
//                .sessionManagement(
//                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                ).csrf(AbstractHttpConfigurer::disable)
//                .build();
//    }

}
