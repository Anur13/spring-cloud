package com.cloud.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceRestController {
    @Value("${test}")
    String test;

    @Value("${sad}")
    String sad;

    @GetMapping("/helloWorld")
    public String helloWorld() {

        System.out.println(test);
        System.out.println(sad);

        return "Hello world from Service A!";
    }

}