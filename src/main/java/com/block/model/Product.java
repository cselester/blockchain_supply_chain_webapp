package com.block.model;

public class Product {
    private String productId;
    private String name;
    private String description;
    private String status; // e.g., "In Transit", "Delivered"
    private long timestamp;

    // Constructors
    public Product() {}

    public Product(String productId, String name, String description, String status, long timestamp) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
