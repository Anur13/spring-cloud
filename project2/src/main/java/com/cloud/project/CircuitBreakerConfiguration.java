package com.cloud.project;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CircuitBreakerConfiguration {

    @Bean
    CircuitBreaker circuitBreaker(CircuitBreakerRegistry registry) {
        return registry.circuitBreaker("circuitbreaker");
    }

    @Bean
    Retry serviceRetry(RetryRegistry registry) {
        return registry.retry("retry");
    }

    @Bean
    TimeLimiter serviceTimeLimiter(TimeLimiterRegistry registry) {
        return registry.timeLimiter("time limiter");
    }
}