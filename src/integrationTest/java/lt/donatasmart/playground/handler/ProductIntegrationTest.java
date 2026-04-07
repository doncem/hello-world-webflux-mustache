import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.WebTestClient;
import reactor.core.publisher.Mono;

import static org.springframework.test.web.reactive.server.WebTestClient.bindToServer;
import static org.springframework.test.web.reactive.server.WebTestClient.*;
import static org.springframework.test.web.reactive.server.WebTestClient.bindToServer;

@SpringBootTest
@AutoConfigureWebTestClient
public class ProductIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetAllProducts() {
        webTestClient.get()
                .uri("/products")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$._embedded.products").isNotEmpty();
    }

    @Test
    public void testGetProductById() {
        String productId = "1"; // Assuming product with ID 1 exists
        webTestClient.get()
                .uri("/products/{id}", productId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").isEqualTo(productId);
    }

    @Test
    public void testGetProductByInvalidId() {
        String invalidProductId = "99999"; // Assuming this ID does not exist
        webTestClient.get()
                .uri("/products/{id}", invalidProductId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.error").isEqualTo("Product not found");
    }

    @Test
    public void testGetProductByEmptyId() {
        String emptyProductId = "";
        webTestClient.get()
                .uri("/products/{id}", emptyProductId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isBadRequest();
    }
}