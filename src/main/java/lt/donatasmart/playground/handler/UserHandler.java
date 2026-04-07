package lt.donatasmart.playground.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    // Sample data for users
    private final List<User> users = Arrays.asList(
        new User(1, "Alice"),
        new User(2, "Bob"),
        new User(3, "Charlie")
    );

    // Method to handle GET requests for all users
    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        return ServerResponse.ok()
                .body(Flux.fromIterable(users), User.class);
    }

    // Method to handle GET request for user by ID
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        int userId = Integer.parseInt(request.pathVariable("id"));
        return Flux.fromIterable(users)
                .filter(user -> user.getId() == userId)
                .singleOrEmpty()
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}