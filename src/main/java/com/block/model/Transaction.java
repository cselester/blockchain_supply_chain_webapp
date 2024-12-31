package com.block.model;

public class Transaction {
    private String transactionId;
    private String productId;
    private String sender;
    private String receiver;
    private String details;
    private long timestamp;

    // Constructors
    public Transaction() {}

    public Transaction(String transactionId, String productId, String sender, String receiver, String details, long timestamp) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.sender = sender;
        this.receiver = receiver;
        this.details = details;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
