import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
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
            .path("/users", builder -> builder
                .GET("/", userHandler::listUsers)
                .POST("/", userHandler::createUser)
                .GET("/{id}", userHandler::getUser)
                .PUT("/{id}", userHandler::updateUser)
                .DELETE("/{id}", userHandler::deleteUser)
            )
            .build();
    }
}