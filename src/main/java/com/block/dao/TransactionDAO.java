package com.block.dao;

import com.block.model.Product;
import com.block.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transactions (transaction_id, product_id, sender, receiver, details, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, transaction.getTransactionId());
            stmt.setString(2, transaction.getProductId());
            stmt.setString(3, transaction.getSender());
            stmt.setString(4, transaction.getReceiver());
            stmt.setString(5, transaction.getDetails());
            stmt.setLong(6, transaction.getTimestamp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactionsByProductId(String productId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transactions WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                transactions.add(new Transaction(rs.getString("transaction_id"),
                        rs.getString("product_id"), rs.getString("sender"),
                        rs.getString("receiver"), rs.getString("details"),
                        rs.getLong("timestamp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
    
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transactions";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(rs.getString("transaction_id"),
                        rs.getString("product_id"), rs.getString("sender"),
                        rs.getString("receiver"), rs.getString("details"),
                        rs.getLong("timestamp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
    
    public static void main(String[] args) {
        // Create instances of ProductDAO and TransactionDAO
        ProductDAO productDAO = new ProductDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        // Create a new Product object to insert
        Product product = new Product("P001", "Product1", "Description of Product1", "Available", System.currentTimeMillis());

        // Insert the product into the database
        productDAO.addProduct(product);
        System.out.println("Product inserted successfully.");

        // Create a new Transaction object
        Transaction transaction = new Transaction("TXN001", "1", "Alice", "Bob", "Payment for product", System.currentTimeMillis());

        // Insert the transaction into the database
        transactionDAO.addTransaction(transaction);
        System.out.println("Transaction inserted successfully.");

        // Retrieve transactions for a specific product ID
        String productId = "P001";
        List<Transaction> transactions = transactionDAO.getTransactionsByProductId(productId);
        System.out.println("Transactions for product " + productId + ":");
        for (Transaction txn : transactions) {
            System.out.println(txn);
        }
    }
}
