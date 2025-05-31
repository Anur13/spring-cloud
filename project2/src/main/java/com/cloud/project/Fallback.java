package com.cloud.project;

import org.springframework.stereotype.Component;

@Component
public class Fallback implements Project1Client {

    @Override
    public String getHelloWorld() {
        System.out.println("fallback");
        return "fallback";
    }

}