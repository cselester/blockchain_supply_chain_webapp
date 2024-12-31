package com.block.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.block.dao.ProductDAO;
import com.block.model.Product;
import com.block.*;

@SuppressWarnings("unused")
public class ProductDAO {

    public void addProduct(Product product) {
        String sql = "INSERT INTO Products (product_id, name, description, status, timestamp) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getProductId());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getStatus());
            stmt.setLong(5, product.getTimestamp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(String productId) {
        String sql = "SELECT * FROM Products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(rs.getString("product_id"), rs.getString("name"),
                        rs.getString("description"), rs.getString("status"),
                        rs.getLong("timestamp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to retrieve all products from the database
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product product = new Product(
                        rs.getString("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getLong("timestamp")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) throws SQLException {
        ProductDAO productDAO = new ProductDAO();

        // Create a sample Product
        Product product = new Product("1", "Product1", "This is the first product", "Available", System.currentTimeMillis());

        // Insert the product into the database
        productDAO.addProduct(product);
        System.out.println("Product inserted successfully.");

        // Retrieve the product by ID
        Product retrievedProduct = productDAO.getProductById("1");
        if (retrievedProduct != null) {
            System.out.println("Retrieved Product:");
            System.out.println("ID: " + retrievedProduct.getProductId());
            System.out.println("Name: " + retrievedProduct.getName());
            System.out.println("Description: " + retrievedProduct.getDescription());
            System.out.println("Status: " + retrievedProduct.getStatus());
            System.out.println("Timestamp: " + retrievedProduct.getTimestamp());
        } else {
            System.out.println("Product with ID 1 not found.");
        }

        // Retrieve all products from the database
        List<Product> allProducts = productDAO.getAllProducts();
        System.out.println("All products in the database:");
        for (Product p : allProducts) {
            System.out.println("ID: " + p.getProductId());
            System.out.println("Name: " + p.getName());
            System.out.println("Description: " + p.getDescription());
            System.out.println("Status: " + p.getStatus());
            System.out.println("Timestamp: " + p.getTimestamp());
            System.out.println("------------");
        }
    }
}

