package com.cloud.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServiceRestController {
    @Value("${test}")
    String test;

    @Value("${sad}")
    String sad;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        System.out.println("cool");

        return test;
    }

}