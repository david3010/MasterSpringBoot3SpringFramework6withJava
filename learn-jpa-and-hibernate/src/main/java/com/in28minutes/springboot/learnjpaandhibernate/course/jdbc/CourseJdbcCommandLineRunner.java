package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
//        courseJdbcRepository.insert(new Course(1, "Learn AWS!!", "in28minutes"));
//        courseJdbcRepository.insert(new Course(2, "Learn Azure!!", "in28minutes"));
//        courseJdbcRepository.insert(new Course(3, "Learn Devops!!", "in28minutes"));
//
//        courseJdbcRepository.deleteById(2);
//        Course course = courseJdbcRepository.findById(1);
//        course.setAuthor("David G");
//        course.setName("Spring learn");
//        courseJdbcRepository.update(course);
    }
}
