package lt.donatasmart.playground.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product model")
public class Product {
    
    @Schema(description = "Product ID", example = "1")
    private int id;
    
    @Schema(description = "Product name", example = "Laptop")
    private String name;
    
    @Schema(description = "Product price", example = "999.99")
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}