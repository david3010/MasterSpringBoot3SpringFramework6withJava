package com.in28minutes.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CurrencyServiceConfiguration currencyServiceConfiguration;

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        System.out.println(currencyServiceConfiguration.getUrl());
        return Arrays.asList(
                new Course(1, "AWS", "David"),
                new Course(2, "Azure", "Mark"),
                new Course(2, "Azure", "Mark 2"),
                new Course(2, "Google Cloud", "Mark 2")
        );
    }
}
