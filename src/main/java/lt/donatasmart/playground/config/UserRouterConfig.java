package lt.donatasmart.playground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;

@Configuration
public class UserRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> userRoutes() {
        return route()
            .GET("/users", request -> ok().bodyValue("Get all users"))
            .GET("/users/{id}", request -> ok().bodyValue("Get user with ID: " + request.pathVariable("id")))
            .POST("/users", request -> ok().bodyValue("Create a user"))
            .PUT("/users/{id}", request -> ok().bodyValue("Update user with ID: " + request.pathVariable("id")))
            .DELETE("/users/{id}", request -> ok().bodyValue("Delete user with ID: " + request.pathVariable("id")))
            .build();
    }
}
