package com.block.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.block.blockchain.*;
import com.block.dao.BlockDAO;

public class BlockDAO {

    // Method to add a new block into the database
    public void addBlock(Block block) {
        String sql = "INSERT INTO Block (block_id, previous_hash, data, timestamp, hash) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, block.getBlockId());
            stmt.setString(2, block.getPreviousHash());
            stmt.setString(3, block.getData());
            stmt.setLong(4, block.getTimestamp());
            stmt.setString(5, block.getHash());
            
            stmt.executeUpdate();
            System.out.println("Block inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Method to get all blocks from the database
    public List<Block> getAllBlocks() throws SQLException {
        List<Block> blocks = new ArrayList<>();
        String query = "SELECT * FROM Block";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String blockId = rs.getString("block_id");
                String previousHash = rs.getString("previous_hash");
                String data = rs.getString("data");
                long timestamp = rs.getLong("timestamp");
                String hash = rs.getString("hash");

                Block block = new Block(blockId, previousHash, data, timestamp, hash);
                blocks.add(block);
            }
        }
        return blocks;
    }
    
    public static void main(String[] args) {
        BlockDAO blockDAO = new BlockDAO();

        // Create a new block
        Block block = new Block("1", "0", "Genesis Block", System.currentTimeMillis(), "hash1");

        try {
            // Insert the block into the database
            blockDAO.addBlock(block);

            // Retrieve and print all blocks
            List<Block> blocks = blockDAO.getAllBlocks();
            System.out.println("All blocks in the database:");
            for (Block b : blocks) {
                System.out.println(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
