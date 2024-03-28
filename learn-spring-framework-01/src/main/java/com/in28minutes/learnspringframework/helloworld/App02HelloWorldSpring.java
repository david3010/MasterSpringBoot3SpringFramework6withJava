package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1: Launch a Spring Context
        try (var springContext = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2: Configure the things that we want SpringFramework to manage
            // - HelloWorldConfiguration - @ConfigurationClass
            // fullName - @Bean

            // 3: Retrieve beans managed by Spring
            Person person = (Person) springContext.getBean("person");
            System.out.println(person.name());
            System.out.println(person.age());
            System.out.println(springContext.getBean("person2"));
            System.out.println(springContext.getBean("address2"));
            System.out.println(springContext.getBean(Address.class));
            System.out.println(springContext.getBean("address3"));

            Arrays.stream(springContext.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
