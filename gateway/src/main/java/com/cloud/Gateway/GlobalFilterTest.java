package com.cloud.Gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilterTest implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (isAuthRoute(exchange) && !isAuthorization(exchange)) {
//            Spring Cloud Gateway Does Not Use Traditional Exception Handling
//
//            When an exception is thrown in a GlobalFilter, it does not automatically result in a proper HTTP response with the expected status code.
//            Instead, the request fails with a generic 500 Internal Server Error, or it is handled by the default error handler.

            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND); // Set 404 manually
            return exchange.getResponse().setComplete(); // Stop further processing

//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Authorization header missing"); alternative
        }

        return chain.filter(exchange);
    }

    private static boolean isAuthorization(ServerWebExchange exchange) {
        return exchange.getRequest().getHeaders().containsKey("Authorization");
    }

    private static boolean isAuthRoute(ServerWebExchange exchange) {
        return exchange.getRequest().getURI().getPath().equals("/project/test");
    }

    @Override
    public int getOrder() {
        return -10; // Runs before Spring Cloud Gateway's default filters
    }
}