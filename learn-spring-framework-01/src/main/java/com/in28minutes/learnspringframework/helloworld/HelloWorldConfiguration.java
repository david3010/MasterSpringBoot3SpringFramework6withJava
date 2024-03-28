package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age) {
}

record Address(String firstLine, String city) {
}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String fullName() {
        return "David";
    }

    @Bean
    public int age() {
        return 29;
    }

    @Bean
    public Person person() {
        return new Person("David Gallegos", 29);
    }

    @Bean
    public Person person2() {
        return new Person(fullName(), age());
    }

    @Primary
    @Bean(name = "address2")
    public Address address2() {
        return new Address("Mi casa", "Monterrey");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Mi casa", "Monterrey");
    }
}
