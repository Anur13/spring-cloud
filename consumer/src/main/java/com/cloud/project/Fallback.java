package com.cloud.project;

import org.springframework.stereotype.Component;

@Component
public class Fallback implements ProducerClient {

    @Override
    public String getHelloWorld() {
        System.out.println("fallback");
        return "fallback";
    }

}