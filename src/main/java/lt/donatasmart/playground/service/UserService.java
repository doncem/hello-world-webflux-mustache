package lt.donatasmart.playground.service;

import lt.donatasmart.playground.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    
    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
        // Mock data
        users.add(new User(1, "John Doe", "john@example.com"));
        users.add(new User(2, "Jane Smith", "jane@example.com"));
        users.add(new User(3, "Bob Johnson", "bob@example.com"));
    }

    public Flux<User> getAllUsers() {
        return Flux.fromIterable(users);
    }

    public Mono<User> getUserById(int id) {
        return Mono.fromCallable(() -> 
            users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null)
        ).filter(u -> u != null);
    }
}