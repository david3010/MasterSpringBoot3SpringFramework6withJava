package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Microservices in 100 Steps", "Ranga Karanam"));
        repository.save(new Course(2, "React in 100 Steps", "Ranga Karanam"));
        repository.save(new Course(3, "Spring in 100 Steps", "David Gallegos"));
        repository.save(new Course(4, "Spring Boot in 100 Steps", "Ranga Karanam"));
        repository.save(new Course(5, "Devops in 100 Steps", "David Gallegos"));
        System.out.println("Courses: " + repository.findAll());
        System.out.println("Course id 1: " + repository.findById(Long.parseLong("1")));
        repository.deleteById(Long.parseLong("1"));
        List<Course> courses = repository.findAll();
        courses.add(new Course(5, "Spring Boot in 100 Steps", "Ranga Karanam"));
        repository.findByAuthor("David Gallegos").forEach(System.out::println);
        repository.findByName("Microservices").forEach(System.out::println);
        System.out.println("===================================");
        courses.forEach(System.out::println);
    }
}
