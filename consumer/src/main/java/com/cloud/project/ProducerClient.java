package com.cloud.project;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="project1", fallback  = Fallback.class)
public interface ProducerClient {

 @GetMapping("/helloWorld")
  String  getHelloWorld();
}


