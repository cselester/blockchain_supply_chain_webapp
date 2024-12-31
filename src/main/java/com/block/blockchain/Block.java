package com.block.blockchain;

import com.block.utils.HashUtil;

public class Block {
    private String blockId;
    private String previousHash;
    private String data;
    private long timestamp;
    private String hash;

    public Block(String blockId, String previousHash, String data, long timestamp, String hash) {
        this.blockId = blockId;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = timestamp;
        this.hash = hash;
    }

    // Getter methods
    public String getBlockId() {
        return blockId;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getHash() {
        return hash;
    }

    // Setter methods (if needed)
    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    // Generate hash for the block (optional, using HashUtil)
    public void generateHash() {
        this.hash = HashUtil.generateHash(blockId + previousHash + data + timestamp);
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockId='" + blockId + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", timestamp=" + timestamp +
                ", hash='" + hash + '\'' +
                '}';
    }
}

