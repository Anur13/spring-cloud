package com.cloud.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application2 {
	public static void main(String[] args) {
		SpringApplication.run(Application2.class, args);
	}
}
