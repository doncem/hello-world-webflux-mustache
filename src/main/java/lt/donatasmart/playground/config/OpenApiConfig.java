package lt.donatasmart.playground.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Playground WebFlux API")
                        .version("1.0.0")
                        .description("Spring Boot 4 WebFlux API with Mustache templating and OpenAPI/Swagger documentation"));
    }
}