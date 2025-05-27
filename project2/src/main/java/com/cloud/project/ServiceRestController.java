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
//    private final DiscoveryClient discoveryClient;
//    private final RestClient restClient;

//    public ServiceRestController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
//        this.discoveryClient = discoveryClient;
//        restClient = restClientBuilder.build();
//    }

    //    @GetMapping("helloEureka")
//    public String helloWorld() {
//        ServiceInstance serviceInstance = discoveryClient.getInstances("project1").get(0);
//        return restClient.get()
//                .uri(serviceInstance.getUri() + "/helloWorld")
//                .retrieve()
//                .body(String.class);
//    }
    @GetMapping("helloEureka")
    public String helloWorld() {
        return project1Client.getHelloWorld();
    }

}