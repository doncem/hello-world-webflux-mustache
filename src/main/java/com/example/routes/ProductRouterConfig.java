package com.example.routes;

import com.example.handlers.ProductHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductRouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(ProductHandler productHandler) {
        return route()
            .GET("/products", productHandler::getAllProducts)
            .GET("/products/{id}", productHandler::getProductById)
            .build();
    }
}