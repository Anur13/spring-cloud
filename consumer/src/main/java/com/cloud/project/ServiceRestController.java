package com.cloud.project;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServiceRestController {

    final ProducerClient producerClient;
    @GetMapping("helloEureka")
    public String helloWorld() {

        return producerClient.getHelloWorld();
    }

}