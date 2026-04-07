import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import your.package.path.UserHandler; // Make sure to replace with actual package path

public class UserRouterConfig {

    public RouterFunction<ServerResponse> routes(UserHandler userHandler) {
        return route()
            .GET("/users", userHandler::listUsers)
            .GET("/users/{id}", userHandler::getUser)
            .POST("/users", userHandler::createUser)
            .PUT("/users/{id}", userHandler::updateUser)
            .DELETE("/users/{id}", userHandler::deleteUser)
            .build();
    }
}