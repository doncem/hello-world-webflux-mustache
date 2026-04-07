import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.WebTestClient;
import reactor.core.publisher.Mono;

import static org.springframework.test.web.reactive.server.WebTestClient.assertThat;

@SpringBootTest
@AutoConfigureWebTestClient
public class UserIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetAllUsers() {
        webTestClient.get()
                .uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(); // You can further check the body for expected content
    }

    @Test
    void testGetUserById() {
        String userId = "1"; // Replace with valid user ID
        webTestClient.get()
                .uri("/users/{id}", userId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(); // Check body for expected user
    }

    @Test
    void testGetUserByInvalidId() {
        String invalidUserId = "9999"; // Assuming this ID does not exist
        webTestClient.get()
                .uri("/users/{id}", invalidUserId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }
}