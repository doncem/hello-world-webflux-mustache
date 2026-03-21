package lt.donatasmart.playground.controller;

import lt.donatasmart.playground.model.Product;
import lt.donatasmart.playground.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Product>> getProductById(@PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.fromValue(ResponseEntity.notFound().build()));
    }
}