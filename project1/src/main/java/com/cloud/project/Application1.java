package com.cloud.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class Application1 {
	public static void main(String[] args) {
		SpringApplication.run(Application1.class, args);
	}
}
