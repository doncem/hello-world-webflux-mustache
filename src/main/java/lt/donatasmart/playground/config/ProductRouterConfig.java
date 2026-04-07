package lt.donatasmart.playground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(ProductHandler productHandler) {
        return route()
            .GET("/products/{id}", productHandler::getProduct)
            .POST("/products", productHandler::createProduct)
            .PUT("/products/{id}", productHandler::updateProduct)
            .DELETE("/products/{id}", productHandler::deleteProduct)
            .build();
    }
}