package com.cloud.project;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequiredArgsConstructor
public class ServiceRestController {

    final Project1Client project1Client;
    @GetMapping("helloEureka")
    public String helloWorld() {

        return project1Client.getHelloWorld();
    }

}