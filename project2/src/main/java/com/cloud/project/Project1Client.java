package com.cloud.project;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("project1")
public interface Project1Client {

 @GetMapping("/helloWorld")
  String  getHelloWorld();
}
