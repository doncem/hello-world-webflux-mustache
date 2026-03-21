package lt.donatasmart.playground.service;

import lt.donatasmart.playground.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    
    private final List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
        // Mock data
        products.add(new Product(1, "Laptop", 999.99));
        products.add(new Product(2, "Mouse", 29.99));
        products.add(new Product(3, "Keyboard", 79.99));
    }

    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(products);
    }

    public Mono<Product> getProductById(int id) {
        return Mono.fromCallable(() -> 
            products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null)
        ).filter(p -> p != null);
    }
}