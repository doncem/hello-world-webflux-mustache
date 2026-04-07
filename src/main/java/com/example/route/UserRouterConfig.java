import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRouterConfig {

    private final UserHandler userHandler;

    public UserRouterConfig(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> userRoutes() {
        return route()
            .GET("/users", userHandler::getAllUsers)
            .GET("/users/{id}", userHandler::getUserById)
            .POST("/users", userHandler::createUser)
            .PUT("/users/{id}", userHandler::updateUser)
            .DELETE("/users/{id}", userHandler::deleteUser)
            .build();
    }
}