package lt.donatasmart.playground.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User model")
public class User {
    
    @Schema(description = "User ID", example = "1")
    private int id;
    
    @Schema(description = "User name", example = "John Doe")
    private String name;
    
    @Schema(description = "User email", example = "john@example.com")
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}