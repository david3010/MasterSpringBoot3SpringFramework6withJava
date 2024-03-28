package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
//        courseJpaRepository.save(new Course(1, "Learn AWS!!", "in28minutes"));
//        courseJpaRepository.save(new Course(2, "Learn Azure!!", "in28minutes"));
//        courseJpaRepository.save(new Course(3, "Learn Devops!!", "in28minutes"));
//        courseJpaRepository.save(new Course(4, "Learn Docker!!", "in28minutes"));
//
//        Course course = courseJpaRepository.findById(1);
//        course.setAuthor("David G");
//        course.setName("Spring learn");
//        Course courseUpdated = courseJpaRepository.save(course);
//        System.out.println("courseUpdated = " + courseUpdated);
    }
}
