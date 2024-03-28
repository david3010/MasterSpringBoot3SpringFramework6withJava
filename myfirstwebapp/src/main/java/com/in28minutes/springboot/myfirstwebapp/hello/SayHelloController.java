package com.in28minutes.springboot.myfirstwebapp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    private final Logger logger = LoggerFactory.getLogger(SayHelloController.class);

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        logger.error("Saying Hello controller - INFO");
        return "Hello World";
    }

    @RequestMapping("/hello-in-html")
    public String sayHelloWorld() {
        return "hello";
    }
}
